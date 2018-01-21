package basic_calculator;
import java.util.Stack;
 interface arithmetic
{
public int add(int a,int b);
public int sub(int a,int b);
public int mult(int a,int b);
public int div(int a,int b);
}
public  class CalculatorLogic implements arithmetic{
	 public int add(int a,int b){
		return a+b;
	}
	 public int sub(int a,int b){
		return a-b;
	}
	 public int mult(int a,int b){
		return a*b;
	}
	 public int div(int a,int b){
		return a/b;
	}
	public  int evaluate(String expression)
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
	public  boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	public  int applyOp(char op, int b, int a)
	{
		switch (op)
		{
		case '+':
			return add(a,b);
		case '-':
			return sub(a,b);
		case '*':
			return mult(a,b);
		case '/':
			if (b != 0)
				return div(b, a);
		}
		return 0;
	}
}

