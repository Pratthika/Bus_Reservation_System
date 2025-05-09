package BusResv;
import java.sql.SQLException;
import java.util.*;
public class BusDemo {

	public static void main(String[] args){
		BusDAO busdao=new BusDAO();
		try {
			busdao.displayBusInfo();
			
			Scanner sc=new Scanner(System.in);
			int userOpt=1;
			
			
			while(userOpt==1) {
				System.out.println("Enter 1 to Book & 2 to exit");
				userOpt=sc.nextInt();
				if(userOpt==1)
				{
					System.out.println("Booking...");
					Booking booking=new Booking();
					if(booking.isAvailable()){
						BookingDAO bookingdao=new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed!");
					}
					else {
						System.out.println("Sorry. Bus is Full. Try another bus or date.");
					}
				}
			}
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
