<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.UUID" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.HashMap" %>
        <%@page import="java.util.Set" %>
    <%@ page import="hangman.businessLogic.GameService" %>
     <%@ page import="hangman.businessLogic.GameBean" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<%
GameBean myGame=(GameBean)request.getAttribute("myGame");
String stringId=(String)request.getAttribute("id");
UUID id=UUID.fromString(stringId);%>

 <script type="text/javascript">
function createUrl(element){
	let id="<%=id%>";
window.location =  "/HangmanGame/Game/"+id+"?letter="+element.value;
}
</script>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>

 <div is="game" align="center">


<%if(myGame.getResult().equals("N")){%>
            <h3>Welcome to hangman game</h3>
            <h2>You have made <%=myGame.getTries()%> mistakes from total of <%=myGame.getMaxTries()%></h2>
            <h3>
            <b><%=myGame.getHiddenWord() %></b> 
            <sub>(<%=myGame.getHiddenWord().length()%>)</sub>
            </h3><br>
            <form action="Game" method="GET">
           <!--   <input type="hidden" name="id" value=<%=id%>>-->
            <input type="button" id="1" name="letter" value="a" onclick="createUrl(this)">
            <input type="button" id="2" name="letter" value="b" onclick="createUrl(this)">
            <input type="button" id="3" name="letter" value="c" onclick="createUrl(this)">
            <input type="button" id="4" name="letter" value="d" onclick="createUrl(this)">
            <input type="button" id="5" name="letter" value="e" onclick="createUrl(this)">
            <input type="button" id="6" name="letter" value="f" onclick="createUrl(this)">
            <input type="button" id="7" name="letter" value="g" onclick="createUrl(this)">
            <input type="button" id="8" name="letter" value="h" onclick="createUrl(this)">
            <input type="button" id="9" name="letter" value="i" onclick="createUrl(this)">
            <input type="button" id="10" name="letter" value="j" onclick="createUrl(this)">
            <input type="button" id="11" name="letter" value="k" onclick="createUrl(this)">
            <input type="button" id="12" name="letter" value="l" onclick="createUrl(this)">
            <input type="button" id="13" name="letter" value="m" onclick="createUrl(this)">
            <input type="button" id="14" name="letter" value="n" onclick="createUrl(this)">
            <input type="button" id="15" name="letter" value="o" onclick="createUrl(this)">
            <input type="button" id="16" name="letter" value="p" onclick="createUrl(this)">
            <input type="button" id="17" name="letter" value="q" onclick="createUrl(this)">
            <input type="button" id="18" name="letter" value="r" onclick="createUrl(this)">
            <input type="button" id="19" name="letter" value="s" onclick="createUrl(this)">
            <input type="button" id="20" name="letter" value="t" onclick="createUrl(this)">
            <input type="button" id="21" name="letter" value="u" onclick="createUrl(this)">
            <input type="button" id="22" name="letter" value="v" onclick="createUrl(this)">
            <input type="button" id="23" name="letter" value="w" onclick="createUrl(this)">
            <input type="button" id="24" name="letter" value="x" onclick="createUrl(this)">
            <input type="button" id="25" name="letter" value="y" onclick="createUrl(this)">
            <input type="button" id="26" name="letter" value="z" onclick="createUrl(this)">
            </form>
            <%=myGame.getUsedLetters() %> 
            <%System.out.println(myGame.getUsedLetters()); %>
   
            <%}else if (myGame.getResult().equals("W")){ %>
            You win!
            <%}else if (myGame.getResult().equals("L")){ %>
            You lose!
            <br>
            The word was: <%=myGame.getWord()%>
            <div align="left">
_____ <br>
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|   <br>
| &nbsp;&nbsp;&nbsp;@   <br>
|   &nbsp;&nbsp;&nbsp;/|\<br>
|   &nbsp;&nbsp;&nbsp;/&nbsp;\<br>   
|______<br> 
            </div>
            <%} %>
 </div>

</body>
</html>