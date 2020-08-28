package library.entities;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String title;
	private String author;
	private String callNo;
	private int id;
	
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private state state;
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;

		this.callNo = callNo;

		this.callNo = callNo;

		this.id = id;
		this.state = state.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(id).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")

		  .append("  CallNo: ").append(callNo).append("\n")

		  .append("  State:  ").append(state);
		
		return sb.toString();
	}

	public Integer getid() {
		return id;
	}

	public String gettitle() {
		return title;
	}


	
	public boolean isAvailable() {
		return state == state.AVAILABLE;
	}

	
	public boolean isOnLoan() {
		return state == state.ON_LOAN;
	}

	
	public boolean isDamaged() {
		return state == state.DAMAGED;
	}

	
	public void borrow() {
		if (state.equals(state.AVAILABLE))
	}
			state = state.onLOAN;
	{
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state));
		
		
	}


	public void Return(boolean DAMAGED) {
		if (state.equals(state.onLOAN)) 
			if (DAMAGED) 
				state = state.DAMAGED;
			
			else 
				state = state.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", state));
				
	}

	
	public void Repair() {
		if (state.equals(state.DAMAGED)) 
			state = state.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state));
		
	}


}
