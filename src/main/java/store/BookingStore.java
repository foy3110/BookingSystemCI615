package store;

import Model.BookingBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class BookingStore {
    private static BookingStore instance;
    private final List<BookingBean> bookings = new CopyOnWriteArrayList<>();

    private BookingStore() {}

    public static BookingStore getInstance() {
        //creates a new instance of bookingStore
        if (instance == null) {
            instance = new BookingStore();
        }
        //or returns the one in use if it exists
        return instance;
    }

    public List<BookingBean> getBookings() {
    // returns the list of bookings
        return bookings;
    }

    public boolean addBooking(BookingBean booking) {
        if (hasConflict(booking)) return false; // checks for conflict
        bookings.add(booking);// if no conflict add booking to list
            return true;


    }

    public void removeBooking(String bookingId) {
        // removes booking based off whether new booking == the old bookings id
        bookings.removeIf(b -> b.getBookingId().equals(bookingId));

    }

    //checks whether there is a conflicting booking with the room and time
    public boolean hasConflict(BookingBean newBooking) {
        return bookings.stream().anyMatch(existing ->
                existing.getRoomID().equals(newBooking.getRoomID()) &&
                        newBooking.getBookingTime().isBefore(existing.getEndTime()) &&
                        newBooking.getEndTime().isAfter(existing.getBookingTime())
        );
    }

    public BookingBean getBookingById(String bookingId) {
        if (bookingId == null) return null;

        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))//finds booking id which is equal
                .findFirst()//returns first element of stream
                .orElse(null);//catch statement
    }
    public boolean updateBooking(String bookingId,
                                 LocalDateTime newStartTime,
                                 int newDuration) {

        BookingBean existing = getBookingById(bookingId);
        if (existing == null) return false;
        String studentId = existing.getStudentId();
       // had issues not outputting the correct student id  and room
       // System.out.println(studentId);
       // System.out.println(existing.getBookingId());
       // System.out.println(existing.getRoomID());


        // Create a temporary booking for conflict checking
        BookingBean updated = new BookingBean(
                existing.getBookingId(),//changed from passed values to prevent errors
                existing.getStudentId(),
                existing.getRoomID(),

                newStartTime,
                newDuration
        );

        // Remove current booking temporarily
        bookings.remove(existing);

        // Check for conflicts
        if (hasConflict(updated)) {
            bookings.add(existing); // rollback
            return false;
        }
        //adds new updated booking back to list
        bookings.add(updated);
        return true;
    }

}

