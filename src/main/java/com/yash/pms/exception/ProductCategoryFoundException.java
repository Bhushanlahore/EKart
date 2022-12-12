package com.yash.pms.exception;

public class ProductCategoryFoundException extends Exception{

	
	public ProductCategoryFoundException() {
        super("This product sub category is already there in DB !! try with another one");
    }

    public ProductCategoryFoundException(String msg)
    {
        super(msg);
    }
}
