package example;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet", urlPatterns = "/SE")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        try{
            out.println("<html><head><title>My First Servlet</title></head>");
            out.println("<body><h1>My First Servlet Program</h1><hr><br/>");
            out.println("<font size ='5' face='궁서체'>");
            out.println("지금은 ");
            out.println(new java.util.Date());
            out.println(" 입니다");
            out.println("</font></body></html>");
        } finally {
            out.close();
        }
    }
}
