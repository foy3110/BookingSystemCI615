<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 10/01/2026
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="store.RoomStore, Model.RoomBean, java.util.List"%>
<%@ page import="store.StudentStore, Model.StudentBean, java.util.List" %>
<%@ page import="Model.BookingBean" %>
<%@ page import="store.BookingStore" %>
<!DOCTYPE html>
<html>
<head>
    <title>Music Conservatoire Room Booking</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Practice Room Booking System</h1>

<h2>Book a Room</h2>
<<form action="${pageContext.request.contextPath}/book" method="post">

    Student ID:<br>
    <select name="studentId" required>
    <option value="">-- Select user --</option>
    <%
        List<StudentBean> students = StudentStore.getInstance().getStudents();
        for (StudentBean student : students) {
    %>
    <option value="<%= student.getStudentID() %>">
        <%= student.getStudentID() %> - <%= student.getStudentName() %>
        (Cap: <%= student.getStudentNumber() %>)
    </option>
    <%
        }
    %>
    </select><br><br>
    Room:<br>
    <select name="roomId" required>
        <option value="">-- Select a Room --</option>
        <%
            List<RoomBean> rooms = RoomStore.getInstance().getRooms();
            for (RoomBean room : rooms) {
        %>
        <option value="<%= room.getRoomId() %>">
            <%= room.getRoomId() %> - <%= room.getType() %>
            (Cap: <%= room.getCapacity() %>)
        </option>
        <%
            }
        %>
    </select><br><br>

    Start Date & Time:<br>
    <input type="datetime-local" name="startTime" required><br><br>

    Duration (minutes):<br>
    <input type="number" name="duration" min="15" step="15" required><br><br>

    <input type="submit" value="Book Room">
</form>

<hr>

<h2>Cancel Booking</h2>

<form action="cancel" method="post">
    <select name="bookingId" required>
        <option value="">-- Select a Booking --</option>
        <%
            List<BookingBean> bookings = BookingStore.getInstance().getBookings();
            for (BookingBean booking : bookings) {
        %>
        <option value="<%= booking.getBookingId() %>">
            <%= booking.getBookingId() %>
        </option>
        <%
            }
        %>
    </select><br><br>


    <input type="submit" value="Cancel Booking">
</form>


<hr>

<h2> Modify Booking</h2>
<form action="modify" method="post">
    <label>Booking ID:</label><br>
    <select name="bookingId" required>
        <option value="">-- Select a Booking --</option>
        <%
            for (BookingBean booking : bookings) {
        %>
        <option value="<%= booking.getBookingId() %>">
            <%= booking.getBookingId() %>
        </option>
        <%
            }
        %>
    </select><br><br>
    <label>New Date & Time:</label><br>
    <input type="datetime-local" name="newStartTime" required><br><br>

    <label>New Duration (minutes):</label><br>
    <input type="number" name="newDuration" min="15" step="15" required><br><br>

    <input type="submit" value="Modify Booking">
</form>

<hr>

<h2>Booking History</h2>
<a href="availability">View  Bookings</a>

</body>
</html>
