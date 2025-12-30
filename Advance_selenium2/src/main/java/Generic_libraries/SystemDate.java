package Generic_libraries;



	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Date;

	public class SystemDate {

		public String systemdates() 
		{
			LocalDate date = LocalDate.now();
			//local ]date  future month 
			
			DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String systemdate = d.format(date);
			return systemdate;
		}
		
		public String sysdate()
		{
			Date date = new Date();
			SimpleDateFormat sim= new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
			String systemDateInFormate=sim.format(date);
			return systemDateInFormate;
		}
		
		public String futureDateIntermsOfMonth(long futureMon)
		{
			LocalDate date = LocalDate.now();
			 LocalDate future = date.plusMonths(futureMon);
			 DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String futureMonth = d.format(future);
			return futureMonth;
		}
		
		
		
	}

