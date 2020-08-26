//Author: Bharath
//Mediator : Vinay
//Reviewer : Shubham

package library.fixbook;
import java.util.Scanner;


public class FixBookUi {

	public static enum uiState { INITIALISED, READY, FIXING, COMPLETED };

	private FixBookControl control;
	private FixBookControl control;
	private Scanner input;
	private uiState state;

	
	public FixBookUI(FixBookControl control) {
		this.control = control;
		input = new Scanner(System.in);
		state = uiState.INITIALISED;
		control.setUi(this);
	}


	public void setState(uiState state) {
		this.state = state;
	}

	
	public void run() {
		output("fix Book Use Case UI\n");
		
		while (true) {
			
			switch (state) {
			
			case READY:
				String bookEntryString = input("Scan Book (<enter> completes): ");
				if (bookEntryString.length() == 0) 
					control.scanningComplete();
				
				else {
					try {
						int bookId = Integer.valueOf(bookEntryString).intValue();
						control.bookScanned(bookId);
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String ans = input("fix Book? (Y/N) : ");
				boolean fix = false;
				if (ans.toUpperCase().equals("Y")) 
					fix = true;
				
				control.fixBook(fix);
				break;
								
			case COMPLETED:
				output("FIXING process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new runtimeException("FixBookUI : unhandled state :" + state);			
			
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
	

	public void display(Object object) {
		output(object);
	}
	
	
}
