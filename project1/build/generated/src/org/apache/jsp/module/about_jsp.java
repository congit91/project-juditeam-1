package org.apache.jsp.module;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>About Page</title>\n");
      out.write("        <link href=\"../css/bootstrap-theme.css\" rel=\"stylesheet\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n");
      out.write("        <link href=\"../css/bootstrap.css\"rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"../css/blog.css\"rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"col-lg-8 col-md-8 col-sm-8\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3><span class=\"glyphicon glyphicon-home\"></span>&nbsp; Giới thiệu</h3>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"panel-body\">\n");
      out.write("                     <b style=\"color:#28a4c9\">Chương trình mục tiêp quốc qua về xây dựng nông thôn mới giai đoạn 2010-2020(29/10/2010)</b>\n");
      out.write("                     <p>Chương trình mục tiêu quốc gia về xây dựng nông thôn mới là một chương trình tổng thể về phát triển kinh tế - \n");
      out.write("                         xã hội, chính trị và an ninh quốc phòng, gồm 11 nội dung sau: </p>\n");
      out.write("                     <p>1. Quy hoạch xây dựng nông thôn mới</p>\n");
      out.write("                     <p>a) Mục tiêu: đạt yêu cầu tiêu chí số 01 của Bộ tiêu chí quốc gia nông thôn mới. Đến năm 2011, cơ bản phủ kín \n");
      out.write("                         hoạch xây dựng nông thôn trên địa bàn cả nước làm cơ sở đầu tư xây dựng nông thôn mới, làm cơ sở để thực hiện\n");
      out.write("                         mục tiêu quốc gia xây dựng nông thôn mới giai đoạn 2010 - 2020;</p>\n");
      out.write("                     <p>b) Nội dung:</p>\n");
      out.write("                     <p> Nội dung 1: Quy hoạch sử dụng đất và hạ tầng thiết yếu cho phát triển sản xuất nông nghiệp hàng hóa, công nghiệp,\n");
      out.write("                         tiểu thủ công nghiệp và dịch vụ;</p>\n");
      out.write("                     <p>- Nội dung 2: Quy hoạch phát triển hạ tầng kinh tế - xã hội - môi trường; phát triển các khu dân cư mới và chỉnh\n");
      out.write("                         trang các khu dân cư hiện có trên địa bàn xã. </p>\n");
      out.write("                     <p>c) Phân công quản lý, thực hiện:</p>\n");
      out.write("                     <p>- Bộ Nông nghiệp và Phát triển nông thôn chủ trì, phối hợp với Bộ Tài nguyên và Môi trường hướng dẫn thực hiện nội\n");
      out.write("                         dung 1 “Quy hoạch sử dụng đất và hạ tầng thiết yếu cho phát triển sản xuất nông nghiệp hàng hóa, công nghiệp, tiểu\n");
      out.write("                         thủ công nghiệp và dịch vụ”;</p>\n");
      out.write("                     <p>- Bộ Xây dựng hướng dẫn thực hiện nội dung 2: “Quy hoạch phát triển hạ tầng kinh tế - xã hội - môi trường; phát triển \n");
      out.write("                         các khu dân cư mới và chỉnh trang các khu dân cư hiện có trên địa bàn xã”;</p>\n");
      out.write("                     <p>- Ủy ban nhân dân các tỉnh, thành phố trực thuộc Trung ương, Ủy ban nhân dân các huyện, thị xã hướng dẫn các xã rà soát,\n");
      out.write("                         bổ sung và hoàn chỉnh 02 loại quy hoạch trên; đồng thời chỉ đạo thực hiện;</p>\n");
      out.write("                     <p>- Ủy ban nhân dân xã tổ chức lập quy hoạch, lấy ý kiến tham gia của cộng đồng dân cư, trình Ủy ban nhân dân huyện phê\n");
      out.write("                         duyệt và tổ chức thực hiện các quy hoạch đã được duyệt.</p>\n");
      out.write("                     <p></p>\n");
      out.write("                     <p></p>\n");
      out.write("                     <p></p>\n");
      out.write("                     <p></p>\n");
      out.write("                     <p></p>\n");
      out.write("                     <p></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
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
