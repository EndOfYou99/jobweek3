<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="game" align="center">
 
  <h1>Welcome to hangman game</h1>
  <form action="Init" method="get">
   <br>
   Please choose a difficulty level:
   <br>
   <input type="radio" name="difficulty" id="easy" name="Easy" value="Easy">
   <label for="easy">Easy</label><br>
   <input type="radio" name="difficulty" id="medium" name="Medium" value="Medium">
   <label for="medium">Medium</label><br>
   <input type="radio" name="difficulty" id="hard" name="Hard" value="Hard">
   <label for="hard">Hard</label><br>
   <input type="submit">
  </form>
  
 
 
 </div>
</body>
</html>