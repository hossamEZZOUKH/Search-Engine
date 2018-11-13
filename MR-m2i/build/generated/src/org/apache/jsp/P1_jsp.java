package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class P1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" >\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Cs.css\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <header>                     \n");
      out.write("       \n");
      out.write("         <form action=\"servlet0\" method=\"POST\" >\n");
      out.write("           \n");
      out.write("    \n");
      out.write("                 <fieldset class=\"f1\">\n");
      out.write("                    \n");
      out.write("                                  <fieldset class=\"f2\">\n");
      out.write("                                      <input type=\"text\"  name=\"text1\"  placeholder=\"search\" border=\"2px\"  class=\"re\" value=\"");
      out.print(request.getAttribute("text"));
      out.write("\" />\n");
      out.write("      <input type=\"submit\" value=\"Search\" charset=\"UTF-8\" id=\"btn\" />\n");
      out.write("    \n");
      out.write("                     </fieldset>\n");
      out.write("                     <select name=\"lang\" id=\"s1\">\n");
      out.write("                 \n");
      out.write("                  <option value=\"En\">anglais</option>\n");
      out.write("                  <option value=\"Fr\">français</option>\n");
      out.write("                  <option value=\"Ar\" >arabe</option>\n");
      out.write("              </select>\n");
      out.write("                     <select name=\"langRcherche\" id=\"s1\">\n");
      out.write("                  <option value=\"Ar\" >arabe</option>\n");
      out.write("                 <option value=\"En\">anglais</option>\n");
      out.write("                  <option value=\"Fr\">français</option>\n");
      out.write("                  \n");
      out.write("              </select>\n");
      out.write("                     <select name=\"mot\" id=\"s1\">\n");
      out.write("                 <option value=\"\">mot</option>\n");
      out.write("                  <option value=\"Stemme\">stemme</option>\n");
      out.write("                  <option value=\"Lemme\" >lemme</option>\n");
      out.write("              </select>\n");
      out.write("                     <select name=\"tra\" id=\"s1\" >\n");
      out.write("                 <option value=\"Tr\">traduction</option>\n");
      out.write("                 <option value=\"Stemme\">stemme</option>\n");
      out.write("                  \n");
      out.write("              </select>     \n");
      out.write("           </fieldset>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("            </header>\n");
      out.write("        <section>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th><fieldset id=\"F\"><legend>les liens</legend>\n");
      out.write("                        \n");
      out.write("                     <article class=\"art1\">\n");
      out.write("                         <nav>\n");
      out.write("                             <a href=\"P1.jsp\"> ");
      out.print(request.getAttribute("url"));
      out.write(" </a>\n");
      out.write("                 </nav>\n");
      out.write("            </article> \n");
      out.write("                  </fieldset>\n");
      out.write("                    </th>\n");
      out.write("                    <th><fieldset id=\"F\"><legend>la traduction</legend>\n");
      out.write("                      <article class=\"ar2\">\n");
      out.write("                      <nav>\n");
      out.write("       \n");
      out.write("        ");
      out.print(request.getAttribute("a"));
      out.write("\n");
      out.write("                 </nav>\n");
      out.write("            </article> \n");
      out.write("                 </fieldset>\n");
      out.write("                    </th>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("         \n");
      out.write("            \n");
      out.write("        </section>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
