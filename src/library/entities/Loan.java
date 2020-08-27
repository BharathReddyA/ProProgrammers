// Author : Vinaykumar
// Mediator : shubham
// Reviewer : Nurul

package library.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable {
	
// 	public static enum lOaN_sTaTe { CURRENT, OVER_DUE, DISCHARGED };
	public static enum LoanState { CURRENT, OVER_DUE, DISCHARGED };	// enum name 'lOaN_sTaTe' changed to 'LoanState'

// 	private int LoAn_Id;
	private int loanID;		// variable name 'LoAn_Id' changed to 'loanID'
// 	private Book BoOk;
	private Book book;		// variable name 'BoOk' changed to 'book'
// 	private Member MeMbEr;
	private Member member;		// variable name 'MeMbEr' changed to 'member'
// 	private Date DaTe;
	private Date date;		// variable name 'DaTe' changed to 'date'
// 	private lOaN_sTaTe StAtE;
	private LoanState state;	// variable type 'lOaN_sTaTe' and name 'StAtE' changed to 'LoanState' and 'state'

	
// 	public Loan(int loanId, Book bOoK, Member mEmBeR, Date DuE_dAtE) {
	public Loan(int loanID, Book book, Member member, Date dueDate) {	// variables 'loanId', 'bOoK', 'mEmBeR' and 'DuE_dAtE' changed to 'loanID', 'book', 'member' and 'dueDate'
// 		this.LoAn_Id = loanId;
		this.loanID = loanID;			// variable name 'LoAn_Id' and 'loanId' changed to 'loanID' 
// 		this.BoOk = bOoK;
		this.book = book;			// variable name 'BoOk' and 'bOok' changed to 'book' 
// 		this.MeMbEr = mEmBeR;
		this.member = member;			// variable name 'MeMbEr' and 'mEmBeR' changed to 'member' 
// 		this.DaTe = DuE_dAtE;
		this.date = dueDate;			// variable name 'DaTe' and 'DuE_dAtE' changed to 'date' and 'dueDate' 
// 		this.StAtE = lOaN_sTaTe.CURRENT;
		this.state = loanState.CURRENT;		// variable name 'StAtE' and 'lOaN_sTaTe' changed to 'state' and 'loanState' 
	}

	
// 	public void cHeCk_OvEr_DuE() {
	public void checkOverDue() {					// function name 'cHeCk_OvEr_DuE' changed to 'checkOverDue'
// 		if (StAtE == lOaN_sTaTe.CURRENT &&
// 			Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe)) 
		if (state == loanState.CURRENT &&			// variable 'StAtE', 'lOaN_sTaTe', 'DaTe' changed to 'state', 'loanState', 'date' and functions name 
			Calendar.getInstance().getDate().after(date))	// 'gEtInStAnCe' and 'gEt_DaTe' changed to 'getInstance' and 'gateDate'
// 			this.StAtE = lOaN_sTaTe.OVER_DUE;
			this.state = loanState.OVER_DUE;		// variable name 'StAtE' and 'lOaN_sTaTe' changed to 'state' and 'loanState'
		
	}

	
// 	public boolean Is_OvEr_DuE() {
	public boolean isOverDue() {			// function name 'Is_OvEr_DuE' changed to 'isOverDue'
// 		return StAtE == lOaN_sTaTe.OVER_DUE;
		return state == loanState.OVER_DUE;	// variable names 'StAtE' and 'lOaN_sTaTe' changed to 'state' and 'loanState'
	}

	
// 	public Integer GeT_Id() {
	public Integer getID() {			// function name 'GeT_Id' changed to 'getID'
// 		return LoAn_Id;
		return loanID;				// variable name 'LoAn_Id' changed to 'loanID'
	}


// 	public Date GeT_DuE_DaTe() {
	public Date getDueDate() {			// function name 'GeT_DuE_DaTe' changed to 'getDueDate'
// 		return DaTe;
		return date;				// variable name 'DaTe' changed to 'date'
	}
	
	
	public String toString() {	
// 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");	// variable name 'sdf' changed to 'simpleDateFormat'

// 		StringBuilder sb = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();					// variable name 'sb' changed to 'stringBuilder'
// 		sb.append("Loan:  ").append(LoAn_Id).append("\n")
// 		  .append("  Borrower ").append(MeMbEr.GeT_ID()).append(" : ")
// 		  .append(MeMbEr.GeT_LaSt_NaMe()).append(", ").append(MeMbEr.GeT_FiRsT_NaMe()).append("\n")
// 		  .append("  Book ").append(BoOk.gEtId()).append(" : " )
// 		  .append(BoOk.gEtTiTlE()).append("\n")
// 		  .append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
// 		  .append("  State: ").append(StAtE);
		stringBuilder.append("Loan:  ").append(loanID).append("\n")					// variables name 'LoAn_Id', 'sdf', 'DaTe', 'StAtE', 'MeMbEr' and 'BoOk'changed to 
		  .append("  Borrower ").append(member.getID()).append(" : ")					// 	'loanID', 'simpleDateFormat', 'date', 'state', 'member' and 'book'
		  .append(member.getLastName()).append(", ").append(member.getFirstName()).append("\n")		// methods name 'GeT_ID', 'GeT_LaSt_NaMe', 'GeT_FiRsT_NaMe', 'gEtId', gEtTiTlE
		  .append("  Book ").append(book.getID()).append(" : " )					//	changed to 'getID', 'getLastName', 'getFirstName', 'getID', 'getTitle'
		  .append(book.getTitle()).append("\n")
		  .append("  DueDate: ").append(simpleDateFormat.format(date)).append("\n")
		  .append("  State: ").append(state);		
// 		return sb.toString();
		return stringBuilder.toString();				// variable name 'sb' changed to 'stringBuilder'
	}


// 	public Member GeT_MeMbEr() {
	public Member getMember() {			// function name 'GeT_MeMbEr' changed to 'getMember'
// 		return MeMbEr;
		return member;				// variable name 'MeMbEr' changed to 'member'
	}


// 	public Book GeT_BoOk() {
	public Book getBook() {			// function name 'GeT_BoOk' changed to 'getBook'
// 		return BoOk;
		return book;				// variable name 'BoOk' changed to 'book'
	}


// 	public void DiScHaRgE() {
	public void discharge() {			// function name 'DiScHaRgE' changed to 'discharge'
// 		StAtE = lOaN_sTaTe.DISCHARGED;
		state = loanState.DISCHARGED;		// variable name 'lOaN_sTaTe' changed to 'loanState'
	}

}
