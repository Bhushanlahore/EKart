/*This is  companycontroller class. from this class we navigate to many methods
 * that perform company operations.
 * its has various mapping like getmapping, putmapping, deletemapping to perform operations
 * on company*/

package com.yash.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pms.model.product.Company;
import com.yash.pms.services.CompanyService;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	
	//add the company
	@PostMapping("/")
	public ResponseEntity<Company> add(@RequestBody Company company) throws Exception{
		
		Company company2 = this.companyService.addCompany(company);
		return ResponseEntity.ok(company2);
	}
	
	//update the company
	@PutMapping("/")
	public Company update(@RequestBody Company company) {
		return this.companyService.updateCompany(company);
	}
	
	//get all companies
	@GetMapping("/")
	public ResponseEntity<?> getCompanies(Company company){
		return ResponseEntity.ok(this.companyService.getCompanies());
	}
	
	//get one company by id
	@GetMapping("/{companyId}")
	public Company get(@PathVariable("companyId") Long companyId) {
		return this.companyService.getCompany(companyId);
	}
	
	//delete the company by id
	@DeleteMapping("/{companyId}")
	public void delete(@PathVariable("companyId") Long companyId) {
		this.companyService.deleteCompany(companyId);
	}
}
