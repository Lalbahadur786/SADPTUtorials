package user_interfaces;
import java.util.*;
public class Calcicommandview {
Scanner scan=new Scanner(System.in);
private String getexp;
public String getexpression()
{
	System.out.print("Enter Expression:");
	getexp=scan.nextLine();
	return getexp;
}
public void setoutput(String res)
{
	System.out.println(res);
}
}
