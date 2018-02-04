package calculator_logic;

public class CalculatorFactory {
	 public CalculatorInterface getOperation(String opType){
	      if(opType == null){
	         return null;
	      }		
	      if(opType.contains("sin")|| opType.contains("cos")||opType.contains("tan")){
	         return new GeometricOperations();
	      } 
	      else if(opType.contains("min")||opType.contains("max")|| opType.contains("min")||opType.contains("mean")||opType.contains("sd")||opType.contains("var"))
	      {
	         return new AlgebricOperations();
	      }
	      else{
	    	  return new BasicCalculator();
	      }
	   }
}
