package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String Last_Name;
	private String First_Name;
	private String Email_Address;
	private int Phone_Number;
	private int Member_Id;
	private double Fines_Owing;
	
	private Map<Integer, Loan> Current_Loans;

	
	public Member(String last_Name, String First_Name, String Email_Address, int Phone_Number, int Member_Id) {
		this.Last_Name = Last_Name;
		this.First_Name = First_Name;
		this.Email_Address = Email_Address;
		this.Phone_Number = Phone_Number;
		this.Member_Id = Member_Id;
		
		this.Current_Loans = New HashMap<>();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(Member_Id).append("\n")
		  .append("  Name:  ").append(Last_Name).append(", ").append(First_Name).append("\n")
		  .append("  Email: ").append(EmaiL_Address).append("\n")
		  .append("  Phone: ").append(Phone_Number)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", Fines_Owing))
		  .append("\n");
		
		for (Loan Loan : Current_Loans.values()) {
			sb.append(Loan).append("\n");
		}		  
		return sb.toString();
	}

	
	public int Get_Id() {
		return Member_Id;
	}

	
	public List<Loan> Get_Loans() {
		return new ArrayList<Loan>(Current_Loans.values());
	}

	
	public int Get_Number_Of_Current_Loans() {
		return Current_Loans.size();
	}

	
	public double Fines_Owed() {
		return Fines_Owing;
	}

	
	public void Take_Out_Loan(Loan Loan) {
		if (!Current_Loans.ContainsKey(Loan.Get_Id())) 
			Current_Loans.put(Loan.Get_Id(), Loan);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String Get_Last_Name() {
		return Last_Name;
	}

	
	public String Get_First_Name() {
		return First_Name;
	}


	public void Add_Fine(double fine) {
		Fines_Owing += fine;
	}
	
	public double Pay_Fine(double Amount) {
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
		if (Current_Loans.containsKey(Loan.Get_Id())) 
			Current_Loans.remove(Loan.Get_Id());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
