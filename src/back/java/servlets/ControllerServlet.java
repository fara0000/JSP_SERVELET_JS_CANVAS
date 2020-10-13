package java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("coordinate_x") != null && request.getParameter("coordinate_y") != null && request.getParameter("coordinate_r") != null) {
            getServletContext().getRequestDispatcher("/areaCheck").forward(request, response);
        } else {
            request.setAttribute("title", "Error:<br>invalid data");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
