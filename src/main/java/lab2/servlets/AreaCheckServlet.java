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
            int x = Integer.parseInt(request.getParameter("coordinate_x"));
            String yValue = request.getParameter("coordinate_y").replace(',', '.');
            if (yValue.length() > 6) {
                yValue = yValue.substring(0, 6);
            }
            double y = Double.parseDouble(yValue);
            double r = Double.parseDouble(request.getParameter("coordinate_r").replace(',', '.'));
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

    private boolean checkArea(int x, double y, double r) {
        if (x == 0) {
            return (y <= r && y >= -r / 2);
        } else if (x > 0) {
            return (x * x + y * y <= r * r / 4); //окружность
        } else return (y <= x + r && y >= 0) //треугольник
                || (x >= -r && y >= -r / 2 && y <= 0); //прямоугольник
    }

    private boolean checkValues(int x, double y, double r) {
        return Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5).contains(x) &&
                (y < 3 && y > -3) &&
                Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0).contains(r);
    }
}