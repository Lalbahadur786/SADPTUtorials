package calculator_logic;
import java.util.Stack;
public class GeometricOperations implements CalculatorInterface,GeometricOp {

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

	@Override
	public double sin(double a) {
		// TODO Auto-generated method stub
		return Math.sin(a);
	}

	@Override
	public double cos(double a) {
		// TODO Auto-generated method stub
		return Math.cos(a);
	}

	@Override
	public double tan(double a) {
		// TODO Auto-generated method stub
		return Math.tan(a);
	}
	
	public double evaluate(String expression)
	{
		char[] tokens;
		Stack<Double> values;
		Stack<Character> ops;
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
				values.push(Double.parseDouble(sbuf.toString()));
			}
			else if(tokens[i] == 's'){
				i=i+3;				//sin45 + cos45
				StringBuffer temp = new StringBuffer();
				while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
					temp.append(tokens[i++]);
				}
				values.push(Double.parseDouble(""+sin(Double.parseDouble(temp.toString()))));
			}
			else if(tokens[i] == 'c'){
				i=i+3;				//sin45 + cos45
				StringBuffer temp = new StringBuffer();
				while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
					temp.append(tokens[i++]);
				}
				values.push(Double.parseDouble(""+cos(Double.parseDouble(temp.toString()))));
			}
			else if(tokens[i] == 't'){
				i=i+3;				//sin45 + cos45
				StringBuffer temp = new StringBuffer();
				while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
					temp.append(tokens[i++]);
				}
				values.push(Double.parseDouble(""+tan(Double.parseDouble(temp.toString()))));
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
	protected boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	protected double applyOp(char op, double b, double a)
	{
		float a1=Float.parseFloat(a+"");
		float b1=Float.parseFloat(b+"");
		switch (op)
		{
		case '+':
			return add(a1,b1);
		case '-':
			return sub(a1,b1);
		case '*':
			return mult(a1,b1);
		case '/':
			if (b1 != 0)
				return div(a1,b1);
		}
		return 0;
	}
}
