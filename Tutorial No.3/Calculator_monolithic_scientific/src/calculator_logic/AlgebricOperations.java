package calculator_logic;
import java.util.*;
public class AlgebricOperations implements AlgebricOp,CalculatorInterface {

	@Override
	public double min(int[] arr) {
		// TODO Auto-generated method stub
		int min=arr[0];
		for(int k=1;k<arr.length;k++)
		{
			if(arr[k]<min)
				min=arr[k];
		}
		return min;
	}

	@Override
	public double max(int[] arr) {
		// TODO Auto-generated method stub
		int max=arr[0];
		for(int k=1;k<arr.length;k++)
		{
			if(arr[k]>max)
				max=arr[k];
		}
		return max;
	}

	@Override
	public double standarddev(int[] arr) {
		// TODO Auto-generated method stub
	        double sum = 0.0, standardDeviation = 0.0;

	        for(double num : arr) {
	            sum += num;
	        }

	        double mean = sum/10;

	        for(double num: arr) {
	            standardDeviation += Math.pow(num - mean, 2);
	        }
	        return Math.sqrt(standardDeviation/10);
	}

	@Override
	public double var(int[] arr) {
		// TODO Auto-generated method stub
		double sd=standarddev(arr);
		return Math.pow(sd,2);
	}

	@Override
	public double mean(int[] arr) {
		// TODO Auto-generated method stub
		double sum=0.0;
		for(double num : arr) {
	        sum += num;
	    }
		int length=arr.length;
		double mean=sum/length;
		return mean;
	}
	public double evaluate(String expression){
		StringTokenizer token;
		ArrayList<Integer> arrlist;
		token=new StringTokenizer(expression,"(");
		String tempt=token.nextToken();
		String temp=token.nextToken();
		token=new StringTokenizer(temp,")");
		temp=token.nextToken();
		token=new StringTokenizer(temp,",");
		arrlist=new ArrayList<>();
		while(token.hasMoreTokens()){
			arrlist.add(Integer.parseInt(token.nextToken()));
		}
		int arr[]=new int[arrlist.size()];
		for(int i=0;i<arrlist.size();i++){
			arr[i]=(int)arrlist.get(i);
		}
		if(tempt.equals("min")){
			return min(arr);
		}
		else if(tempt.equals("max")){
			return max(arr);
		}
		else if(tempt.equals("mean")){
			return mean(arr);
		}
		else if(tempt.equals("sd")){
			return standarddev(arr);
		}
		else if(tempt.equals("var")){
			return var(arr);
		}
		return 0.0;
	}

	@Override
	public float add(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float sub(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float mult(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float div(float a, float b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
