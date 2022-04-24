package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("To change this license header, choose License Headers in Project Properties.\r\n");
      out.write("To change this template file, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>TODO supply a title</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <script>\r\n");
      out.write("            function test(){\r\n");
      out.write("                alert('aaaa');\r\n");
      out.write("            }\r\n");
      out.write("            function validation(){\r\n");
      out.write("                email=f.txtemail.value;\r\n");
      out.write("                password=f.txtpassword.value;\r\n");
      out.write("                fullname=f.txtfullname.value;\r\n");
      out.write("                phone=f.txtphone.value;\r\n");
      out.write("                pattern=/^[a-zA-Z]+[@][a-zA-Z]+([.][a-zA-Z]+){1,2}$/;\r\n");
      out.write("//                pattern1=/^{1,}$/;\r\n");
      out.write("//                pattern2=/^[0-9]{10,12}$/; //phone\r\n");
      out.write("                \r\n");
      out.write("                alert('aaa');\r\n");
      out.write("                //test email\r\n");
      out.write("//                if(!pattern.test(email)){\r\n");
      out.write("//                    document.getElementById(\"e1\").innerHTML=\"your email is not valid\";\r\n");
      out.write("//                    return false;\r\n");
      out.write("//                }else{\r\n");
      out.write("//                    document.getElementById(\"e1\").innerHTML=\"\";\r\n");
      out.write("//                }\r\n");
      out.write("//                //test password\r\n");
      out.write("//                if (!pattern1.test(password) ){\r\n");
      out.write("//                    document.getElementById(\"e2\").innerHTML=\"your password is not valid\";\r\n");
      out.write("//                    return false;\r\n");
      out.write("//                } else {\r\n");
      out.write("//                    document.getElementById(\"e2\").innerHTML=\"\";\r\n");
      out.write("//                //test full name\r\n");
      out.write("//                if (fullname.length == 0){\r\n");
      out.write("//                    document.getElementById(\"e3\").innerHTML=\"your full name is not valid\";\r\n");
      out.write("//                    return false;\r\n");
      out.write("//                } else {\r\n");
      out.write("//                    document.getElementById(\"e3\").innerHTML=\"\";\r\n");
      out.write("//                    \r\n");
      out.write("//                    //test phone number\r\n");
      out.write("//                } if (!pattern2.test(phone)){\r\n");
      out.write("//                    document.getElementById(\"e4\").innerHTML=\"your phone number is not valid\";\r\n");
      out.write("//                    return false;\r\n");
      out.write("//                } else {\r\n");
      out.write("//                    document.getElementById(\"e4\").innerHTML=\"\";\r\n");
      out.write("//                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form action=\"MainController\" method=\"POST\" name=\"f\">\r\n");
      out.write("            <p>email: <input type=\"text\" name=\"txtemail\" /><span id=\"e1\"></span></p>\r\n");
      out.write("            \r\n");
      out.write("            <!--pattern=\"^[a-zA-z]+[@][a-zA-Z]+([.]a-zA-Z+){1,2}$\"-->\r\n");
      out.write("            <p>password: <input type=\"password\" name=\"txtpassword\" /><span id=\"e2\"></span></p>\r\n");
      out.write("            <p>full name: <input type=\"text\" name=\"txtfullname\" /><span id=\"e3\"></span></p>\r\n");
      out.write("            <p>phone: <input type=\"text\" name=\"txtphone\" /><span id=\"e4\"></span></p>\r\n");
      out.write("            <p>Choose status: \r\n");
      out.write("                <select name=\"txtstatus\">\r\n");
      out.write("                    <option value=\"1\">Active</option>\r\n");
      out.write("                    <option value=\"0\">Inactive</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>Choose role: \r\n");
      out.write("                <select name=\"txtrole\">\r\n");
      out.write("                    <!--<option value=\"1\">admin</option>-->\r\n");
      out.write("                    <option value=\"0\">customer</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p><input type=\"submit\" value=\"create account\" name=\"action\" onclick=\"return validation()\"/></p>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
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
