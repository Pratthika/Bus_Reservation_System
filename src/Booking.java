package BusResv;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	public Booking() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the passenger name: ");
		passengerName=sc.next();
		System.out.println("Enter bus no: ");
		busNo=sc.nextInt();
		System.out.println("Enter date dd-mm-yyy");
		String dateInput=sc.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAvailable() throws SQLException{
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		
		int capacity=busdao.getCapacity(busNo);
		int booked=bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
}
