package user_interface;
import calculator_logic.*;
import java.util.Scanner;
public class CalculatorUI {
	public static void main(String[] args) {
	    Scanner scan=new Scanner(System.in);
		String c="Y";
		while(c.equals("Y"))
		{
		System.out.println("Enter the expression : ");
		String exp;
		exp=scan.nextLine();
		CalculatorFactory calFactory=new CalculatorFactory();
		CalculatorInterface cal=calFactory.getOperation(exp);
		double res=cal.evaluate(exp);
		System.out.println("Answer is "+res);
		System.out.print("Do You not continue(Y/N):");
		c=scan.nextLine();
		}
		scan.close();
	}
}
