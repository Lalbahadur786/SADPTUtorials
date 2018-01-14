package ServerPackage;
import java.io.*;
import basic_calculator.*;
import java.net.*;
import java.util.Stack;
import java.util.*;

public class ServerPart {
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public static void main(String[] args) {
		new ServerPart();
	}
	public ServerPart()
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

	public void ServerChat() throws IOException
	{
		do{
			int c=0;
			String resmsg;     
			CalculatorLogic cal=new CalculatorLogic();
			String expression=dis.readUTF();
			int answer=cal.evaluate(expression);
			String res=Integer.toString(answer);
			dos.writeUTF(res);
			String conmsg="Do you want to continue:Y/N";
			dos.writeUTF(conmsg);

			dos.flush();
		}while(dis.readUTF().equals("Y"));
	}
	/*public static int evaluate(String expression)
	{
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++)
		{
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}
			else if (tokens[i] == '(')
				ops.push(tokens[i]);
			else if (tokens[i] == ')')
			{
				while (ops.peek() != '(')
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}
			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/')
			{
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.push(tokens[i]);
			}
		}
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		return values.pop();
	}
	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	public static int applyOp(char op, int b, int a)
	{
		switch (op)
		{
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			if (b != 0)
				return b/a;
		}
		return 0;
	}*/

}
