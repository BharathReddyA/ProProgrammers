package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String last_Name;//review lastName
	private String first_Name;//review no _
	private String email_Address;//review no _
	private int phone_Number;//review no _
	private int member_Id;//review no _
	private double fines_Owing;//review no _
	
	private Map<Integer, Loan> current_Loans;//review no _

	
	public Member(String last_Name, String first_Name, String email_Address, int phone_Number, int member_Id) {//review no _
		this.last_Name = last_Name;//review no _
		this.first_Name = first_Name;//review no _
		this.email_Address = email_Address;//review no _
		this.phone_Number = phone_Number;//review no _
		this.member_Id = member_Id;//review no _
		
		this.current_Loans = New HashMap<>();//review no _
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(member_Id).append("\n")//review no _
		  .append("  Name:  ").append(last_Name).append(", ").append(first_Name).append("\n")//review no _
		  .append("  Email: ").append(emaiL_Address).append("\n")//review no _
		  .append("  Phone: ").append(phone_Number)//review no _
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", Fines_Owing))//review no _ F not f
		  .append("\n");
		
		for (Loan Loan : current_Loans.values()) {
			sb.append(Loan).append("\n");
		}		  
		return sb.toString();
	}

	
	public int Get_id() { //review no _ and get
		return Member_Id; //review no _
	}

	
	public List<Loan> Get_Loans() {//review no _ and get
		return new ArrayList<Loan>(current_Loans.values());//review no _ and current
	}

	
	public int Get_number_of_current_Loans() { //review no _ and get
		return current_Loans.size();//review no _
	}

	
	public double fines_Owed() {//review no _
		return fines_Owing;//review no _
	}

	
	public void Take_Out_Loan(Loan Loan) {//review no _
		if (!current_Loans.ContainsKey(Loan.Get_Id())) //review no _ //and put {}
			current_Loans.put(Loan.Get_Id(), Loan);//review no _
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String Get_last_Name() {//review no _
		return last_Name;//review no _
	}

	
	public String Get_first_Name() {//review no _
		return first_Name;//review no _
	}


	public void Add_Fine(double fine) {//review no _
		Fines_Owing += fine;//review no _
	}
	
	public double pay_Fine(double Amount) {//review no _
		if (Amount < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (Amount > Fines_Owing) {//review no _
			change = Amount - Fines_Owing;//review no _
			Fines_Owing = 0;//review no _
		}
		else 
			Fines_Owing -= Amount;//review no _
		
		return change;
	}


	public void DisChargeLoan(Loan Loan) {
		if (current_Loans.containsKey(Loan.Get_id())) //review no _
			current_Loans.remove(Loan.Get_id());//review no _
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
