<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
</head>
<body>
<h1>Demo</h1>
<p style="color: black;">* required field</p>
<form method="post" action="./CommitServlet">
    <label>Username: *</label>

    <input type="text" value="${after.inputName}" name="inputName"/>
    <span name="errorName">${errors.Name}</span>
    <br/><br>

    <label>Gender: *</label>
    <input type="radio" name="gender" value="male" />Male
    <input type="radio" name="gender" value="female" />Female
    <span name="errorGender">${errors.Gender}</span>
    <br><br>
    <input type="submit"/>
</form>
</body>
</html>
