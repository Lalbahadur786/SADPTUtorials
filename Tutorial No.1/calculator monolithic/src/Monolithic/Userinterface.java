package Monolithic;
import basic_calculator.*;
import java.util.*;
public class Userinterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String c="Y";
		while(c.equals("Y"))
		{
		System.out.println("Enter the expression : ");
		String exp;
		exp=scan.nextLine();
		CalculatorLogic calculator=new CalculatorLogic();
		int result=calculator.evaluate(exp);
		showResult(result);
		System.out.print("Do You not continue(Y/N):");
		c=scan.nextLine();
		}
		scan.close();
	}
	static void showResult(int res){
		System.out.println("Answer is "+res);
	}
}
