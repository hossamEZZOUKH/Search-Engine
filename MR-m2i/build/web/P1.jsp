<%-- 
    Document   : P1
    Created on : 2 juin 2018, 18:18:45
    Author     : med
--%>

<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
        <title>JSP Page</title>
        <link rel="stylesheet" href="Cs.css" type="text/css"/>
    </head>
    <body>
        
        <header>                     
       
         <form action="servlet0" method="POST" >
           
    
                 <fieldset class="f1">
                    
                                  <fieldset class="f2">
                                      <input type="text"  name="text1"  placeholder="search" border="2px"  class="re" value="<%=request.getAttribute("text")%>" />
      <input type="submit" value="Search" charset="UTF-8" id="btn" />
    
                     </fieldset>
                     <select name="lang" id="s1">
                 
                  <option value="En">anglais</option>
                  <option value="Fr">français</option>
                  <option value="Ar" >arabe</option>
              </select>
                     <select name="langRcherche" id="s1">
                  <option value="Ar" >arabe</option>
                 <option value="En">anglais</option>
                  <option value="Fr">français</option>
                  
              </select>
                     <select name="mot" id="s1">
                 <option value="">mot</option>
                  <option value="Stemme">stemme</option>
                  <option value="Lemme" >lemme</option>
              </select>
                     <select name="tra" id="s1" >
                 <option value="Tr">traduction</option>
                 <option value="Stemme">stemme</option>
                  
              </select>     
           </fieldset>
          
          
            
        </form>
            </header>
        <section>
            <table>
                <tr>
                    <th><fieldset id="F"><legend>les liens</legend>
                        
                     <article class="art1">
                         <nav>
                             <a href="P1.jsp"> <%=request.getAttribute("url")%> </a>
                 </nav>
            </article> 
                  </fieldset>
                    </th>
                    <th><fieldset id="F"><legend>la traduction</legend>
                      <article class="ar2">
                      <nav>
       
        <%=request.getAttribute("a")%>
                 </nav>
            </article> 
                 </fieldset>
                    </th>
                </tr>
            </table>
         
            
        </section>
       
    </body>
    
</html>
