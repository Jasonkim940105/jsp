<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GUGUDAN</title>
</head>
<body>
<table width="900" border="1" align="center">
    <caption>구구단</caption>
    <tr height="50">
        <%
            for(int i = 2; i < 10; i++){
                out.print("<th>" + i +"단" + "</th>");
            }
        %>
    </tr>
    <%
        for(int i = 2 ; i < 10; i++){
            out.print("<tr>");
            for(int j = 2; j < 10; j++){
                out.print("<td>" + i + "x" + j + "=" + i*j +"<br></td>");
            }
            out.print("</tr>");
        }
    %>

</table>

</body>
</html>
