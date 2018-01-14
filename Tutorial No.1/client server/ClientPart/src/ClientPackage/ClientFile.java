package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientFile {

	Socket s;
    DataInputStream din;
    DataOutputStream dout;
    
    public static void main(String as[])
    {
        new ClientFile(); 
    }

    
    public ClientFile()
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
     public void ClientChat() throws IOException
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
