package com.myrestapi.objects;

public class Response 
{
	private String message;
	private boolean success;
	private Book payload;
	
	public Response(String message, boolean success, Book payload)
	{
		this.message = message;
		this.success = success;
		this.payload = payload;
	}
	
	public Response(String message, boolean success)
	{
		this(message, success, null);
	}

	public String getMessage() 
	{
		return message;
	}

	public boolean isSuccess() 
	{
		return success;
	}

	public Book getPayload() 
	{
		return payload;
	}
	
	
}
