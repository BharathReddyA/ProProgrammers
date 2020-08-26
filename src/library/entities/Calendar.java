//Author: Nurul
//Mediator : Bharath
//Reviewer : Vinay

package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//private static Calendar sElF;
	private static Calendar seif;
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'seif' it should be 'self'}
	// <<
	//private static java.util.Calendar cAlEnDaR;
	private static java.util.Calendar calender;
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'calender' it should be 'calendar'}
	// <<
	
	
	private Calendar() {
		//cAlEnDaR = java.util.Calendar.getInstance();
		calender = java.util.Calendar.getInstance();
	}
	
	//public static Calendar gEtInStAnCe() {
	public static Calendar getInStance() {
		//if (sElF == null) {
		if (seif == null) {
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'seif' it should be 'self'}
	// <<
			//sElF = new Calendar();
			seif = new Calendar();
		}
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'seif' it should be 'self'}
	// <<
		//return sElF;
		return seif;
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'seif' it should be 'self'}
	// <<
	}
	
	public void incrementDate(int days) {
		//cAlEnDaR.add(java.util.Calendar.DATE, days);
		calender.add(java.util.Calendar.DATE, days);
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'calender' it should be 'calendar'}
	// <<
	}
	
	//public synchronized void SeT_DaTe(Date DaTe) {
	public synchronized void SetDate(Date date) {
		try {
			//cAlEnDaR.setTime(DaTe);
			calender.setTime(date);
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'calender' it should be 'calendar'}
	// <<
			/*cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);*/
			calender.set(java.util.Calendar.HOUR_OF_DAY, 0);  
			calender.set(java.util.Calendar.MINUTE, 0);  
			calender.set(java.util.Calendar.SECOND, 0);  
			calender.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	//public synchronized Date gEt_DaTe() {
	public synchronized Date getDate() {
		try {
	        /*cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();*/
			calender.set(java.util.Calendar.HOUR_OF_DAY, 0);  
			calender.set(java.util.Calendar.MINUTE, 0);  
			calender.set(java.util.Calendar.SECOND, 0);  
			calender.set(java.util.Calendar.MILLISECOND, 0);
			return calender.getTime();
		}
	// >>
	//[Reviewer]{Mistake in whole try block, see variable name's spelling 'calender' it should be 'calendar'}
	// <<
		
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	//public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
	 public synchronized Date getDueDate(int loanPeriod) {
		//Date nOw = gEt_DaTe();
		Date now = getDate();
		//cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		calender.add(java.util.Calendar.DATE, loanPeriod);
		//Date dUeDaTe = cAlEnDaR.getTime();
		Date dueDate = calender.getTime();
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'calender' it should be 'calendar'}
	// <<
		//cAlEnDaR.setTime(nOw);
		calender.setTime(now);
	// >>
	//[Reviewer]{Mistake in variable name's spelling 'calender' it should be 'calendar'}
	// <<
		//return dUeDaTe;
		return dueDate;
	 }
	
	//public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
	 public synchronized long GetDaysDifference(Date targetDate) {
		 
		//long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
		long differenceMilliseconds = getDate().getTime() - targetDate.getTime();
	    //long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
		long differenceDays = TimeUnit.DAYS.convert(differenceMilliseconds, TimeUnit.MILLISECONDS);
	    //return Diff_Days;
	    return differenceDays;
	}

}
