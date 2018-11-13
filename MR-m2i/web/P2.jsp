<%-- 
    Document   : P2
    Created on : 2 juin 2018, 18:35:16
    Author     : med
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  <h1></h1></br>
             <form action="servlet0" method="POST" >
            <input type="text"  name="text1" value="" charset="UTF-8" />
              <input type="submit" value="Search" charset="UTF-8" />
              <select name="lang">
                  <option value="En">en</option>
                  <option value="Fr">fr</option>
                  <option value="Ar" >ar</option>
              </select>
              <select name="langRcherche">
                 <option value="En">en</option>
                  <option value="Fr">fr</option>
                  <option value="Ar" >ar</option>
              </select>
              <select name="mot">
                 <option value="">mot</option>
                  <option value="Stemme">stemme</option>
                  <option value="Lemme" >lemme</option>
              </select>
              
              <select name="tra">
                 
                  <option value="apT">ApT</option>
                  <option value="Tr" >Tr</option>
              </select> </form>
        qsdfghjk<%=request.getAttribute("url")%><a href="P1.jsp" target="_blank">tttt</a>
                
        </body>
</html>
