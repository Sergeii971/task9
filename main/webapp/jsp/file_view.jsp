<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<title>Uploads</title>
<body>
<form>
    File data:
    <br>
    <textarea rows="20" cols="55"><%= request.getAttribute("file_content") %>
    </textarea>
</form>
</body>
</html>