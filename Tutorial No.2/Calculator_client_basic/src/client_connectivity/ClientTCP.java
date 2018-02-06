package client_connectivity;
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientTCP {
	protected Socket s;
    protected DataInputStream din;
    protected DataOutputStream dout;	
    public ClientTCP()
    {
    try
    {
       
        s=new Socket("localhost",10);
        //System.out.println(s);
        din= new DataInputStream(s.getInputStream());
        dout= new DataOutputStream(s.getOutputStream());
        ClientChat();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }
    void ClientChat() throws IOException
    {
   	 String choice;
	

   	 do{
   		 Scanner scan=new Scanner(System.in);
   		 System.out.println("Enter the Expression : ");
   		 String exp=scan.nextLine();
   		 dout.writeUTF(exp);
   		 System.out.println(din.readUTF());
   		 String servermsg=din.readUTF();
   		 System.out.println(servermsg);
   		 choice=scan.next();
   		 dout.writeUTF(choice);
   		 dout.flush();     
   	 }while(choice.equals("Y"));
   }
}
