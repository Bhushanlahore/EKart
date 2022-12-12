
/*
 * This is the category model class which contains all the field of category class
 * it also contain getter/setter method and constructor
 * */

package com.yash.pms.model.product;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
@SQLDelete(sql = "UPDATE category SET is_deleted = true WHERE cid=?")
@Where(clause = "is_deleted=false")
public class Category {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private String name;
	private String description;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date dateUpdated;
	
	private boolean isDeleted = false;
	
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> pc = new HashSet<>();
	
	
	public Category() {
		
	}


	public Category(String name, String description, Date dateCreated, Date dateUpdated, boolean isDeleted,
			Set<Product> pc) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.isDeleted = isDeleted;
		this.pc = pc;
	}






	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	public Date getDateUpdated() {
		return dateUpdated;
	}


	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}


	public Set<Product> getPc() {
		return pc;
	}

	public void setPc(Set<Product> pc) {
		this.pc = pc;
	}

	

	}
