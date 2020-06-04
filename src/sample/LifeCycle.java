package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifeCycle", urlPatterns = "/LC" )
public class LifeCycle extends HttpServlet {
    private String company;
    @Override
    public void init() throws ServletException {
        System.out.println("init() 호출됨");
        company = getServletContext().getInitParameter("company");
        System.out.println(company);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service() 호출됨");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
