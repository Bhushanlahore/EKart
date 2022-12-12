/* this is companyrepository interface which extend jparepository
 * We use  methods of jparepository
 * */

package com.yash.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms.model.product.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	//find company by name
	public Company findCompanyByName(String name);
}
