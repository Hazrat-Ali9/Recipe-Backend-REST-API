<%@page import="com.android.recipe.helper.OracleConnection"%>
<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    <%=OracleConnection.getConnection() %>
</body>
</html>
