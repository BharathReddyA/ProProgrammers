package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	public static enum UIState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	private payFineControl control; 
	private Scanner input;
	private UIState State;

	

	public PayFineUI(payFineConrol control) 
		this.control = control; 
		input = new Scanner(System.in);
		State = UIState.INITIALISED;
		control.setUI(this);
	}
	
	
	public void setState(UIState State) { 

	public PayFineUI(payFineControl control) {
		this.control = control;
		input = new Scanner(System.in);
		State = UIState.INITIALISED;
		control.setUI(this); 
	}
	
	
	public void setState(UIState State) {
		this.state = state; 
	}


	public void Run() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) { 
			
			case READY:
				String memberString = input("Swipe member card (press <enter> to cancel): ");
				if (memberString.length() == 0) {
					control.Cancel();
					break;
				}
				try {
					int memberId = Integer.valueOf(memberString).intValue();
					control.cardSwiped(memberId);
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double Amount = 0;
				String amountString = input("Enter amount (<Enter> cancels) : ");
				if (amountString.length() == 0) {
					control.Cancel();
					break;
				}
				try {
					Amount = Double.valueOf(amountString).doubleValue();
				}
				catch (NumberFormatException e) {}
				if (Amount <= 0) {
					output("Amount must be positive");
					break;
				}
				control.payFine(Amount);
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state); 		
			
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
