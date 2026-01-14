package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import store.BookingStore;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/modify")
public class ModifyBooking extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String bookingId = request.getParameter("bookingId");
        String roomId = request.getParameter("roomId");
        LocalDateTime startTime =
                LocalDateTime.parse(request.getParameter("newStartTime"));
        int duration =
                Integer.parseInt(request.getParameter("newDuration"));

        boolean success = BookingStore.getInstance()
                .updateBooking(bookingId, startTime, duration);

        if (success) {
            request.setAttribute("message", "Booking updated successfully");
        } else {
            request.setAttribute("error",
                    "Unable to update booking (conflict or invalid ID)");
        }

        request.getRequestDispatcher("/result.jsp")
                .forward(request, response);
    }
}
