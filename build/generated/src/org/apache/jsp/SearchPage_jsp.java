package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import default_package.Bean;

public final class SearchPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<style>\r\n");
      out.write("    textarea\r\n");
      out.write("    {\r\n");
      out.write("        overflow-y:scroll;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Microminer</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h2>KWIC Microminer</h2>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("     \r\n");
      out.write("        ");

            Bean bean = (Bean) request.getSession().getAttribute("bean");
            ArrayList<String> input = new ArrayList<String>();
            ArrayList<String> results = new ArrayList<String>();
            if (bean != null) {
                System.out.println("Bean not null");
                input = bean.getInput();
                results = bean.getResults();
            }
            String search = (String) request.getAttribute("search");
            if (search == null) {
                search = "";
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/InputServlet\" method=\"post\">\r\n");
      out.write("            <textarea type=\"text\" placeholder=\"Input\" name=\"input\" rows=\"15\" cols=\"150\">");
 if (input != null)
                        for (int i = 0; i < input.size(); i++) {
      out.write("\r\n");
      out.write("                ");
      out.print(input.get(i));
      out.write("\r\n");
      out.write("                ");
 }
      out.write("</textarea>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit Input\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SearchServlet\" method=\"post\">\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <input type=\"text\" name=\"search\" placeholder=\"Search\" value=");
      out.print(search);
      out.write(">\r\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit\"/>\r\n");
      out.write("            <br><textarea name=\"output\" rows=\"15\" cols=\"150\">");
 if (results != null)
        for (int i = 0; i < results.size(); i++) {
      out.write("     \r\n");
      out.write("            ");
      out.print(results.get(i));
      out.write("\r\n");
      out.write("            ");
 }
      out.write("</textarea>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ClearDBServlet\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" name=\"clearDB\" value=\"Clear Database\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("</html>\r\n");
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
