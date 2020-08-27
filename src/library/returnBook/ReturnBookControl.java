//Author: Nurul
//Mediator : Bharath
//Reviewer : Vinay


import FixBookControl.ControlState;
import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;

//public class rETURN_bOOK_cONTROL {
public class ReturnBookControl {


	//private ReturnBookUI Ui;
	private ReturnBookUI ui;
	//private enum cOnTrOl_sTaTe { INITIALISED, READY, INSPECTING };
	private enum ControlState { INITIALISED, READY, INSPECTING };
	//private cOnTrOl_sTaTe sTaTe;
	private ControlState state;
	
	//private Library lIbRaRy;
	private Library libary;
	//private Loan CurrENT_loan;
	private Loan currentLoan;
	

	//public rETURN_bOOK_cONTROL() {
	public ReturnBookControl() {
		//this.lIbRaRy = Library.GeTiNsTaNcE();
		this.libary = Library.getInstance();
		//sTaTe = cOnTrOl_sTaTe.INITIALISED;
		state = ControlState.INITIALISED;
	}
	
	
	//public void sEt_uI(ReturnBookUI ui)
	public void setUI(ReturnBookUI ui){
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INITIALISED)) 
		if (!state.equals(ControlState .INITIALISED)) {
			//throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
			throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
			}
		//this.Ui = uI;
		this.ui = ui;
		//uI.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		ui.setState(ReturnBookUI.uiState.READY);
		//sTaTe = cOnTrOl_sTaTe.READY;		
		state = ControlState.READY;		
	}


	//public void bOoK_sCaNnEd(int bOoK_iD) 
	public void bookScanned(int bookId){
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
		if (!state.equals(ControlState.READY)) {
			//throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
			}
		
		//Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD);
		Book currentBook = libary.getBook(bookId);
		
		//if (cUrReNt_bOoK == null) 
		if (currentBook == null) {
			//Ui.DiSpLaY("Invalid Book Id");
			ui.display("Invalid Book Id");
			return;
		}
		//if (!cUrReNt_bOoK.iS_On_LoAn()) 
		if (!currentBook.isOnLoan()) {
			//Ui.DiSpLaY("Book has not been borrowed");
			ui.display("Book has not been borrowed");
			return;
		}		
		//CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD);	
		currentLoan = libary.getLoanByBookId(bookId);	
		//double Over_Due_Fine = 0.0;
		double overDueFine = 0.0;
		//if (CurrENT_loan.Is_OvEr_DuE()) 
		if (currentLoan.isOverDue()) {
			//Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan);
			overDueFine = libary.calculateOverDueFine(currentLoan);
		}
		
		//Ui.DiSpLaY("Inspecting");
		ui.display("Inspecting");
		//Ui.DiSpLaY(cUrReNt_bOoK.toString());
		ui.display(currentBook.toString());
		//Ui.DiSpLaY(CurrENT_loan.toString());
		ui.display(currentLoan.toString());
		
		//if (CurrENT_loan.Is_OvEr_DuE()) 
		if (currentLoan.isOverDue()) {
			
			//Ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
			ui.display(String.format("\nOverdue fine : $%.2f", overDueFine));
		}
		
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);
		ui.setState(ReturnBookUI.uiState.INSPECTING);
		//sTaTe = cOnTrOl_sTaTe.INSPECTING;	
		state = controlState.INSPECTING;		
	}


	//public void sCaNnInG_cOmPlEtE() 
	public void scanningComplete() {
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
		if (!state.equals(ControlState.READY)) {
			//throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
			}
			
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);
		ui.setState(ReturnBookUI.uiState.COMPLETED);		
	}


	//public void dIsChArGe_lOaN(boolean iS_dAmAgEd) 
	public void dischargeLoan(boolean isDamaged){
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INSPECTING)) 
		if (!state.equals(ControlState.INSPECTING)) {
			//throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
			
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
			}
		
		//lIbRaRy.DiScHaRgE_LoAn(CurrENT_loan, iS_dAmAgEd);
		libary.dischargeLoan(currentLoan, isDamaged);
		//CurrENT_loan = null;
		currentLoan = null;
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		ui.setState(ReturnBookUI.uiState.READY);
		//sTaTe = cOnTrOl_sTaTe.READY;
		state = ControlState.READY;				
	}


}
