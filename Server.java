/*
Author:Sandeep
Version: 1.00 , 4/8/2024
Beta Server Version
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public class Server{
    public static void main(String[] args) throws IOException{//,ClassNotFoundException{

	ServerSocket serverSocket=null;
	try{
	     serverSocket= new ServerSocket(1234);
	     serverSocket.setReuseAddress(true);
	     Socket client=serverSocket.accept();
	     
	     ObjectInputStream objectInputStream=new ObjectInputStream(client.getInputStream());
	     Message fromClient=(Message) objectInputStream.readObject();
	     System.out.println("From Cleint:"+fromClient.getType());
	     
	    OutputStream outputStream=client.getOutputStream();
	   
	    ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
	    
	    Message fromServer=new Message();
	    System.out.println("Sending to Client!");
	    fromServer.setType("Successful Login");
	    if(fromClient.getType().compareTo("LOGIN")==0)
		{
		    objectOutputStream.writeObject(fromServer);
		}
	    
	}
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
		catch(ClassNotFoundException e)
	  {
			e.printStackTrace();
	  }
    }
}
