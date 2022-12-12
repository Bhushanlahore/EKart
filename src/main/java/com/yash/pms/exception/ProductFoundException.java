package com.yash.pms.exception;

public class ProductFoundException extends Exception{

	
	public ProductFoundException() {
        super("This product is already there in DB !! try with another one");
    }

    public ProductFoundException(String msg)
    {
        super(msg);
    }
}
