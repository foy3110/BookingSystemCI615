package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import store.BookingStore;

import java.io.IOException;
// availability servlet
@WebServlet("/availability")
public class AvailabilityLogic extends HttpServlet {
    // doesnt need post only get
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // gets tge booking request
        req.setAttribute("bookings", BookingStore.getInstance().getBookings());
    req.getRequestDispatcher("availability.jsp").forward(req, resp);
    }
}
