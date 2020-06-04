<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GUGUDAN2</title>
</head>
<body>
    <table width="900" align="center" border="1">
        <caption> 구구단 2 </caption>
        <%
            for(int i = 2; i < 10 ; i++){
                out.print("<th>" + i + "</th>");
            }
        %>
    </table>

</body>
</html>
