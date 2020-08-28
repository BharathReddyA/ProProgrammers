
package library.entities;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String title;
	private String author;
	private String callNo;
	private int id;
	
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private State state;//review//State to state 
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;
		this.callNo = callNo;
		this.id = id;
		this.State = State.AVAILABLE;//review//State to state 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(iD).append("\n")//review//iD to id 
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  .append("  CallNo: ").append(callNo).append("\n")
		  .append("  State:  ").append(State);//review//State to state 
		
		return sb.toString();
	}

	public Integer getid() {
		return id;
	}

	public String gettitle() {
		return title;
	}


	
	public boolean iS_Available() {//review//iS_Available to iSAvailable 
		return State == state.AVAILABLE;//review//State to state 
	}

	
	public boolean is_ON_Loan() {//review//is_ON_Loan to isOnLoan 
		return State == state.ON_LOAN;//review//State to state, ON_LOAN to onLoan
	}

	
	public boolean iS_Damaged() { //review//iS_Damaged to isDamaged 
		return State == state.DAMAGED;//review//State to state 
	}

	
	public void borrow() {
		if (State.equals(state.AVAILABLE))//review//State to state 
	}
			State = State.ON_LOAN;//review//State to state, ON_LOAN to onLoan
	{
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));//review//State to state 
		
		
	}


	public void Return(boolean DAMAGED) {
		if (State.equals(state.ON_LOAN)) //review//State to state, ON_LOAN to onLoan
			if (DAMAGED) 
				State = state.DAMAGED;//review//State to state
			
			else 
				State = state.AVAILABLE;//review//State to state
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
				
	}

	
	public void Repair() {
		if (State.equals(state.DAMAGED)) //review//State to state
			State = state.AVAILABLE;//review//State to state
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));//review//State to state
		
	}


}

package library.entities;
import java.io.Serializable;
//test1

@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String title;
	private String author;
	private String callNo;
	private int id;
	
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private state State;//review//State to state
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;

		this.callNo = callNo;

		this.callNo = callNo;

		this.id = id;
		this.State = State.AVAILABLE;//review//State to state
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(id).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")

		  .append("  CallNo: ").append(callNo).append("\n")

		  .append("  CallNo: ").append(callNo).append("\n")
	  .append("  State:  ").append(State);
		
		return sb.toString();
	}

	public Integer getid() {
		return id;
	}

	public String gettitle() {
		return title;
	}


	
	public boolean iS_Available() {//review//iS_Available to iSAvailable
		return State == state.AVAILABLE;//review//State to state
	}

	
	public boolean is_ON_Loan() {//review//isOnLoan from is_ON_Loan
		return State == state.ON_LOAN;//review//onLoan from ON_Loan
	}

	
	public boolean iS_Damaged() {//review//iS_Damaged to iSDamaged
		return State == state.DAMAGED;
	}

	
	public void borrow() {
		if (State.equals(state.AVAILABLE))//review//State to state
	}
			State = State.ON_LOAN;//review//onLoan from ON_Loan
	{
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));//review//State to state
		
		
	}


	public void Return(boolean DAMAGED) {
		if (State.equals(state.ON_LOAN)) //review//State to state, ON_LOAN to onLoan
			if (DAMAGED) 
				State = state.DAMAGED;//review//State to state
			
			else 
				State = state.AVAILABLE;//review//State to state
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));//review//State to state
				
	}

	
	public void Repair() {
		if (State.equals(state.DAMAGED)) //review//State to state
			State = state.AVAILABLE;//review//State to state
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));//review//State to state
		
	}


}

