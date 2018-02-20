package calcicontroller;
import user_interfaces.*;
import calcimodals.*;
import  calculator_logic.*;
public class Calcicontrol {
 private Calcicommandview  view;
 private Calcimodal  modal;
 CalculatorInterface cal =new BasicCalculator();
protected  Calcicontrol(Calcicommandview view, Calcimodal modal)
 {
	 this.view=view;
	 this.modal=modal;
 }
   protected String getinput()
   {
	   return view.getexpression();
   }
   protected void setresult(String exp)
   {
	  modal.setmodalres(Double.toString(cal.evaluate(exp))) ;
   }
 protected void updateview()
 {
	 view.setoutput(modal.getmodalres());
 }

	public static void main(String args[])
	{
	  Calcicommandview view=new Calcicommandview();
	  Calcimodal modal=new Calcimodal();
	  Calcicontrol controller=new Calcicontrol(view,modal);
	  controller.setresult( controller.getinput());
	  controller.updateview();
	  
		
		
	}

}
