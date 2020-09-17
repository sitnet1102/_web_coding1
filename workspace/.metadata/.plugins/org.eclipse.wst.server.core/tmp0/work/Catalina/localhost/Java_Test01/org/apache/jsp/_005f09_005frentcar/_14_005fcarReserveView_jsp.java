/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2020-01-21 04:41:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005f09_005frentcar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import _09_rentcar.RentcarDao;
import _09_rentcar.CarView;
import java.util.Vector;

public final class _14_005fcarReserveView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("_09_rentcar.RentcarDao");
    _jspx_imports_classes.add("_09_rentcar.CarView");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" ");

		// 로그인 되어있는 아이디를 읽어옴
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
	
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\talert(\"로그인을 먼저 해주세요.\");\r\n");
      out.write("\t\t\tlocation.href = '01_main.jsp?center=05_memberLogin.jsp';\r\n");
      out.write("\t\t</script>\t\r\n");
      out.write("\t");

		}			
		ArrayList<CarView> list = RentcarDao.instance.getAllReserve(id);
	
      out.write(" \r\n");
      out.write(" <div align=\"center\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr height=\"100\">\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"11\"> \r\n");
      out.write("\t\t\t\t\t<font size=\"6\" color=\"gray\"> 차량 예약 완료 화면 </font> \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr height=\"40\">\r\n");
      out.write("\t\t\t\t<td width=\"150\" align=\"center\"> 이미지 </td>\r\n");
      out.write("\t\t\t\t<td width=\"150\" align=\"center\"> 이름 </td>\r\n");
      out.write("\t\t\t\t<td width=\"150\" align=\"center\"> 대여일 </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> 대여기간 </td>\r\n");
      out.write("\t\t\t\t<td width=\"100\" align=\"center\"> 금액 </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> 수량 </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> 보험 </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> wifi </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> 베이비시트 </td>\r\n");
      out.write("\t\t\t\t<td width=\"60\" align=\"center\"> 네비게이션 </td>\r\n");
      out.write("\t\t\t\t<td width=\"90\" align=\"center\"> 삭제 </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t");

	for(CarView bean : list){
	
      out.write("\t\t\r\n");
      out.write("\t\t<tr height=\"70\">\t\r\n");
      out.write("\t\t\t<td height=\"70\" align=\"center\">\r\n");
      out.write("\t\t\t\t<img src=\"_09_imgCar/");
      out.print(bean.getImg() );
      out.write("\"  width=\"120\" height=\"70\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"100\" align=\"center\">");
      out.print(bean.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"150\" align=\"center\">");
      out.print(bean.getRday() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"150\" align=\"center\">");
      out.print(bean.getDday() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"100\" align=\"center\">");
      out.print(bean.getPrice() );
      out.write(" 원</td>\r\n");
      out.write("\t\t\t<td width=\"60\" align=\"center\">");
      out.print(bean.getQty() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"100\" align=\"center\">");
      out.print(bean.getUsein() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"60\" align=\"center\">");
      out.print(bean.getUsewifi() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"60\" align=\"center\">");
      out.print(bean.getUseseat() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"60\" align=\"center\">");
      out.print(bean.getUsenavi() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"90\" align=\"center\">\r\n");
      out.write("\t\t\t\t<button onclick=\"location.href='15_carReserveDel.jsp?id=");
      out.print( id );
      out.write("&rday=");
      out.print( bean.getRday() );
      out.write("'\">삭제</button>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t");

	}
	
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
