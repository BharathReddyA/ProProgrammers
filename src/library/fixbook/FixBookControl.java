//Author: Nurul
//Mediator : Bharath
//Reviewer : Vinay


import library.entities.Book;
import library.entities.Library;

//public class fIX_bOOK_cONTROL {
public class FixBookControl {
	
	//private FixBookUI Ui;
	private FixBookUi ui;
	//private enum CoNtRoL_StAtE { INITIALISED, READY, FIXING };
	private enum ControlState { INITIALISED, READY, FIXING };
	//private CoNtRoL_StAtE StAtE;
	private ControlState  state;
	
	//private Library LiBrArY;
	private Library libary;
	//private Book CuRrEnT_BoOk;
	private Book CurrentBook;


	//public fIX_bOOK_cONTROL() {
	public FixBookControl() {
		//this.LiBrArY = Library.GeTiNsTaNcE();
		this.libary = Library.GetInstance();
		//StAtE = CoNtRoL_StAtE.INITIALISED;
		state = ControlState.INITIALISED;
	}
	
	
	//public void SeT_Ui(FixBookUI ui) {
	public void SetUi(FixBookUi ui){
		//if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED))
		if (!state.equals(ControlState.INITIALISED)) 
			//throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			{
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			}
			
		//this.Ui = ui;
		this.ui = ui;
		//ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		ui.SetState(FixBookUi.uiState.READY);
		//StAtE = CoNtRoL_StAtE.READY;
		state = ControlState.READY;	
	}


	//public void BoOk_ScAnNeD(int BoOkId) {
	public void BookScanned(int BookId) 
	{
		//if (!StAtE.equals(CoNtRoL_StAtE.READY))
		if (!state.equals(ControlState.READY)) 
			//throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			{
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			}
			
		//CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
		currentBook = libary.getBook(BookId);
		
		//if (CuRrEnT_BoOk == null) 
		if (currentBook == null) 
		{
			//Ui.dIsPlAy("Invalid bookId");
			ui.display("Invalid bookId");
			return;
		}
		//if (!CuRrEnT_BoOk.iS_DaMaGeD()) 
		if (!currentBook.isDamaged()) 
		{
			//Ui.dIsPlAy("Book has not been damaged");
			ui.display("Book has not been damaged");
			return;
		}
		//Ui.dIsPlAy(CuRrEnT_BoOk.toString());
		ui.display(currentBook.toString());
		//Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
		ui.SetState(FixBookUI.uiState.FIXING);
		//StAtE = CoNtRoL_StAtE.FIXING;	
		state = ControlState.FIXING;		
	}


	//public void FiX_BoOk(boolean mUsT_FiX) {
	public void FixBook(boolean mustFix) 
	{
		//if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) 
		if (!state.equals(ControlState.FIXING)) 
			//throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			{
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			}
			
		//if (mUsT_FiX) 
		if (mustFix) 
			//LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
			{
			libary.repairBook(currentBook);
			}
		
		//CuRrEnT_BoOk = null;
		currentBook = null;
		//Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		ui.setState(FixBookUi.uiState.READY);
		//StAtE = CoNtRoL_StAtE.READY;
		state = ControlState.READY;
	}

	
	//public void SCannING_COMplete() {
	public void scanningComplete() 
	{
		//if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
		if (!state.equals(ControlState.READY))
			//throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		//Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);
		ui.setState(FixBookUI.uiState.COMPLETED);
	}

}
