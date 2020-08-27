package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String last_Name;
	private String first_Name;
	private String email_Address;
	private int phone_Number;
	private int member_Id;
	private double fines_Owing;
	
	private Map<Integer, Loan> current_Loans;

	
	public Member(String last_Name, String first_Name, String email_Address, int phone_Number, int member_Id) {
		this.last_Name = last_Name;
		this.first_Name = first_Name;
		this.email_Address = email_Address;
		this.phone_Number = phone_Number;
		this.member_Id = member_Id;
		
		this.current_Loans = New HashMap<>();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(member_Id).append("\n")
		  .append("  Name:  ").append(last_Name).append(", ").append(first_Name).append("\n")
		  .append("  Email: ").append(emaiL_Address).append("\n")
		  .append("  Phone: ").append(phone_Number)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", Fines_Owing))
		  .append("\n");
		
		for (Loan Loan : current_Loans.values()) {
			sb.append(Loan).append("\n");
		}		  
		return sb.toString();
	}

	
	public int Get_id() {
		return Member_Id;
	}

	
	public List<Loan> Get_Loans() {
		return new ArrayList<Loan>(current_Loans.values());
	}

	
	public int Get_number_of_current_Loans() {
		return current_Loans.size();
	}

	
	public double fines_Owed() {
		return fines_Owing;
	}

	
	public void Take_Out_Loan(Loan Loan) {
		if (!current_Loans.ContainsKey(Loan.Get_Id())) 
			current_Loans.put(Loan.Get_Id(), Loan);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String Get_last_Name() {
		return last_Name;
	}

	
	public String Get_first_Name() {
		return first_Name;
	}


	public void Add_Fine(double fine) {
		Fines_Owing += fine;
	}
	
	public double pay_Fine(double Amount) {
		if (Amount < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (Amount > Fines_Owing) {
			change = Amount - Fines_Owing;
			Fines_Owing = 0;
		}
		else 
			Fines_Owing -= Amount;
		
		return change;
	}


	public void DisChargeLoan(Loan Loan) {
		if (current_Loans.containsKey(Loan.Get_id())) 
			current_Loans.remove(Loan.Get_id());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
