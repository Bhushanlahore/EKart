package com.yash.pms.exception;

public class CompanyFoundException extends Exception{

	
	public CompanyFoundException() {
        super("This product sub category is already there in DB !! try with another one");
    }

    public CompanyFoundException(String msg)
    {
        super(msg);
    }
}
