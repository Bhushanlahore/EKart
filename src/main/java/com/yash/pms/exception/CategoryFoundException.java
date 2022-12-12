package com.yash.pms.exception;

public class CategoryFoundException extends Exception{

	
	public CategoryFoundException() {
        super("This category is already there in DB !! try with another one");
    }

    public CategoryFoundException(String msg)
    {
        super(msg);
    }
}

