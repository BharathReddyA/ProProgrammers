
package library.borrowbook;

import java.util.Scanner;

//Author: Vinaykumar
//Mediator : Shubham
//Reviewer : Nurul

public class BorrowBookUI {
	
// 	public static enum uI_STaTe { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	public static enum UIState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };	// enum name 'uI_STaTe' changed to 'UIState'

// 	private bORROW_bOOK_cONTROL CoNtRoL;
	private BorrowBookControl control;	// variable type 'bORROW_bOOK_cONTROL' and name 'CoNtRoL' changed to 'BorrowBookControl' and 'control' respectively
// 	private Scanner InPuT;
	private Scanner input;			// variable name 'InPuT' changed to 'input'
// 	private uI_STaTe StaTe;
	private UIState state;			// variable type 'uI_STaTe' and name 'StaTe' changed to 'UIState' and 'state'

	
// 	public BorrowBookUI(bORROW_bOOK_cONTROL control) {
	public BorrowBookUI(BorrowBookControl control) {	// parameter's variable type 'bORROW_bOOK_cONTROL' changed to 'BorrowBookControl'
// 		this.CoNtRoL = control;
		this.control = control;				// variable name 'CoNtRoL' changed to 'control'
// 		InPuT = new Scanner(System.in);
		input = new Scanner(System.in);			// variable name 'InPuT' changed to 'input'
// 		StaTe = uI_STaTe.INITIALISED;
		state = UISTate.INITIALISED;			// variable name 'StaTe' and enum name 'uI_STaTe' changed to 'state' and 'UISTate'
// 		control.SeT_Ui(this);
		control.setUI(this);				// function name 'SeT_Ui' changed to 'setUI'
	}

	
// 	private String iNpUT(String PrOmPt) {
	private String input(String prompt) {	// function name 'iNpUT' and parameter variable name 'PrOmPt' changed to 'input' and 'prompt'
// 		System.out.print(PrOmPt);
		System.out.print(prompt);	// argument's name 'PrOmPt' changed to 'prompt'
// 		return InPuT.nextLine();
		return input.nextLine();	// object name 'InPuT' changed to 'input'
	}	
		
		
	private void output(Object object) {	// function name 'OuTpUt' and parameter variable name 'ObJeCt' changed to 'output' and 'object'
// 	private void OuTpUt(Object ObJeCt) {
		System.out.println(object);	// argument name 'ObJeCt' changed to 'object'
// 		System.out.println(ObJeCt);
	}
	
			
// 	public void SeT_StAtE(uI_STaTe StAtE) {
	public void setState(UIState state) {	// function name 'SeT_StAtE', its parameter type 'uI_STaTe' and name 'StAtE' changed to 'setState', 'UIState' and 'state' respectively
// 		this.StaTe = StAtE;
		this.state = state;		// variable name 'StaTe' and 'StAtE' changed to 'state'
	}

	
// 	public void RuN() {
	public void run() {				// function name 'RuN' changed to 'run'
// 		OuTpUt("Borrow Book Use Case UI\n");
		output("Borrow Book Use Case UI\n");	// function name 'OuTpUt' changed to 'output'
		
		while (true) {
			
// 			switch (StaTe) {
			switch (state) {		// argument name 'StaTe' changed to 'state'	
			
			case CANCELLED:
// 				OuTpUt("Borrowing Cancelled");
				output("Borrowing Cancelled");	// function name 'OuTpUt' changed to 'output'
				return;

				
			case READY:
// 				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				String memberString = input("Swipe member card (press <enter> to cancel): ");// variable name 'MEM_STR' and 'function name 'iNpUT' changed to 'memberString' and 'input'
// 				if (MEM_STR.length() == 0) {	
				if (memberString.length() == 0) {					// variable name 'MEM_STR' changed to 'memberString'
// 					CoNtRoL.CaNcEl();
					control.cancel();					// variable name 'CoNtRoL' and 'CaNcEl' changed to 'control' and 'cancel'
					break;
				}
				try {					
// 					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					int memberID = Integer.valueOf(memberString).intValue();	// variable name 'MeMbEr_Id' and 'MEM_STR' changed to 'memberID' and 'memberString'
// 					CoNtRoL.SwIpEd(MeMbEr_Id);
					control.swiped(memberID);					// name 'CoNtRoL', 'SwIpEd' and 'MeMbEr_Id' changed to 'control', 'swiped' and 'memberID'
				}
				catch (NumberFormatException e) {
// 					OuTpUt("Invalid Member Id");
					output("Invalid Member Id");					// function name 'OuTpUt' changed to 'output'
				}
				break;

				
			case RESTRICTED:
// 				iNpUT("Press <any key> to cancel");
				input("Press <any key> to cancel");		// function name 'iNpUT' changed to 'input'
// 				CoNtRoL.CaNcEl();
				control.cancel();				// 'CoNtRoL' and 'CaNcEl' changed to 'control' and 'cancel'
				break;
			
				
			case SCANNING:
// 				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				String bookStringInput = input("Scan Book (<enter> completes): ");	// variable name 'BoOk_StRiNg_InPuT' and function 'iNpUT' changed to 'bookStringInput' and 'input'
// 				if (BoOk_StRiNg_InPuT.length() == 0) {
				if (bookStringInput.length() == 0) {		// 'BoOk_StRiNg_InPuT' changed to 'bookStringInput'
// 					CoNtRoL.CoMpLeTe();
					control.complete();			// 'CoNtRoL' and 'CoMpLeTe' changed to 'control' and 'complete'
					break;
				}
				try {
// 					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					int bookID = Integer.valueOf(bookStringInput).intValue();	// variable name 'BiD' and 'BoOk_StRiNg_InPuT' changed to 'bookID' and 'bookStringInput'
// 					CoNtRoL.ScAnNeD(BiD);
					control.scanned(bookID);		// 'CoNtRoL', 'ScAnNeD' and 'BiD' changed to 'control', 'scanned'and 'bookID'
					
				} catch (NumberFormatException e) {
// 					OuTpUt("Invalid Book Id");
					output("Invalid Book Id");		// function name 'OuTpUt' changed to 'output'
				} 
				break;
					
				
			case FINALISING:
				String AnS = iNpUT("Commit loans? (Y/N): ");
				if (AnS.toUpperCase().equals("N")) {
					CoNtRoL.CaNcEl();
					
				} else {
					CoNtRoL.CoMmIt_LoAnS();
					iNpUT("Press <any key> to complete ");
				}
				break;
				
				
			case COMPLETED:
				OuTpUt("Borrowing Completed");
				return;
	
				
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
			}
		}		
	}


	public void DiSpLaY(Object object) {
		OuTpUt(object);		
	}


}
