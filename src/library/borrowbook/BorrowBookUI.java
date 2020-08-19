
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
	
			
	public void SeT_StAtE(uI_STaTe StAtE) {
		this.StaTe = StAtE;
	}

	
	public void RuN() {
		OuTpUt("Borrow Book Use Case UI\n");
		
		while (true) {
			
			switch (StaTe) {			
			
			case CANCELLED:
				OuTpUt("Borrowing Cancelled");
				return;

				
			case READY:
				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				if (MEM_STR.length() == 0) {
					CoNtRoL.CaNcEl();
					break;
				}
				try {
					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					CoNtRoL.SwIpEd(MeMbEr_Id);
				}
				catch (NumberFormatException e) {
					OuTpUt("Invalid Member Id");
				}
				break;

				
			case RESTRICTED:
				iNpUT("Press <any key> to cancel");
				CoNtRoL.CaNcEl();
				break;
			
				
			case SCANNING:
				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				if (BoOk_StRiNg_InPuT.length() == 0) {
					CoNtRoL.CoMpLeTe();
					break;
				}
				try {
					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					CoNtRoL.ScAnNeD(BiD);
					
				} catch (NumberFormatException e) {
					OuTpUt("Invalid Book Id");
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
