package myWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       String writer = request.getParameter("writer");
       String memo = request.getParameter("memo");
        System.out.println("작성자 : "  + writer);
        System.out.println("내용 : "  + memo);
        StringBuffer sql = new StringBuffer();
        sql.append("insert into visit(no, writer, memo, regdate) ");
        sql.append("values (visit_seq.nextval, ?, ?, sysdate)" );
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","jaden","jaden");
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, writer);
            pstmt.setString(2, memo);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } finally {
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("VisitList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
