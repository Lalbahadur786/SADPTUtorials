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
		try {
			ServerSocket ss=new ServerSocket(10);
			while(true)
			{
				
			Socket s= null;
		try
		{
			s=ss.accept();
			System.out.println("A new client is connected : " + s);
			dis= new DataInputStream(s.getInputStream());
			dos= new DataOutputStream(s.getOutputStream());
			System.out.println("Assigning new thread for this client");
            Thread t = new Calculatorthread(s, dis, dos);
            t.start(); 
		}
		catch(Exception e){
			System.out.println(e);
		}
			}
		}catch(Exception e){};
	}
	protected class Calculatorthread extends Thread{
		Socket s;
		DataInputStream din;
		DataOutputStream dos;
		public Calculatorthread(Socket s,DataInputStream din,DataOutputStream dos){
			this.s=s;
			this.din=din;
			this.dos=dos;
		}
		public void run(){
			try{
				do{
					String exp=din.readUTF();
					BasicCalculator cal=new BasicCalculator();
					dos.writeUTF(cal.evaluate(exp)+"");
					dos.writeUTF("Do you want to continue(Y/N)");
				}while(din.readUTF().equals("Y"));
			}
			catch(Exception e){}
		}
}
}
