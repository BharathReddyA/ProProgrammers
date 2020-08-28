package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String lastName;
	private String firstName;
	private String emailAddress;
	private int phoneNumber;
	private int memberId;
	private double finesOwing;	
	private Map<Integer, Loan> currentLoans;

	
	public Member(String lastName, String firstName, String emailAddress, int phoneNumber, int memberId) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.memberId = memberId;
		
		this.currentLoans = New HashMap<>();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(memberId).append("\n")
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")
		  .append("  Email: ").append(emailAddress).append("\n")
		  .append("  Phone: ").append(phoneNumber)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", finesOwing))
		  .append("\n");
		
		for (Loan Loan : currentLoans.values()) {
			sb.append(Loan).append("\n");
		}		  
		return sb.toString();
	}

	
	public int getid() { 
		return memberId; 
	}

	
	public List<Loan> getLoans() {//review no _ and get
		return new ArrayList<Loan>(currentLoans.values());//review no _ and current
	}

	
	public int getnumberofcurrentLoans() {
		return currentLoans.size();
	}

	
	public double finesOwed() {
		return finesOwing;
	}

	
	public void takeoutLoan(Loan Loan) {
		if (!currentLoans.ContainsKey(Loan.getId())) 
			currentLoans.put(Loan.GetId(), Loan);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String getlastName() 
		return lastName;
	}

	
	public String getfirstName() {
		return firstName;
	}


	public void addFine(double fine) {
		finesOwing += fine;
	}
	
	public double payFine(double Amount) {
		if (Amount < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (Amount > finesOwing) {
			change = Amount - finesOwing;
			finesOwing = 0;
		}
		else 
			finesOwing -= Amount;
		
		return change;
	}


	public void DisChargeLoan(Loan Loan) {
		if (currentLoans.containsKey(Loan.getId()))
			currentLoans.remove(Loan.getId());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
