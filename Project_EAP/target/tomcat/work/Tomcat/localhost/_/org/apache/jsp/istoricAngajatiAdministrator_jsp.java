/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-18 17:57:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Administrator;
import java.util.List;
import repositories.MagazinRepository;

public final class istoricAngajatiAdministrator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Great Vibes' rel='stylesheet'>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>ProjectEAP</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: url(background.jpg);\r\n");
      out.write("            background-size: 100%;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-family: Helvetica, sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        p {\r\n");
      out.write("            font-family: 'Great Vibes';font-size: 30px;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-top: 0px;\r\n");
      out.write("            margin-bottom: -20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h3 {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            background: rgba(0,0,0, 0.15);\r\n");
      out.write("            color: white;\r\n");
      out.write("            font: 1px Helvetica, sans-serif;\r\n");
      out.write("            text-indent: 30px;\r\n");
      out.write("            border-bottom-right-radius: 5px;\r\n");
      out.write("            border-bottom-left-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            width: 185px;\r\n");
      out.write("            margin-left: 5px;\r\n");
      out.write("            margin-right: 0px;\r\n");
      out.write("            margin-top:\t200px;\r\n");
      out.write("            margin-bottom: 0px;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=text], input[type=password], input[list] {\r\n");
      out.write("            width: 250px;\r\n");
      out.write("            padding: 10px 10px;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            border: 1px solid grey;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: #3d3d3d;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px 10px;\r\n");
      out.write("            margin: 5px 0;\r\n");
      out.write("            border: 1px solid white;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            width: 185px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            width: 185px;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h3>\r\n");
      out.write("    <p>Aplicatie pentru gestionarea unui magazin\r\n");
      out.write("        <form action=\"/administrator\" method=\"get\" style=\"margin-top: -53px; margin-right: -10px; float: right;\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <button type=\"submit\" style=\"width: 150px;\">Log out</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </p>\r\n");
      out.write("</h3>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f1\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Adaugare produs</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f2\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Setare stoc produs</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f3\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Produse vandute (Data)</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f4\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Produse vandute (Tip)</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f5\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Verificare stoc</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f7\" method=\"get\" style=\"margin-top: 0px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Add Magazin</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"/administrator_f6\" method=\"get\" style=\"margin-top: -14px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button type=\"submit\">Istoric Angajati</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br>\r\n");
      out.write("<form action=\"/administrator_f6\" method=\"post\" style=\"margin-top: 10px;\r\n");
      out.write("            margin-left: 25px;\r\n");
      out.write("            width: 290px;\r\n");
      out.write("            border: 1px solid white;\r\n");
      out.write("            -webkit-backdrop-filter: blur(5px);\r\n");
      out.write("            backdrop-filter: blur(5px);\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("            border-bottom-right-radius: 5px;\r\n");
      out.write("            border-bottom-left-radius: 5px;\r\n");
      out.write("            border-top-right-radius: 5px;\r\n");
      out.write("            border-top-left-radius: 5px;\r\n");
      out.write("            padding-bottom: 20px;\r\n");
      out.write("            padding-left: 40px;\r\n");
      out.write("            padding-top: 20px;\r\n");
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <label for=\"magazin\">ID Magazin</label>\r\n");
      out.write("        <input list=\"magazin\" name=\"magazin\" placeholder=\"ID\" required>\r\n");
      out.write("        <datalist id=\"magazin\">\r\n");
      out.write("\r\n");
      out.write("            ");

                List<Integer> listMagazine = MagazinRepository.magazinByAdministrator((Administrator) session.getAttribute("adm"));
                if (listMagazine != null) {
                    for (int i = 0; i < listMagazine.size(); i++) {
                        out.print("<option value='" + listMagazine.get(i) + "'>");
                    }
                } else out.print("<option value='Niciun magazin'>");
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </datalist>\r\n");
      out.write("        <button type=\"submit\" style=\"width: 250px;\">Istoric angajati</button>\r\n");
      out.write("        <br>\r\n");
      out.write("\r\n");
      out.write("            ");

                if (request.getAttribute("mesaj") != null) {
                    List<String> stoc = (List<String>) request.getAttribute("mesaj");
                    for (int i = 0; i < stoc.size(); i++) {
                        out.print("<label>" + stoc.get(i) + "</label><br>");
                    }
                } else out.print("");
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
