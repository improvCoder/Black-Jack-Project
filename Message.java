/*
Author:Sandeep
Version: 1.00 , 4/8/2024
Beta Message Version
*/

import java.io.Serializable;


public class Message implements Serializable{
    protected String type;

    
    public Message()
    {
	this.type="Undefined";
    }

    public void setType(String type)
    {
	this.type=type;
    }

    public String getType()
    {
	return this.type;
    }
}
