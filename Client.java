import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException,ClassNotFoundException{
	try{
	    Socket clientSocket= new Socket("localhost",1234);
	    Scanner scanner=new Scanner(System.in);
	    OutputStream outputStream= clientSocket.getOutputStream();
	    ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
	  

	    System.out.println("LOGIN:");
	    String user_Message= scanner.nextLine();
	    user_Message=user_Message.toUpperCase();
	    Message m=new Message();
	    m.setType(user_Message);
	    System.out.println("Sending Message to Server!!");
	    objectOutputStream.writeObject(m);

	    ObjectInputStream objectInputStream=new ObjectInputStream(clientSocket.getInputStream());
	    Message fromServertoClient=(Message) objectInputStream.readObject();

	    if(fromServertoClient.getType().compareTo("Successful Login")==0)
		{
		    String fromServer=fromServertoClient.getType();
		    System.out.println("Message from Server: "+ fromServer);
		}
	    
	}
    catch(IOException e)
	{
	    e.printStackTrace();
	}
    }
}
