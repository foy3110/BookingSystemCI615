package Model;

import java.time.LocalDateTime;
// java bean for booking
public class BookingBean {

    private String bookingId;
    public String studentId;
    private String roomID;
    private LocalDateTime bookingTime;
    private int duration;

    public BookingBean() {}
    //constructor
    public BookingBean(String bookingId, String studentId, String roomID, LocalDateTime bookingTime, int duration) {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.roomID = roomID;
        this.bookingTime = bookingTime;
        this.duration = duration;
    }

    //getters and setters
    public String  getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getRoomID() {
        return roomID;
    }
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getEndTime() {
        return bookingTime.plusMinutes(duration);
    }

}
