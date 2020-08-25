<%@ page contentType="text/html; charset=UTF-8" %>

<fmt:setLocale value="ru_RU" scope="session" />
<fmt:setBundle basename="resources.pagecontent" />
<html><head>
    <<title><fmt:message key="label.title" /></title>
</head><body>
<fmt:message key="label.fileToUpload" /> <hr/>
<fmt:message key="label.back"  />
<hr/>
Uploads
<FORM action="upload" enctype="multipart/form-data" method="POST">
    Upload File: <INPUT type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
</FORM>
</body>
</html>
