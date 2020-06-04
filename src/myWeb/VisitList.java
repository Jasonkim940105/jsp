package myWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class VisitList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<html>");
            out.println("<head><title>방명록 리스트</title></head>");
            out.println("<body>");
            StringBuffer sql = new StringBuffer();
            sql.append("select no, writer, memo, regdate ");
            sql.append("from visit ");
            sql.append("order by no desc ");
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "jaden", "jaden");
                pstmt = con.prepareStatement(sql.toString());
                rs = pstmt.executeQuery();
                while (rs.next()){
                    int no = rs.getInt("no");
                    String writer = rs.getString("writer");
                    String memo = rs.getString("memo");
                    java.sql.Date regdate = rs.getDate("regdate");
                    out.println(
                            "<table align = center width = 500 border = 1>"
                    );
                    out.println("<tr>");
                    out.println("<th width=50>번호</th>");
                    out.println(
                            "<td width=50 align = center>" + no + "</td>"
                    );
                    out.println("<th width =70>작성자</th>");
                    out.println(
                            "<td width=180 align=center>" + writer + "</td>"
                    );
                    out.println("<th width=50>날짜</th>");
                    out.println("<td width=100 align=center>" + regdate + "</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<th width=50>내용</th>");
                    out.println("<td colspan=5> <textarea rows=3 cols=50>" + memo + "</textarea></td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("<p>");
                }
            } catch (SQLException e){
                e.printStackTrace();
            } catch (ClassNotFoundException cnfe){
                cnfe.printStackTrace();
            } finally {
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
            out.println("<p align = center>" +
                    "<a href=/bbs/write.html>글쓰기</a></p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
