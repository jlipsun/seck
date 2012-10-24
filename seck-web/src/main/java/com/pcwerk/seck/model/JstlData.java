package com.pcwerk.seck.model;

public class JstlData
{
	String value = "";
	public JstlData(String value)	
	{
		this.value = value;
	}
	
	public void setValue(String value)
	{
		this.value = value;		
	}
	
	public String getValue()
	{
		return value;
		
	}
}