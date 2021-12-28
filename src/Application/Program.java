package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Models.Entitites.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Che-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Che-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(! checkOut.after(checkIn)) {
			System.out.println("Error in reservation! Check-out date be after check-in date.");
		} else {
			Reservation reservation =  new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter daa to update the reservation: ");
			System.out.println("Che-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Che-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation! Reservation dates for update must be future dates.");
			} else if (! checkOut.after(checkIn)) {
				System.out.println("Error in reservation! Check-out date be after check-in date.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		
		sc.close();
	}
}
