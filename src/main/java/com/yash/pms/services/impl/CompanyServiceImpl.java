/*this is companyservice implementation class which implements companyservice
 * we write our actual logic in this class
 * */

package com.yash.pms.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms.exception.CompanyFoundException;
import com.yash.pms.model.product.Company;
import com.yash.pms.repository.CompanyRepository;
import com.yash.pms.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	//add companies
	//no duplicate companies
	@Override
	public Company addCompany(Company company) throws Exception {
		// TODO Auto-generated method stub
		Company localCompany = this.companyRepository.findCompanyByName(company.getName());
		if(localCompany != null) {
			System.out.println("Company present");
			throw new CompanyFoundException();
		}else {
			localCompany = this.companyRepository.save(company);
		}
		return localCompany;
	}

	//update company
	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return this.companyRepository.save(company);
	}

	//get companies
	@Override
	public Set<Company> getCompanies() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.companyRepository.findAll());
	}

	//get single company by id
	@Override
	public Company getCompany(Long companyId) {
		// TODO Auto-generated method stub
		return this.companyRepository.findById(companyId).get();
	}

	//delete company by id
	@Override
	public void deleteCompany(Long companyId) {
		
		this.companyRepository.deleteById(companyId);
		
	}

}
