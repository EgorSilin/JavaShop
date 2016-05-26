package ru.javashop.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import ru.javashop.servlets.TestDB;

/**
 * Created by Admin on 25.05.2016.
 */
//@WebServlet(name = "StartServlet", urlPatterns = {"/", "/a/b/c", "/servlets/start"})
public class StartServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDB testdb = new TestDB();
        testdb.checkDB();
        HttpSession session = request.getSession(true);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>" +
                    "<head>" +
                    "<meta http-equiv=\"content-type\" content=\"text/html; charset=\"UTF-8\">" +
                    "<title>Юлмарт</title>" +
                    "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">" +
                    "</head>" +
                    "<body>" +
                    "<div id=\"wrapper\">" +
                    "  <div id=\"inputForm\">Вход:</div>" +
                    "  <h1> <img src=\"/images/ulmart-logo.png\" alt=\"\" width=\"215\" height=\"25\" id=\"logoPng\"/>№1 в мире бытовой техники! </h1>" +
                    "  <p>Добро пожаловать в нтернет магазин! </p>" +
                    "  <p>Здесь вы можете удобно подобрать</p>" +
                    "  <p> !!!!!!!!!!!!!!!!!!!!!! </p>");
            out.println("<h3> Session ID = " + session.getId() + "</h3>");

            if (testdb.dbList instanceof ArrayList) {
                out.println("<h3> Summary counter operation list = " + testdb.dbList.size() + "</h3>");
                for (String note : testdb.dbList) {
                    out.println("<h3>" + note + "</h3>");
                }
            } else {
                out.println("<h3> ЗАПИСИ НЕ НАЙДЕНЫ </h3>");
            }

            out.println("  <p>!!!!!!!!!!!!!!!!!!!</p>" +
                    "</div>");
        } catch (Exception ex) {
            out.println("<h1> Ошибка </h1>");
        } finally {
            out.println("</body>" +
                    "</html>");
            out.close();
        }
    }
}
