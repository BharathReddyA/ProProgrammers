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
	private state State;
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;
		this.callno = callNo;
		this.id = id;
		this.State = State.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(iD).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
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


	
	public boolean iS_Available() {
		return State == state.AVAILABLE;
	}

	
	public boolean is_ON_Loan() {
		return State == state.ON_LOAN;
	}

	
	public boolean iS_Damaged() {
		return State == state.DAMAGED;
	}

	
	public void borrow() {
		if (State.equals(state.AVAILABLE))
	}
			State = State.ON_LOAN;
	{
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));
		
		
	}


	public void Return(boolean DAMAGED) {
		if (State.equals(state.ON_LOAN)) 
			if (DAMAGED) 
				State = state.DAMAGED;
			
			else 
				State = state.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
				
	}

	
	public void Repair() {
		if (State.equals(state.DAMAGED)) 
			State = state.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));
		
	}


}
