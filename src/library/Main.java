package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import library.borrowbook.BorrowBookUI;
import library.borrowbook.BorrowBookControl;
// import library.borrowbook.bORROW_bOOK_cONTROL;
import library.borrowbook.BorrowBookControl;         // file name 'bORROW_bOOK_cONTROL' changed to 'BorrowBookControl'
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUI;
// import library.fixbook.fIX_bOOK_cONTROL;
import library.fixbook.FixBookControl;              // file name 'fIX_bOOK_cONTROL' changed to 'FixBookControl'
import library.payfine.PayFineUI;
// import library.payfine.pAY_fINE_cONTROL
import library.payfine.PayFineControl;.             // file name 'pAY_fINE_cONTROL' changed to 'PayFineControl'
import library.returnBook.ReturnBookUI;
// import library.returnBook.rETURN_bOOK_cONTROL;
import library.returnBook.ReturnBookControl;        // file name 'rETURN_bOOK_cONTROL' changed to 'ReturnBookControl'

public class Main {
	
// 	private static Scanner IN;
	private static Scanner input;			// variable name 'IN' changed to 'input'
// 	private static Library LIB;
	private static Library library;			// variable name 'LIB; changed to 'library'
// 	private static String MENU;
	private static String menu;			// variable name 'MENU' changed to 'menu'
// 	private static Calendar CAL;
	private static Calendar calendar;			// variable name 'CAL' changed to 'calendar'
// 	private static SimpleDateFormat SDF;
	private static SimpleDateFormat simpleDateFormat;	// variable name 'SDF' changed to 'simpleDateFormat'
	
	
// 	private static String Get_menu() {
	private static String getMenu() {				// function name 'Get_menu' changed to 'getMenu'
// 		StringBuilder sb = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();	// variable name 'sb' changed to 'stringBuilder'
		
// 		sb.append("\nLibrary Main Menu\n\n")
		stringBuilder.append("\nLibrary Main Menu\n\n")		// variable name 'sb' changed to 'stringBuilder'
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
// 		return sb.toString();
		return stringBuilder.toString();			// variable name 'sb' changed to 'stringBuilder'
	}


