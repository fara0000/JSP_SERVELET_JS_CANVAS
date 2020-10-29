package lab2.servlets;

import lab2.models.TableRow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            List<TableRow> tableRows = session.getAttribute("tableRows") == null ? new ArrayList<TableRow>() : (List<TableRow>) session.getAttribute("tableRows");
            long startTime = System.nanoTime();
            String currentTime = new Date().toString();
            String xValue = request.getParameter("coordinate_x").replace(',', '.');
            if (xValue.length() > 6) {
                xValue = xValue.substring(0, 6);
            }
            double x = Double.parseDouble(xValue);
            double y = Double.parseDouble(request.getParameter("coordinate_y").replace(',', '.'));
            int r = Integer.parseInt(request.getParameter("coordinate_r"));
            if (checkValues(x, y, r)) {
                String result = checkArea(x, y, r) ? "<span style='color: #439400'>Попала</span>" : "<span style='color: #94002D'>Не попала</span>";
                long endTime = System.nanoTime();
                String time = (endTime - startTime) / 1000000 + "." + (endTime - startTime) % 1000000;
                TableRow tableRow = new TableRow(x, y, r, currentTime, time, result);
                tableRows.add(tableRow);
                session.setAttribute("tableRows", tableRows);
            } else {
                request.setAttribute("title", "Error:<br>invalid range of data");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("title", "Error:<br>invalid type of data");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private boolean checkArea(double x, double y, int r) {
        if(x > 0 && y > 0) {
            return false;
        }
        if (x >= 0 && y <= 0 && y > 2*x - r) {
            return true;
        }
            else return (y <= x + r && y >= 0) || (x >= -r && y >= -r && y <= 0);
    }

    private boolean checkValues(double x, double y, int r) {
        return (x < 3 && x > -5) &&
                Arrays.asList(-2.0, -1.5, -1.0, -0.5, 0, 0.5, 1.0, 1.5, 2.0).contains(y) &&
                Arrays.asList(1, 2, 3, 4, 5).contains(r);
    }
}