/* this is companyservice interface which contains methods that we use for operations
 * companyserviceimpl class implemetns this companyservice
 * */

package com.yash.pms.services;

import java.util.Set;

import com.yash.pms.model.product.Company;

public interface CompanyService {

	//add company
	public Company addCompany(Company company) throws Exception;
	
	//update company
	public Company updateCompany(Company company);
	
	//get all companies
	public Set<Company> getCompanies();
	
	//get company by id
	public Company getCompany(Long companyId);
	
	//delete company by id
	public void deleteCompany(Long companyId);
}
