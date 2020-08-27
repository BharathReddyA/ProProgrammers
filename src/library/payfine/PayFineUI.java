package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	public static enum UI_State { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	private Pay_Fine_Control Control;
	private Scanner input;
	private UI_State State;

	

	public PayFineUI(Pay_Fine_Conrol Control) {
		this.Control = Control;
		input = new Scanner(System.in);
		State = UI_State.INITIALISED;
		Control.Set_UI(this);
	}
	
	
	public void Set_State(UI_State State) {

	public PayFineUI(Pay_Fine_Control Control) {
		this.Control = Control;
		input = new Scanner(System.in);
		State = UI_State.INITIALISED;
		Control.Set_UI(this);
	}
	
	
	public void Set_State(UI_State State) {
		this.State = State;
	}


	public void Run() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (State) {
			
			case READY:
				String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				if (Mem_Str.length() == 0) {
					Control.Cancel();
					break;
				}
				try {
					int Member_ID = Integer.valueOf(Mem_Str).intValue();
					Control.Card_Swiped(Member_ID);
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double Amount = 0;
				String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				if (Amt_Str.length() == 0) {
					Control.Cancel();
					break;
				}
				try {
					Amount = Double.valueOf(Amt_Str).doubleValue();
				}
				catch (NumberFormatException e) {}
				if (Amount <= 0) {
					output("Amount must be positive");
					break;
				}
				Control.Pay_Fine(Amount);
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + State);			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	public void Display(Object object) {
		output(object);
	}


}
