package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import store.BookingStore;

@WebServlet("/cancel")
public class CancelBookingServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        String bookingId = req.getParameter("bookingId");
        BookingStore.getInstance().removeBooking(bookingId);

        req.setAttribute("message","booking cancelled");
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
