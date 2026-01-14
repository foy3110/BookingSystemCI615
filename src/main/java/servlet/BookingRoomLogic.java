package servlet;

import  jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import Model.BookingBean;
import store.BookingStore;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/book")
public class BookingRoomLogic extends HttpServlet {

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String roomId = (req.getParameter("roomId"));
            String studentId = (req.getParameter("studentId"));
        LocalDateTime startTime = LocalDateTime.parse(req.getParameter("startTime"));

        int duration = Integer.parseInt(req.getParameter("duration"));
        //prolly broken part
        BookingBean booking = new BookingBean(
                Integer.toString((int) (Math.random()*101)),
                roomId,
                studentId,
                startTime,
                duration
                );

        boolean succes = BookingStore.getInstance().addBooking(booking);
        if (succes) {
            req.setAttribute("message", "Booking successfully added");
        }else{
            req.setAttribute("message", "Booking failed");
        }
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
