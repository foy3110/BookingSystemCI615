<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 13/01/2026
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*, Model.BookingBean" %>
<html>
<body>
<h2>Rooms Booked</h2>

<table border="1">
    <tr>
        <th>BookingId</th>
        <th>Student</th>
        <th>Room</th>
        <th>Start</th>
        <th>End</th>
    </tr>

    <%
        List<BookingBean> bookings = (List<BookingBean>) request.getAttribute("bookings");
        for (BookingBean b : bookings) {
    %>
    <tr>
        <td><%= b.getBookingId() %></td>
        <td><%= b.getRoomID() %></td>
        <td><%= b.getStudentId() %></td>
        <td><%= b.getBookingTime() %></td>
        <td><%= b.getEndTime() %></td>
    </tr>
    <% } %>

</table>

<br>

</body>
</html>
