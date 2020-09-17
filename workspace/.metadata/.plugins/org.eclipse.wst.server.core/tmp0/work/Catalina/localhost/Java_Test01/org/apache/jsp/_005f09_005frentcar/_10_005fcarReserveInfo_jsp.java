/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2020-01-21 04:38:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005f09_005frentcar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _09_rentcar.RentcarDao;
import _09_rentcar.Rentcar;

public final class _10_005fcarReserveInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("_09_rentcar.RentcarDao");
    _jspx_imports_classes.add("_09_rentcar.Rentcar");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>10_carReserveInfo</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		int no = Integer.parseInt(request.getParameter("no"));


		// 렌트카 하나에 대한 정보를 얻어옴
		Rentcar bean = RentcarDao.instance.getOneCar(no);

		int category = bean.getCategory();
		String temp = "";
		if (category == 1)
			temp = "소형";
		else if (category == 2)
			temp = "중형";
		else if (category == 3)
			temp = "대형";
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"01_main.jsp?center=11_carOptionSelect.jsp\"\r\n");
      out.write("\t\t\tmethod=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr height=\"100\">\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" colspan=\"3\"><font size=\"6\" color=\"gray\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(bean.getName());
      out.write(" 차량 선택\r\n");
      out.write("\t\t\t\t\t</font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td rowspan=\"6\" width=\"500\" align=\"center\"><img alt=\"\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"_09_imgCar/");
      out.print(bean.getImg());
      out.write("\" width=\"450\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">차량이름</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">");
      out.print(bean.getName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">차량수량</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\"><select name=\"qty\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">차량분류</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">");
      out.print(temp);
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">대여가격</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">");
      out.print(bean.getPrice());
      out.write("원</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">제조회사</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">");
      out.print(bean.getCompany());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"250\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write(" <input type=\"hidden\" name=\"no\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(bean.getNo());
      out.write("\" /> <input type=\"hidden\" name=\"img\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(bean.getImg());
      out.write("\" /> <input type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"옵션선택후 구매하기\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<br /> <font size=\"5\" color=\"gray\">차랑 정보 보기</font>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t");
      out.print( bean.getInfo() );
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
