<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- <head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 -->
 
<body>
	<h2>${message}</h2><br><br>
	
	<fieldset style="width: 40%;"> 
		<legend>File Upload</legend>
			<form method="POST" action="uploadFile" enctype="multipart/form-data">
				File to Upload: <input type="file" required="required" name="file"><br /><br />
				Description: <input type="text" required="required" name="description"><br /><br />
				<input type="submit" value="Upload">
			</form>
	</fieldset>
</body>
</html>