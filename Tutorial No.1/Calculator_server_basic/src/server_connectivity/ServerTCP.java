package server_connectivity;
import calculator_logic.*;
import java.io.*;
import java.net.*;
public class ServerTCP {
	protected ServerSocket ss;
        protected Socket s;
	protected DataInputStream dis;
	protected DataOutputStream dos;
	public static void main(String[] args) {
		new ServerTCP();
	}
	public ServerTCP()
	{
		try
		{
			System.out.println("Server Started");
			ss=new ServerSocket(10);
			s=ss.accept();
			System.out.println(s);
			System.out.println("Client Connected");
			dis= new DataInputStream(s.getInputStream());
			dos= new DataOutputStream(s.getOutputStream());
			ServerChat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	protected void ServerChat() throws IOException
	{
		do{  
			BasicCalculator cal=new BasicCalculator();
			String expression=dis.readUTF();
			double answer=cal.evaluate(expression);
			String res=Double.toString(answer);
			dos.writeUTF(res);
			String conmsg="Do you want to continue:Y/N";
			dos.writeUTF(conmsg);
            dos.flush();
		}while(dis.readUTF().equals("Y"));
	}
}
