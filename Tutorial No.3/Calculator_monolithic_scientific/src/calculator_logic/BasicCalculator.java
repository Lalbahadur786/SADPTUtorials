package calculator_logic;
import java.util.Stack;
public class BasicCalculator implements CalculatorInterface {

	@Override
	public float add(float a, float b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public float sub(float a, float b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public float mult(float a, float b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public float div(float a, float b) {
		// TODO Auto-generated method stub
		return b/a;
	}
	
	public double evaluate(String expression)
	{
		Stack<Float> values;
		Stack<Character> ops;
		char[] tokens;
		tokens = expression.toCharArray();
		values = new Stack<>();
		ops = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++)
		{
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Float.parseFloat(sbuf.toString()));
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
	protected static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	protected float applyOp(char op, float b, float a)
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
				return div(a,b);
		}
		return 0;
	}
	
}
