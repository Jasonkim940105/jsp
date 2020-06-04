package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;


public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String dbId = "admin";
        String dbPwd = "1234";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "jaden", "jaden");
            pstmt = con.prepareStatement("select password from login where id = ? ");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                String dbPass = rs.getString("password");
                if(pwd.equals(dbPass)){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", id);
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("비밀번호 오류");
                }
            } else {
                System.out.println("아이디가 없습니다.");
            }
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            if( rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ( pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if  ( con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        /*if(dbId.equals(id) && dbPwd.equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", id);
        }*/
        response.sendRedirect("Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