	public static void main(String[] args) {		
		try {			
// 			IN = new Scanner(System.in);
			input = new Scanner(System.in);				// variable name 'IN' changed to 'input'		
// 			LIB = Library.GeTiNsTaNcE();
			library = Library.getInstance();			// variable name 'LIB; changed to 'library' and method name 'GeTiNsTaNcE' changed to 'getInstance'
// 			CAL = Calendar.gEtInStAnCe();
			calendar = Calendar.getInstance();			// variable name 'CAL' changed to 'calendar' and method name 'gEtInStAnCe' changed to 'getInstance'
// 			SDF = new SimpleDateFormat("dd/MM/yyyy");
			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");	// variable name 'SDF' changed to 'simpleDateFormat'
	
// 			for (Member m : LIB.lIsT_MeMbErS()) {
			for (Member member : library.listMembers()) {	// variable name 'm', 'LIB' changed to 'member', 'library' and method 'lIsT_MeMbErS' changed to 'listMembers'
// 				output(m);
				output(member);				// variable name 'm' changed to 'member'
			}
			output(" ");
// 			for (Book b : LIB.lIsT_BoOkS()) {
			for (Book book : library.listBooks()) {		// variable name 'b' and method name 'lIsT_BoOkS' changed to 'book' and 'listBooks'
// 				output(b);
				output(book);				// variable name 'b' changed to 'book'
			}
						
// 			MENU = Get_menu();
			menu = getMenu();				// variable name 'MENU' and function name 'Get_menu' changd to 'menu' and 'getMenu'
			
			boolean e = false;
			
			while (!e) {
				
// 				output("\n" + SDF.format(CAL.gEt_DaTe()));
				output("\n" + simpleDateFormat.format(calendar.getDate()));	// variable name 'SDF', 'CAL' and method name 'gEt_DaTe' changed to 'simpleDateFormat', 'calendar' and 'getDate'
// 				String c = input(MENU);
				String string = input(menu);				// variable name 'c', 'MENU' changed to 'string' and 'menu'
				
// 				switch (c.toUpperCase()) {
				switch (string.toUpperCase()) {		// variable name 'c' changed to 'string'
				
				case "M": 
// 					ADD_MEMBER();
					addMember();			// function name 'ADD_MEMBER' changed to 'addMember'	
					break;
					
				case "LM": 
// 					LIST_MEMBERS();
					listMember();			// function name 'LIST_MEMBERS' changed to 'listMember'
					break;
					
				case "B": 
// 					ADD_BOOK();
					addBook();			// function name 'ADD_BOOK' changed to 'addBook'
					break;
					
				case "LB": 
// 					LIST_BOOKS();
					listBooks();			// function name 'LIST_BOOKS' changed to 'listBooks'
					break;
					
				case "FB": 
// 					FIX_BOOKS();
					fixBooks();			// function name 'FIX_BOOKS' changed to 'fixBooks'
					break;
					
				case "L": 
// 					BORROW_BOOK();
					borrowBook();			// function name 'BORROW_BOOK' changed to 'borrowBook'
					break;
					
				case "R": 
// 					RETURN_BOOK();
					returnBook();			// function name 'RETURN_BOOK' changed to 'returnBook'
					break;
					
				case "LL": 
// 					LIST_CURRENT_LOANS();
					listCurrentLoans();		// function name 'LIST_CURRENT_LOANS' changed to 'listCurrentLoans'
					break;
					
				case "P": 
// 					PAY_FINES();			
					payFines();			// function name 'PAY_FINES' changed to 'payFines'
					break;
					
				case "T": 
// 					INCREMENT_DATE();
					incrementDate();		// function name 'INCREMENT_DATE' changed to 'incrementDate'
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
// 				Library.SaVe();
				Library.save();				// method name 'SaVe' changed to 'save'
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
// 	private static void PAY_FINES() {
	private static void payFines() {				// function name 'PAY_FINES' changed to 'payFines'
// 		new PayFineUI(new pAY_fINE_cONTROL()).RuN();		
		new PayFineUI(new PayFineControl()).run();		// constructors name 'pAY_fINE_cONTROL' changed to 'PayFineControl' and
	}								//	method name 'RUN' changed to 'run'


// 	private static void LIST_CURRENT_LOANS() {			
	private static void listCurrentLoans() {			// function name 'LIST_CURRENT_LOANS' changed to 'listCurrentLoans'
		output("");
// 		for (Loan loan : LIB.lISt_CuRrEnT_LoAnS()) {
		for (Loan loan : library.listCurrentLoans()) {		// instance name 'LIB' and method name 'lISt_CuRrEnT_LoAnS' changed to 'library' and 'listCurrentLoans'
			output(loan + "\n");
		}		
	}



// 	private static void LIST_BOOKS() {
	private static void listBooks() {				// function name 'LIST_BOOKS' changed to 'listBooks'
		output("");
// 		for (Book book : LIB.lIsT_BoOkS()) {
		for (Book book : library.listBooks()) {			// instance name 'LIB' and method name 'lIsT_BoOkS' changed to 'library' and 'listBooks'
			output(book + "\n");
		}		
	}



// 	private static void LIST_MEMBERS() {
	private static void listMembers() {				// function name 'LIST_MEMBERS' changed to 'listMembers'
		output("");
// 		for (Member member : LIB.lIsT_MeMbErS()) {
		for (Member member : library.listMembers()) {		// instance name 'LIB' and method name 'lIsT_MeMbErS' changed to 'library' and 'listMembers'
			output(member + "\n");
		}		
	}



// 	private static void BORROW_BOOK() {
	private static void borrowBook() {				// function name 'BORROW_BOOK' changed to 'borrowBook'

// 		new BorrowBookUI(new BorrowBookControl()).RuN();		
		new BorrowBookUI(new BorrowBookControl()).run();	// method name 'RUN' changed to 'run'	

// 		new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();	// duplicate code removed


	}


// 	private static void RETURN_BOOK() {
	private static void returnBook() {				// function name 'RETURN_BOOK' changed to 'returnBook'
// 		new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();		
		new ReturnBookUI(new ReturnBookControl()).run();	// constructor name 'rETURN_bOOK_cONTROL' and method name 'RuN' changed to 'ReturnBookControl' and 'run'
	}


// 	private static void FIX_BOOKS() {
	private static void fixBooks() {				// function name 'FIX_BOOKS' changed to 'fixBooks'
// 		new FixBookUI(new fIX_bOOK_cONTROL()).RuN();		
		new FixBookUI(new FixBookControl()).run();		// constructor name 'fIX_bOOK_cONTROL' and method name 'RuN' changed to 'FixBookControl' and 'run'
	}


// 	private static void INCREMENT_DATE() {
	private static void incrementDate() {				// function name 'INCREMENT_DATE' changed to 'incrementDate'
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
// 			CAL.incrementDate(days);
			calendar.incrementDate(days);			// variable name 'CAL' changed to 'calendar'
// 			LIB.cHeCk_CuRrEnT_LoAnS();
			library.checkCurrentLoans();			// variable name 'LIB' and method name 'cHeCk_CuRrEnT_LoAnS' changed to 'library' and 'checkCurrentLoans'
// 			output(SDF.format(CAL.gEt_DaTe()));
			output(simpleDateFormat.format(calendar.getDate()));		// variable name 'SDF', 'CAL' and method name 'gEt_DaTe' changed to 'simpleDateFormat', 'calendar' and 'getDate'
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


// 	private static void ADD_BOOK() {
	private static void addBook() {				// function name 'ADD_BOOK' changed to 'addBook'
// 		String AuThOr = input("Enter author: ");
		String author = input("Enter author: ");		// variable name 'AuThOr' changed to 'author'
// 		String TiTlE  = input("Enter title: ");
		String title  = input("Enter title: ");			// variable name 'TiTlE' changed to 'title'
// 		String CaLl_NuMbEr = input("Enter call number: ");
		String callNumber = input("Enter call number: ");	// variable name 'CaLl_NuMbEr' changed to 'callNumber'
// 		Book BoOk = LIB.aDd_BoOk(AuThOr, TiTlE, CaLl_NuMbEr);
		Book book = library.addBook(author, title, callNumber);	// variable name 'BoOk', 'LIB', 'AuThOr', 'TiTlE', 'CaLl_NuMbEr' and method name 'aDd_BoOk' changed tp 'book', 'library', 'author', 'title', 'callNumber' and 'addBook' respectively
// 		output("\n" + BoOk + "\n");
		output("\n" + book + "\n");				// varianle name 'BoOk' changed to 'book'
		
	}

	
// 	private static void ADD_MEMBER() {
	private static void addMember() {								// function name 'ADD_MEMBER' changed to 'addMember'
		try {
// 			String LaSt_NaMe = input("Enter last name: ");
			String lastName = input("Enter last name: ");					// variable name 'LaSt_NaMe' changed to 'lastName'
// 			String FiRsT_NaMe  = input("Enter first name: ");
			String firstName  = input("Enter first name: ");
// 			String EmAiL_AdDrEsS = input("Enter email address: ");
			String emailAddress = input("Enter email address: ");				// variable name 'EmAiL_AdDrEsS' changed to 'emailAddress'
// 			int PhOnE_NuMbEr = Integer.valueOf(input("Enter phone number: ")).intValue();
			int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue();	// variable name 'PhOnE_NuMbEr' changed to 'phoneNumber'
// 			Member MeMbEr = LIB.aDd_MeMbEr(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr);
			Member member = library.addMember(lastName, firstName, emailAddress, phoneNumber);	// variable name 'MeMbEr', 'LIB', 'LaSt_NaMe', 'FiRsT_NaMe', 'EmAiL_AdDrEsS', 'PhOnE_NuMbEr' and method 'aDd_MeMbEr' changed to 'member', 'library', 'lastName', firstName', 'emailAddress', 'phoneNumber' and 'addMember' respectively
// 			output("\n" + MeMbEr + "\n");
			output("\n" + member + "\n");							// variable name 'MeMbEr' changed to 'member'		
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
// 		return IN.nextLine();
		return input.nextLine();				// variable name 'IN' changed to 'input'
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
