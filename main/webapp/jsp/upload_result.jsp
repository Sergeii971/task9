<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<title>Uploads</title>
<body>
<FORM>
    Upload result: <%= request.getAttribute("upload_result") %>
</FORM>
<hr/>
<form action="WebController" method="POST">
    <INPUT type="submit" value="View File">
</form>
</body>
</html>