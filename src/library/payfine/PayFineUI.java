package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	public static enum UI_State { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	//review//UI_State to UIState

	private Pay_Fine_Control Control; //review//Pay_Fine_Control to payFineControl and Control to control
	private Scanner input;
	private UI_State State;//review//UI_State to UIState

	

	public PayFineUI(Pay_Fine_Conrol Control) {//review//Pay_Fine_Control to payFineControl and Control to control
		this.Control = Control; //review// Control to control twice
		input = new Scanner(System.in);
		State = UI_State.INITIALISED;//review//UI_State to UIState
		Control.Set_UI(this);//review//Set_UI to setUI and Control to control
	}
	
	
	public void Set_State(UI_State State) { //review//UI_State to UIState and Set_State to setState

	public PayFineUI(Pay_Fine_Control Control) {//review//Pay_Fine_Control to payFineControl and Control to control
		this.Control = Control;//review// Control to control twice
		input = new Scanner(System.in);
		State = UI_State.INITIALISED;//review//UI_State to UIState
		Control.Set_UI(this); //review//Set_UI to setUI and Control to control
	}
	
	
	public void Set_State(UI_State State) {//review//UI_State to UIState and Set_State to setState
		this.State = State; //review//State to state twice
	}


	public void Run() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (State) {//review//State to state 
			
			case READY:
				String Mem_Str = input("Swipe member card (press <enter> to cancel): "); //review//Mem_Str to memberString
				if (Mem_Str.length() == 0) {//review//Mem_Str to memberString
					Control.Cancel();//review//Control to control
					break;
				}
				try {
					int Member_ID = Integer.valueOf(Mem_Str).intValue();//review//Member_ID to memberId and Mem_Str to memberString
					Control.Card_Swiped(Member_ID);//review//Card_Swiped to cardSwiped and Member_ID to memberId and Control to control
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double Amount = 0;
				String Amt_Str = input("Enter amount (<Enter> cancels) : ");//review//Amt_Str to amountString
				if (Amt_Str.length() == 0) {//review//Amt_Str to amountString
					Control.Cancel();//review//Control to control
					break;
				}
				try {
					Amount = Double.valueOf(Amt_Str).doubleValue();//review//Amt_Str to amountString
				}
				catch (NumberFormatException e) {}
				if (Amount <= 0) {
					output("Amount must be positive");
					break;
				}
				Control.Pay_Fine(Amount);//review//Control to control and Pay_Fine to payFine
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + State);//review//State to state 		
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.println(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	public void Display(Object object) {
		output(object);
	}


}
