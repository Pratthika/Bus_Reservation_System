package BusResv;
import java.util.Date;
import java.sql.*;

public class BookingDAO {
	public int getBookedCount(int busNo, Date date) throws SQLException {
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);//cant pass date directly here as the date in param is util package's date but here we need sql package's date
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);//1 'coz we just need booked count
	}
	public void addBooking(Booking booking) throws SQLException {
		String query="insert into booking values(?,?,?)";
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date travelDate=new java.sql.Date(booking.date.getTime());
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, travelDate);
		pst.executeUpdate();
	}
}
