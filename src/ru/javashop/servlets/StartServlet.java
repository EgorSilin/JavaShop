package ru.javashop.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet StartServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1> #####Servlet StartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");


//            System.out.println("<html>" +
//                    "<head>" +
//                    "<meta http-equiv=\"content-type\" content=\"text/html; charset=\"UTF-8\">" +
//                    "<title>Юлмарт</title>" +
//                    "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">" +
//                    "</head>" +
//                    "<body>" +
//                    "<div id=\"wrapper\">" +
//                    "  <div id=\"inputForm\">Вход:</div>" +
//                    "  <h1> <img src=\"/images/ulmart-logo.png\" alt=\"\" width=\"215\" height=\"25\" id=\"logoPng\"/>№1 в мире бытовой техники! </h1>" +
//                    "  <p>Добро пожаловать в нтернет магазин! </p>" +
//                    "  <p>Здесь вы можете удобно подобрать</p>" +
//                    "!!!!!!!!!!!!!!!!!!!!!!");
//            TestDB testDB = new TestDB();
//            testDB.check();
//            System.out.println("  <p>!!!!!!!!!!!!!!!!!!!</p>" +
//                    "  <p>&nbsp;</p>" +
//                    "  <p>&nbsp;</p>" +
//                    "</div>" +
//                    "</body>" +
//                    "</html>" +
//                    "");
//            out.println("<>");
//            out.println("<>");
        }
        finally {
            out.close();
        }
    }
}
