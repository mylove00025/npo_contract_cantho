package org.apache.jsp.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;

public final class ADM019_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/jsp/common/header.jsp");
    _jspx_dependants.add("/jsp/common/hight_light.jsp");
    _jspx_dependants.add("/jsp/common/error_message.jsp");
    _jspx_dependants.add("/jsp/common/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhtml;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fhtml = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fhtml.release();
    _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname.release();
    _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.release();
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.release();
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.release();
    _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      //  html:html
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml.get(org.apache.struts.taglib.html.HtmlTag.class);
      _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
      _jspx_th_html_005fhtml_005f0.setParent(null);
      int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
      if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          //  logic:notPresent
          org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_005fnotPresent_005f0 = (org.apache.struts.taglib.logic.NotPresentTag) _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname.get(org.apache.struts.taglib.logic.NotPresentTag.class);
          _jspx_th_logic_005fnotPresent_005f0.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fnotPresent_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/common/header.jsp(6,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_logic_005fnotPresent_005f0.setName("CommonContext");
          int _jspx_eval_logic_005fnotPresent_005f0 = _jspx_th_logic_005fnotPresent_005f0.doStartTag();
          if (_jspx_eval_logic_005fnotPresent_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("    ");

    	response.sendRedirect("./");
    
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_logic_005fnotPresent_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fnotPresent_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname.reuse(_jspx_th_logic_005fnotPresent_005f0);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fnotPresent_0026_005fname.reuse(_jspx_th_logic_005fnotPresent_005f0);
          out.write("\r\n");
          out.write("\r\n");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_005fdefine_005f0 = (org.apache.struts.taglib.bean.DefineTag) _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_005fdefine_005f0.setPageContext(_jspx_page_context);
          _jspx_th_bean_005fdefine_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/common/header.jsp(12,0) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_bean_005fdefine_005f0.setId("context");
          // /jsp/common/header.jsp(12,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_bean_005fdefine_005f0.setName("CommonContext");
          // /jsp/common/header.jsp(12,0) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_bean_005fdefine_005f0.setType("com.osp.npo.app.context.CommonContext");
          int _jspx_eval_bean_005fdefine_005f0 = _jspx_th_bean_005fdefine_005f0.doStartTag();
          if (_jspx_th_bean_005fdefine_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f0);
          com.osp.npo.app.context.CommonContext context = null;
          context = (com.osp.npo.app.context.CommonContext) _jspx_page_context.findAttribute("context");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<head>\r\n");
          out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
          out.write("    <meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\r\n");
          out.write("    <meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\" />\r\n");
          out.write("    <title>");
          if (_jspx_meth_bean_005fwrite_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</title>\r\n");
          out.write("    <link rel=\"SHORTCUT ICON\" href=\"./image/osp.ico\"/>\r\n");
          out.write("    <link href=\"./style/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen,print\" />\r\n");
          out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./style/calendar.css\" />\r\n");
          out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./style/border-radius.css\" />\r\n");
          out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./style/steel.css\" />\r\n");
          out.write("     <link rel=\"stylesheet\" type=\"text/css\" href=\"./style/home-style.css\" />\r\n");
          out.write("    <!--[if IE 7]>\r\n");
          out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./style/style_ie.css\" />\r\n");
          out.write("    <![endif]-->\r\n");
          out.write("\r\n");
          out.write("    <script type=\"text/javascript\" src=\"./javascript/jquery.min.js\"></script>\r\n");
          out.write("    <script type=\"text/javascript\" src=\"./javascript/gmenu.js\"></script>\r\n");
          out.write("    <script type=\"text/javascript\" src=\"./javascript/stickytooltip.js\"></script>\r\n");
          out.write("    <script language=\"JavaScript\" src=\"javascript/calendar.js\"></script>\r\n");
          out.write("    <script language=\"JavaScript\" src=\"javascript/vn.js\"></script>\r\n");
          out.write("    <script language=\"JavaScript\" src=\"javascript/common.js\"></script>\r\n");
          out.write("</head>\r\n");
          out.write("\r\n");
          out.write("<body>\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          //  logic:present
          org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_005fpresent_005f0 = (org.apache.struts.taglib.logic.PresentTag) _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.get(org.apache.struts.taglib.logic.PresentTag.class);
          _jspx_th_logic_005fpresent_005f0.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fpresent_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/common/hight_light.jsp(4,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_logic_005fpresent_005f0.setName("org.apache.struts.action.ERROR");
          int _jspx_eval_logic_005fpresent_005f0 = _jspx_th_logic_005fpresent_005f0.doStartTag();
          if (_jspx_eval_logic_005fpresent_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("    ");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_005fdefine_005f1 = (org.apache.struts.taglib.bean.DefineTag) _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_005fdefine_005f1.setPageContext(_jspx_page_context);
              _jspx_th_bean_005fdefine_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f0);
              // /jsp/common/hight_light.jsp(5,4) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_bean_005fdefine_005f1.setId("errors");
              // /jsp/common/hight_light.jsp(5,4) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_bean_005fdefine_005f1.setName("org.apache.struts.action.ERROR");
              // /jsp/common/hight_light.jsp(5,4) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_bean_005fdefine_005f1.setType("org.apache.struts.action.ActionMessages");
              int _jspx_eval_bean_005fdefine_005f1 = _jspx_th_bean_005fdefine_005f1.doStartTag();
              if (_jspx_th_bean_005fdefine_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f1);
                return;
              }
              _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f1);
              org.apache.struts.action.ActionMessages errors = null;
              errors = (org.apache.struts.action.ActionMessages) _jspx_page_context.findAttribute("errors");
              out.write("\r\n");
              out.write("    ");
request.setAttribute("ERROR_FIELD", errors.properties());
              out.write("\r\n");
              out.write("\r\n");
              out.write("<script language=\"javascript\">\r\n");
              out.write("    var itemArr = [];\r\n");
              out.write("    var element = null;\r\n");
              out.write("    if (window.addEventListener){\r\n");
              out.write("        window.addEventListener('load', highlight, false);\r\n");
              out.write("    } else if (window.attachEvent){\r\n");
              out.write("        window.attachEvent('onload', highlight);\r\n");
              out.write("    }\r\n");
              out.write("    function highlight() {\r\n");
              out.write("    ");
              //  logic:iterate
              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f0 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
              _jspx_th_logic_005fiterate_005f0.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fiterate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f0);
              // /jsp/common/hight_light.jsp(17,4) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fiterate_005f0.setId("errField");
              // /jsp/common/hight_light.jsp(17,4) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fiterate_005f0.setName("ERROR_FIELD");
              int _jspx_eval_logic_005fiterate_005f0 = _jspx_th_logic_005fiterate_005f0.doStartTag();
              if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.Object errField = null;
                if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_logic_005fiterate_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_logic_005fiterate_005f0.doInitBody();
                }
                errField = (java.lang.Object) _jspx_page_context.findAttribute("errField");
                do {
                  out.write("\r\n");
                  out.write("        //Get control id\r\n");
                  out.write("        var varState = \"");
                  if (_jspx_meth_bean_005fwrite_005f1(_jspx_th_logic_005fiterate_005f0, _jspx_page_context))
                    return;
                  out.write("\";\r\n");
                  out.write("        //check if control contain special character\r\n");
                  out.write("        var lastIndex = varState.lastIndexOf('-');\r\n");
                  out.write("        //if control has special character, remove them\r\n");
                  out.write("        if (lastIndex >= 0){\r\n");
                  out.write("            varState = varState.substring(0, lastIndex);\r\n");
                  out.write("        }\r\n");
                  out.write("       //Set class style name for row/column/header\r\n");
                  out.write("        element = document.getElementById(varState +'_tr');\r\n");
                  out.write("        if (element) {\r\n");
                  out.write("            element.className += ' error-cell';\r\n");
                  out.write("        }\r\n");
                  out.write("        element = document.getElementById(varState +'_th');\r\n");
                  out.write("        if (element) {\r\n");
                  out.write("            element.className += ' error-cell';\r\n");
                  out.write("        }\r\n");
                  out.write("        element = document.getElementById(varState +'_td');\r\n");
                  out.write("        if (element) {\r\n");
                  out.write("            element.className += ' error-cell';\r\n");
                  out.write("        }\r\n");
                  out.write("    ");
                  int evalDoAfterBody = _jspx_th_logic_005fiterate_005f0.doAfterBody();
                  errField = (java.lang.Object) _jspx_page_context.findAttribute("errField");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.popBody();
                }
              }
              if (_jspx_th_logic_005fiterate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fname_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
              out.write("\r\n");
              out.write("    }\r\n");
              out.write("\r\n");
              out.write("</script>\r\n");
              int evalDoAfterBody = _jspx_th_logic_005fpresent_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fpresent_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f0);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f0);
          out.write("\r\n");
          out.write("    <table id=\"wrapper\">\r\n");
          out.write("    <tr>\r\n");
          out.write("    <td valign=\"top\">\r\n");
          out.write("    <div id=\"header\">\r\n");
          out.write("        <div id=\"banner\">\r\n");
          out.write("            <div style=\"background: url(./image/header_banner_npo.gif) no-repeat; height: 43px;\">\r\n");
          out.write("                <div style=\"font-size: 110%; font-weight: bold; bottom: 10px; position: absolute; padding-left: 120px; color: #DF0101; text-shadow: 2px 2px 4px white;\">\r\n");
          out.write("                ");
          if (_jspx_meth_logic_005fpresent_005f1(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                </div>\r\n");
          out.write("            </div>\r\n");
          out.write("            <div id=\"admin-area\">\r\n");
          out.write("                ");
          if (_jspx_meth_html_005fimg_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                <span>[");
          if (_jspx_meth_bean_005fwrite_005f5(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("]</span>\r\n");
          out.write("                <span style=\"color:white;\">&nbsp;|&nbsp;</span>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005fimg_005f1(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f1(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("\r\n");
          out.write("        <div id=\"gmenu\">\r\n");
          out.write("          <ul id=\"jsddm\">\r\n");
          out.write("              <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f2(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("              </li>\r\n");
          out.write("              <li>\r\n");
          out.write("                ");
          if (_jspx_meth_logic_005fequal_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                ");
          if (_jspx_meth_logic_005fnotEqual_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("              </li>\r\n");
          out.write("              <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f7(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                <ul>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f8(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    ");
          out.write("\r\n");
          out.write("                    \r\n");
          out.write("                    ");
          if (_jspx_meth_logic_005fequal_005f1(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                </ul>\r\n");
          out.write("              </li>\r\n");
          out.write("              ");

              	if (context.isAnnouncementManagement()) {
              
          out.write("\r\n");
          out.write("              <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f10(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("              </li>\r\n");
          out.write("              ");

              	}
              
          out.write("\r\n");
          out.write("              ");

              	if (context.isAdmin()) {
              
          out.write("\r\n");
          out.write("              <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f11(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                <ul>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f12(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f13(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f14(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f15(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f16(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    <li>");
          if (_jspx_meth_html_005flink_005f17(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("</li>\r\n");
          out.write("                    ");
          if (_jspx_meth_logic_005fequal_005f2(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                </ul>\r\n");
          out.write("              </li>\r\n");
          out.write("              \r\n");
          out.write("             <!--  <li>\r\n");
          out.write("                <a  target=\"_blank\" href=\"http://192.168.1.209:8080/forum/login.do?u=");
          out.print(context.getUserInfo().getFullName());
          out.write(" &o=000 &ur=administrator &acc=");
          out.print(context.getUserInfo().getAccount());
          out.write(" &p=");
          out.print(context.getUserInfo().getPassword());
          out.write("\">\r\n");
          out.write("                    <em class=\"forum-off\">&nbsp;</em>\r\n");
          out.write("                    <b>Diễn đàn</b>\r\n");
          out.write("                    ");
          if (_jspx_meth_html_005fimg_005f8(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                </a>\r\n");
          out.write("              </li> -->\r\n");
          out.write("           \r\n");
          out.write("              ");

              	}
              
          out.write("\r\n");
          out.write("          </ul> \t\r\n");
          out.write("          ");
          if (_jspx_meth_html_005flink_005f19(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write(" \r\n");
          out.write("          ");
          if (_jspx_meth_html_005flink_005f20(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write(" \r\n");
          out.write("          ");
          if (_jspx_meth_html_005flink_005f21(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("        </div>\r\n");
          out.write("\r\n");
          out.write("    </div>\r\n");
          out.write("    <div id=\"content\" class=\"clearfix\">\r\n");
          out.write("\r\n");
          out.write("    <div id=\"navigator\">\r\n");
          out.write("\t     <ul class=\"clearfix\">\r\n");
          out.write("\t         <li>\r\n");
          out.write("                 ");
          if (_jspx_meth_html_005fimg_005f9(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("             </li>\r\n");
          out.write("\t         <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f22(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("                <span> &gt; </span>\r\n");
          out.write("            </li>\r\n");
          out.write("            <li>\r\n");
          out.write("                ");
          if (_jspx_meth_html_005flink_005f23(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("            </li>                 \r\n");
          out.write("\t     </ul>\r\n");
          out.write("    </div>\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          if (_jspx_meth_logic_005fpresent_005f2(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\r\n");
          //  logic:present
          org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_005fpresent_005f3 = (org.apache.struts.taglib.logic.PresentTag) _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.get(org.apache.struts.taglib.logic.PresentTag.class);
          _jspx_th_logic_005fpresent_005f3.setPageContext(_jspx_page_context);
          _jspx_th_logic_005fpresent_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/common/error_message.jsp(11,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_logic_005fpresent_005f3.setName("org.apache.struts.action.ACTION_MESSAGE");
          int _jspx_eval_logic_005fpresent_005f3 = _jspx_th_logic_005fpresent_005f3.doStartTag();
          if (_jspx_eval_logic_005fpresent_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("    <div class=\"message_box\" id=\"message_box\">\r\n");
              out.write("        ");
              //  html:messages
              org.apache.struts.taglib.html.MessagesTag _jspx_th_html_005fmessages_005f0 = (org.apache.struts.taglib.html.MessagesTag) _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid.get(org.apache.struts.taglib.html.MessagesTag.class);
              _jspx_th_html_005fmessages_005f0.setPageContext(_jspx_page_context);
              _jspx_th_html_005fmessages_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f3);
              // /jsp/common/error_message.jsp(13,8) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_html_005fmessages_005f0.setId("message");
              // /jsp/common/error_message.jsp(13,8) name = message type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_html_005fmessages_005f0.setMessage("true");
              int _jspx_eval_html_005fmessages_005f0 = _jspx_th_html_005fmessages_005f0.doStartTag();
              if (_jspx_eval_html_005fmessages_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.String message = null;
                if (_jspx_eval_html_005fmessages_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_html_005fmessages_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_html_005fmessages_005f0.doInitBody();
                }
                message = (java.lang.String) _jspx_page_context.findAttribute("message");
                do {
                  out.write("\r\n");
                  out.write("            ");
                  if (_jspx_meth_bean_005fwrite_005f6(_jspx_th_html_005fmessages_005f0, _jspx_page_context))
                    return;
                  out.write("<br>\r\n");
                  out.write("        ");
                  int evalDoAfterBody = _jspx_th_html_005fmessages_005f0.doAfterBody();
                  message = (java.lang.String) _jspx_page_context.findAttribute("message");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_html_005fmessages_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.popBody();
                }
              }
              if (_jspx_th_html_005fmessages_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid.reuse(_jspx_th_html_005fmessages_005f0);
                return;
              }
              _005fjspx_005ftagPool_005fhtml_005fmessages_0026_005fmessage_005fid.reuse(_jspx_th_html_005fmessages_005f0);
              out.write("\r\n");
              out.write("    </div>\r\n");
              int evalDoAfterBody = _jspx_th_logic_005fpresent_005f3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_005fpresent_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f3);
            return;
          }
          _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f3);
          out.write("  \r\n");
          out.write("                      \r\n");
          out.write("    ");
          //  html:form
          org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction.get(org.apache.struts.taglib.html.FormTag.class);
          _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
          _jspx_th_html_005fform_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/admin/ADM019.jsp(26,4) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_html_005fform_005f0.setAction("contractHistorylistview");
          // /jsp/admin/ADM019.jsp(26,4) name = onsubmit type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_html_005fform_005f0.setOnsubmit("javascript: searchOnClick()");
          int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
          if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("        <span class=\"sub-title\">◊ Điều kiện tìm kiếm</span>\r\n");
              out.write("        <table class=\"tbl-search\" summary=\"Thông tin tìm kiếm\">\r\n");
              out.write("            <tr>\r\n");
              out.write("                <th>Số hợp đồng</th>\r\n");
              out.write("                <td>\r\n");
              out.write("                    ");
              if (_jspx_meth_html_005ftext_005f0(_jspx_th_html_005fform_005f0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                </td>\r\n");
              out.write("                <th>Nội dung</th> \r\n");
              out.write("                <td>\r\n");
              out.write("                \t");
              if (_jspx_meth_html_005ftext_005f1(_jspx_th_html_005fform_005f0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                </td>\r\n");
              out.write("                <td style=\"text-align:center;\">\r\n");
              out.write("                   ");
              if (_jspx_meth_html_005fimage_005f0(_jspx_th_html_005fform_005f0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                </td>\r\n");
              out.write("            </tr>\r\n");
              out.write("        </table>\r\n");
              out.write("\r\n");
              out.write("        <div class=\"clearfix-left\">\r\n");
              out.write("            <span>◊ Danh sách hợp đồng, giao dịch</span><br>\r\n");
              out.write("        </div>\r\n");
              out.write("        <!--<div class=\"clearfix-right\">\r\n");
              out.write("            <a href=\"addnewuser.do\" class=\"button\"><img src=\"./image/btn_add.png\" alt=\"Thêm mới\" /></a>\r\n");
              out.write("        </div>-->\r\n");
              out.write("        ");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_005fnotEmpty_005f0 = (org.apache.struts.taglib.logic.NotEmptyTag) _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_005fnotEmpty_005f0.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fnotEmpty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
              // /jsp/admin/ADM019.jsp(50,8) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fnotEmpty_005f0.setName("contractHistoryListViewHelper");
              // /jsp/admin/ADM019.jsp(50,8) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fnotEmpty_005f0.setProperty("contractHistoryList");
              int _jspx_eval_logic_005fnotEmpty_005f0 = _jspx_th_logic_005fnotEmpty_005f0.doStartTag();
              if (_jspx_eval_logic_005fnotEmpty_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("            <table class=\"tbl-list\">\r\n");
                  out.write("                <tr>\r\n");
                  out.write("                    <th width=\"10%\">Số hợp đồng</th>\r\n");
                  out.write("                    <th width=\"58%\">Nội dung</th>\r\n");
                  out.write("                    <th width=\"8%\">Thao tác</th>\r\n");
                  out.write("                    <th width=\"12%\">Người thực hiện</th>\r\n");
                  out.write("                    <th width=\"12%\">Ngày thực hiện</th>\r\n");
                  out.write("                </tr>\r\n");
                  out.write("\r\n");
                  out.write("                ");
                  //  logic:iterate
                  org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f1 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
                  _jspx_th_logic_005fiterate_005f1.setPageContext(_jspx_page_context);
                  _jspx_th_logic_005fiterate_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
                  // /jsp/admin/ADM019.jsp(60,16) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f1.setId("contract");
                  // /jsp/admin/ADM019.jsp(60,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f1.setName("contractHistoryListViewHelper");
                  // /jsp/admin/ADM019.jsp(60,16) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f1.setProperty("contractHistoryList");
                  // /jsp/admin/ADM019.jsp(60,16) name = indexId type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f1.setIndexId("i");
                  int _jspx_eval_logic_005fiterate_005f1 = _jspx_th_logic_005fiterate_005f1.doStartTag();
                  if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object contract = null;
                    java.lang.Integer i = null;
                    if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_logic_005fiterate_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_logic_005fiterate_005f1.doInitBody();
                    }
                    contract = (java.lang.Object) _jspx_page_context.findAttribute("contract");
                    i = (java.lang.Integer) _jspx_page_context.findAttribute("i");
                    do {
                      out.write("\r\n");
                      out.write("                    ");
int style = i % 2; 
                      out.write("\r\n");
                      out.write("                    <tr class=\"tbl-row");
                      out.print(style);
                      out.write("\">\r\n");
                      out.write("                    \t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_005fdefine_005f2 = (org.apache.struts.taglib.bean.DefineTag) _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_005fdefine_005f2.setPageContext(_jspx_page_context);
                      _jspx_th_bean_005fdefine_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
                      // /jsp/admin/ADM019.jsp(63,22) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f2.setId("contractId");
                      // /jsp/admin/ADM019.jsp(63,22) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f2.setName("contract");
                      // /jsp/admin/ADM019.jsp(63,22) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f2.setProperty("contractId");
                      int _jspx_eval_bean_005fdefine_005f2 = _jspx_th_bean_005fdefine_005f2.doStartTag();
                      if (_jspx_th_bean_005fdefine_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f2);
                        return;
                      }
                      _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f2);
                      java.lang.Object contractId = null;
                      contractId = (java.lang.Object) _jspx_page_context.findAttribute("contractId");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_005fdefine_005f3 = (org.apache.struts.taglib.bean.DefineTag) _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_005fdefine_005f3.setPageContext(_jspx_page_context);
                      _jspx_th_bean_005fdefine_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
                      // /jsp/admin/ADM019.jsp(64,7) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f3.setId("Id");
                      // /jsp/admin/ADM019.jsp(64,7) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f3.setName("contract");
                      // /jsp/admin/ADM019.jsp(64,7) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                      _jspx_th_bean_005fdefine_005f3.setProperty("hid");
                      int _jspx_eval_bean_005fdefine_005f3 = _jspx_th_bean_005fdefine_005f3.doStartTag();
                      if (_jspx_th_bean_005fdefine_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f3);
                        return;
                      }
                      _005fjspx_005ftagPool_005fbean_005fdefine_0026_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f3);
                      java.lang.Object Id = null;
                      Id = (java.lang.Object) _jspx_page_context.findAttribute("Id");
                      out.write("\r\n");
                      out.write("\t                        ");

			    						HashMap params = new HashMap();
										params.put("contractId", contractId);
										params.put("Id", Id);
										pageContext.setAttribute("paramsName", params);
							
                      out.write("\r\n");
                      out.write("                        <td>\r\n");
                      out.write("                            ");
                      if (_jspx_meth_html_005flink_005f24(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("\r\n");
                      out.write("                        </td>\r\n");
                      out.write("                        <td>\r\n");
                      out.write("                            ");
                      if (_jspx_meth_bean_005fwrite_005f8(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("\r\n");
                      out.write("                        </td>\r\n");
                      out.write("                        <td>");
                      if (_jspx_meth_bean_005fwrite_005f9(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("</td>\r\n");
                      out.write("                        <td>");
                      if (_jspx_meth_bean_005fwrite_005f10(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("</td>\r\n");
                      out.write("                        <td>");
                      if (_jspx_meth_bean_005fwrite_005f11(_jspx_th_logic_005fiterate_005f1, _jspx_page_context))
                        return;
                      out.write("</td>\r\n");
                      out.write("                    </tr>\r\n");
                      out.write("                ");
                      int evalDoAfterBody = _jspx_th_logic_005fiterate_005f1.doAfterBody();
                      contract = (java.lang.Object) _jspx_page_context.findAttribute("contract");
                      i = (java.lang.Integer) _jspx_page_context.findAttribute("i");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_logic_005fiterate_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.popBody();
                    }
                  }
                  if (_jspx_th_logic_005fiterate_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f1);
                    return;
                  }
                  _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f1);
                  out.write("\r\n");
                  out.write("\r\n");
                  out.write("            </table>\r\n");
                  out.write("\r\n");
                  out.write("            <div class=\"pager\">\r\n");
                  out.write("                <div class=\"pager-total\">\r\n");
                  out.write("                     Tổng số\r\n");
                  out.write("                     <strong>");
                  if (_jspx_meth_bean_005fwrite_005f12(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("</strong>\r\n");
                  out.write("                     hợp đồng, giao dịch\r\n");
                  out.write("                </div>\r\n");
                  out.write("                <div>\r\n");
                  out.write("                    ");
                  if (_jspx_meth_logic_005fgreaterThan_005f0(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("                    <span>\r\n");
                  out.write("                        Trang\r\n");
                  out.write("                        ");
                  if (_jspx_meth_bean_005fwrite_005f13(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("                        /\r\n");
                  out.write("                        ");
                  if (_jspx_meth_bean_005fwrite_005f14(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("&nbsp;&nbsp;\r\n");
                  out.write("                    </span>\r\n");
                  out.write("\r\n");
                  out.write("                    ");
                  if (_jspx_meth_logic_005fgreaterThan_005f1(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("                </div>\r\n");
                  out.write("                ");
                  if (_jspx_meth_html_005fhidden_005f0(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("            </div>\r\n");
                  out.write("        ");
                  int evalDoAfterBody = _jspx_th_logic_005fnotEmpty_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_005fnotEmpty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEmpty_005f0);
                return;
              }
              _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEmpty_005f0);
              out.write("\r\n");
              out.write("    ");
              int evalDoAfterBody = _jspx_th_html_005fform_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_html_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction.reuse(_jspx_th_html_005fform_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fhtml_005fform_0026_005fonsubmit_005faction.reuse(_jspx_th_html_005fform_005f0);
          out.write("\r\n");
          out.write("\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t</td>\r\n");
          out.write("    </tr>\r\n");
          out.write("    \r\n");
          out.write("    <tr height=\"30px\">\r\n");
          out.write("    <td>   \r\n");
          out.write("\t<div id=\"footer\">\r\n");
          out.write("\t    <div class=\"clearfix-left\">\r\n");
          out.write("\t        ");
          if (_jspx_meth_logic_005fpresent_005f4(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t    </div>\r\n");
          out.write("\t    <div class=\"clearfix-right\">\r\n");
          out.write("\t        © 2011 Bản quyền thuộc về\r\n");
          out.write("\t        <a href='http://www.osp.com.vn' target=\"_blank\">\r\n");
          out.write("               <img style=\"margin-bottom: -2px;\" src=\"./image/osp_logo_grey.gif\"/> osp.com.vn\r\n");
          out.write("            </a> \r\n");
          out.write("\t    </div>\r\n");
          out.write("\t</div>\r\n");
          out.write("\t</td>\r\n");
          out.write("\t</tr>\r\n");
          out.write("\t</table>\r\n");
          out.write("\r\n");
          out.write("</body>\r\n");
          out.write("\r\n");
          out.write("\t");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_html_005fhtml_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_005fhtml_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fhtml_005fhtml.reuse(_jspx_th_html_005fhtml_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fhtml_005fhtml.reuse(_jspx_th_html_005fhtml_005f0);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  $('#system > em').removeClass(\"system-off\");\r\n");
      out.write("  $('#system > em').addClass(\"system-on\");\r\n");
      out.write("  $('#system > b').addClass(\"menu-on\");\r\n");
      out.write("\r\n");
      out.write("  document.getElementById(\"firstControl\").focus();\r\n");
      out.write("\r\n");
      out.write("  function searchOnClick()\r\n");
      out.write("  {\r\n");
      out.write("     document.contractHistoryListForm.action=\"contractHistoryListsearch.do\";\r\n");
      out.write("     return true;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function direction(data){\r\n");
      out.write("      document.contractHistoryListForm.direction.value=data;\r\n");
      out.write("      document.contractHistoryListForm.action=\"contractHistoryListpage.do\";\r\n");
      out.write("      document.contractHistoryListForm.submit();\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  //onchangeSelect(\"role\",\"00\");\r\n");
      out.write("  //onchangeSelect(\"activeFlg\",\"00\");\r\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_bean_005fwrite_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f0 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(18,11) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f0.setName("context");
    // /jsp/common/header.jsp(18,11) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f0.setProperty("screenTitle");
    int _jspx_eval_bean_005fwrite_005f0 = _jspx_th_bean_005fwrite_005f0.doStartTag();
    if (_jspx_th_bean_005fwrite_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f1 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f1.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f0);
    // /jsp/common/hight_light.jsp(19,24) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f1.setName("errField");
    int _jspx_eval_bean_005fwrite_005f1 = _jspx_th_bean_005fwrite_005f1.doStartTag();
    if (_jspx_th_bean_005fwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
    return false;
  }

  private boolean _jspx_meth_logic_005fpresent_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:present
    org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_005fpresent_005f1 = (org.apache.struts.taglib.logic.PresentTag) _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.get(org.apache.struts.taglib.logic.PresentTag.class);
    _jspx_th_logic_005fpresent_005f1.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fpresent_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(46,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fpresent_005f1.setName("CommonContext");
    int _jspx_eval_logic_005fpresent_005f1 = _jspx_th_logic_005fpresent_005f1.doStartTag();
    if (_jspx_eval_logic_005fpresent_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                ");
        if (_jspx_meth_bean_005fwrite_005f2(_jspx_th_logic_005fpresent_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t            ");
        int evalDoAfterBody = _jspx_th_logic_005fpresent_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fpresent_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f1);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fpresent_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f2 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f2.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f1);
    // /jsp/common/header.jsp(47,17) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f2.setName("CommonContext");
    // /jsp/common/header.jsp(47,17) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f2.setProperty("systemOfficeName");
    int _jspx_eval_bean_005fwrite_005f2 = _jspx_th_bean_005fwrite_005f2.doStartTag();
    if (_jspx_th_bean_005fwrite_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f0 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(52,16) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f0.setSrc("./image/icon-user.png");
    int _jspx_eval_html_005fimg_005f0 = _jspx_th_html_005fimg_005f0.doStartTag();
    if (_jspx_th_html_005fimg_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.reuse(_jspx_th_html_005fimg_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.reuse(_jspx_th_html_005fimg_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f0 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(53,16) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f0.setStyle("color:white;");
    // /jsp/common/header.jsp(53,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f0.setHref("userprofile.do");
    // /jsp/common/header.jsp(53,16) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f0.setTitle("Thông tin tài khoản");
    int _jspx_eval_html_005flink_005f0 = _jspx_th_html_005flink_005f0.doStartTag();
    if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                    Chào ");
        if (_jspx_meth_bean_005fwrite_005f3(_jspx_th_html_005flink_005f0, _jspx_page_context))
          return true;
        out.write(' ');
        if (_jspx_meth_bean_005fwrite_005f4(_jspx_th_html_005flink_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref.reuse(_jspx_th_html_005flink_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftitle_005fstyle_005fhref.reuse(_jspx_th_html_005flink_005f0);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f3 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f3.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f0);
    // /jsp/common/header.jsp(54,25) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f3.setName("context");
    // /jsp/common/header.jsp(54,25) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f3.setProperty("userInfo.familyName");
    int _jspx_eval_bean_005fwrite_005f3 = _jspx_th_bean_005fwrite_005f3.doStartTag();
    if (_jspx_th_bean_005fwrite_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f3);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f4 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f4.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f0);
    // /jsp/common/header.jsp(54,85) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f4.setName("context");
    // /jsp/common/header.jsp(54,85) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f4.setProperty("userInfo.firstName");
    int _jspx_eval_bean_005fwrite_005f4 = _jspx_th_bean_005fwrite_005f4.doStartTag();
    if (_jspx_th_bean_005fwrite_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f4);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f5 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f5.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(56,23) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f5.setName("context");
    // /jsp/common/header.jsp(56,23) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f5.setProperty("userInfo.account");
    int _jspx_eval_bean_005fwrite_005f5 = _jspx_th_bean_005fwrite_005f5.doStartTag();
    if (_jspx_th_bean_005fwrite_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f5);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f1 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(58,16) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f1.setSrc("./image/icon-logout.png");
    int _jspx_eval_html_005fimg_005f1 = _jspx_th_html_005fimg_005f1.doStartTag();
    if (_jspx_th_html_005fimg_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.reuse(_jspx_th_html_005fimg_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005fnobody.reuse(_jspx_th_html_005fimg_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f1 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(59,16) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f1.setStyle("color:white;");
    // /jsp/common/header.jsp(59,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f1.setHref("logout.do");
    int _jspx_eval_html_005flink_005f1 = _jspx_th_html_005flink_005f1.doStartTag();
    if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f1.doInitBody();
      }
      do {
        out.write("Đăng xuất");
        int evalDoAfterBody = _jspx_th_html_005flink_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref.reuse(_jspx_th_html_005flink_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyle_005fhref.reuse(_jspx_th_html_005flink_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f2 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(66,16) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f2.setStyleId("home");
    // /jsp/common/header.jsp(66,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f2.setHref("home.do");
    // /jsp/common/header.jsp(66,16) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f2.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f2 = _jspx_th_html_005flink_005f2.doStartTag();
    if (_jspx_eval_html_005flink_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                    <em class=\"home-off\">&nbsp;</em>\r\n");
        out.write("                    <b>Trang chủ</b>\r\n");
        out.write("                    ");
        if (_jspx_meth_html_005fimg_005f2(_jspx_th_html_005flink_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f2 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f2);
    // /jsp/common/header.jsp(69,20) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f2.setAlt("|");
    // /jsp/common/header.jsp(69,20) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f2.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f2 = _jspx_th_html_005fimg_005f2.doStartTag();
    if (_jspx_th_html_005fimg_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f2);
    return false;
  }

  private boolean _jspx_meth_logic_005fequal_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:equal
    org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f0 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
    _jspx_th_logic_005fequal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fequal_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(73,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f0.setName("CommonContext");
    // /jsp/common/header.jsp(73,16) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f0.setProperty("synchronizeType");
    // /jsp/common/header.jsp(73,16) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f0.setValue("1");
    int _jspx_eval_logic_005fequal_005f0 = _jspx_th_logic_005fequal_005f0.doStartTag();
    if (_jspx_eval_logic_005fequal_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                  ");
        if (_jspx_meth_html_005flink_005f3(_jspx_th_logic_005fequal_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_logic_005fequal_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fequal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fequal_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f3 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f3.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f0);
    // /jsp/common/header.jsp(74,18) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f3.setStyleId("preventTab");
    // /jsp/common/header.jsp(74,18) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f3.setHref("preventlistview2.do");
    // /jsp/common/header.jsp(74,18) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f3.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f3 = _jspx_th_html_005flink_005f3.doStartTag();
    if (_jspx_eval_html_005flink_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                      <em style=\"width:17px;\" class=\"menu-block-contract-off\">&nbsp;</em>\r\n");
        out.write("                      <b>Tra cứu thông tin</b>\r\n");
        out.write("                      ");
        if (_jspx_meth_html_005fimg_005f3(_jspx_th_html_005flink_005f3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                  ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f3);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f3 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f3.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f3);
    // /jsp/common/header.jsp(77,22) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f3.setAlt("|");
    // /jsp/common/header.jsp(77,22) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f3.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f3 = _jspx_th_html_005fimg_005f3.doStartTag();
    if (_jspx_th_html_005fimg_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f3);
    return false;
  }

  private boolean _jspx_meth_logic_005fnotEqual_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEqual
    org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_005fnotEqual_005f0 = (org.apache.struts.taglib.logic.NotEqualTag) _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEqualTag.class);
    _jspx_th_logic_005fnotEqual_005f0.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fnotEqual_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(80,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fnotEqual_005f0.setName("CommonContext");
    // /jsp/common/header.jsp(80,16) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fnotEqual_005f0.setProperty("synchronizeType");
    // /jsp/common/header.jsp(80,16) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fnotEqual_005f0.setValue("1");
    int _jspx_eval_logic_005fnotEqual_005f0 = _jspx_th_logic_005fnotEqual_005f0.doStartTag();
    if (_jspx_eval_logic_005fnotEqual_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                  ");
        if (_jspx_meth_html_005flink_005f4(_jspx_th_logic_005fnotEqual_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t                <ul>\r\n");
        out.write("\t                    <li>");
        if (_jspx_meth_html_005flink_005f5(_jspx_th_logic_005fnotEqual_005f0, _jspx_page_context))
          return true;
        out.write("</li>\r\n");
        out.write("\t                    <li>");
        if (_jspx_meth_html_005flink_005f6(_jspx_th_logic_005fnotEqual_005f0, _jspx_page_context))
          return true;
        out.write("</li> \r\n");
        out.write("\t                </ul>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_logic_005fnotEqual_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fnotEqual_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fnotEqual_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fnotEqual_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEqual_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f4 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f4.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEqual_005f0);
    // /jsp/common/header.jsp(81,18) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f4.setStyleId("preventTab");
    // /jsp/common/header.jsp(81,18) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f4.setHref("preventlistview2.do");
    // /jsp/common/header.jsp(81,18) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f4.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f4 = _jspx_th_html_005flink_005f4.doStartTag();
    if (_jspx_eval_html_005flink_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f4.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                      <em style=\"width:17px;\" class=\"menu-block-contract-off\">&nbsp;</em>\r\n");
        out.write("                      <b>Tra cứu thông tin</b>\r\n");
        out.write("                      ");
        if (_jspx_meth_html_005fimg_005f4(_jspx_th_html_005flink_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                  ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f4);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f4 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f4.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f4);
    // /jsp/common/header.jsp(84,22) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f4.setAlt("|");
    // /jsp/common/header.jsp(84,22) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f4.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f4 = _jspx_th_html_005fimg_005f4.doStartTag();
    if (_jspx_th_html_005fimg_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f4);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEqual_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f5 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f5.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEqual_005f0);
    // /jsp/common/header.jsp(87,25) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f5.setHref("preventlistview2.do");
    int _jspx_eval_html_005flink_005f5 = _jspx_th_html_005flink_005f5.doStartTag();
    if (_jspx_eval_html_005flink_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f5.doInitBody();
      }
      do {
        out.write("Tra cứu tại Sở Tư Pháp");
        int evalDoAfterBody = _jspx_th_html_005flink_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f5);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEqual_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f6 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f6.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEqual_005f0);
    // /jsp/common/header.jsp(88,25) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f6.setHref("preventlistview.do");
    int _jspx_eval_html_005flink_005f6 = _jspx_th_html_005flink_005f6.doStartTag();
    if (_jspx_eval_html_005flink_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f6.doInitBody();
      }
      do {
        out.write("Tra cứu tại văn phòng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f6);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f7 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f7.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(93,16) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f7.setStyleId("contract");
    // /jsp/common/header.jsp(93,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f7.setHref("contractlistview.do");
    // /jsp/common/header.jsp(93,16) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f7.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f7 = _jspx_th_html_005flink_005f7.doStartTag();
    if (_jspx_eval_html_005flink_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f7.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                    <em style=\"width:17px;\" class=\"contract-off\">&nbsp;</em>\r\n");
        out.write("                    <b>Quản lý hợp đồng</b>\r\n");
        out.write("                    ");
        if (_jspx_meth_html_005fimg_005f5(_jspx_th_html_005flink_005f7, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f7);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f5 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f5.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f7);
    // /jsp/common/header.jsp(96,20) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f5.setAlt("|");
    // /jsp/common/header.jsp(96,20) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f5.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f5 = _jspx_th_html_005fimg_005f5.doStartTag();
    if (_jspx_th_html_005fimg_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f5);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f8 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f8.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(99,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f8.setHref("contractlistview.do");
    int _jspx_eval_html_005flink_005f8 = _jspx_th_html_005flink_005f8.doStartTag();
    if (_jspx_eval_html_005flink_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f8.doInitBody();
      }
      do {
        out.write("Danh sách hợp đồng công chứng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f8);
    return false;
  }

  private boolean _jspx_meth_logic_005fequal_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:equal
    org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f1 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
    _jspx_th_logic_005fequal_005f1.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fequal_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(102,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f1.setValue("true");
    // /jsp/common/header.jsp(102,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f1.setProperty("viewContractReport");
    // /jsp/common/header.jsp(102,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f1.setName("CommonContext");
    int _jspx_eval_logic_005fequal_005f1 = _jspx_th_logic_005fequal_005f1.doStartTag();
    if (_jspx_eval_logic_005fequal_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                    ");
        out.write("\r\n");
        out.write("\t                    <li>");
        if (_jspx_meth_html_005flink_005f9(_jspx_th_logic_005fequal_005f1, _jspx_page_context))
          return true;
        out.write("</li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_logic_005fequal_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fequal_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fequal_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f9 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f9.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f1);
    // /jsp/common/header.jsp(123,25) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f9.setHref("printnotarybookview.do");
    int _jspx_eval_html_005flink_005f9 = _jspx_th_html_005flink_005f9.doStartTag();
    if (_jspx_eval_html_005flink_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f9.doInitBody();
      }
      do {
        out.write("In sổ công chứng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f9);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f10 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f10.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(131,16) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f10.setStyleId("announcementTab");
    // /jsp/common/header.jsp(131,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f10.setHref("announcementlistview.do");
    // /jsp/common/header.jsp(131,16) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f10.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f10 = _jspx_th_html_005flink_005f10.doStartTag();
    if (_jspx_eval_html_005flink_005f10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f10.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                      <em style=\"width:17px;\" class=\"announcement-off\">&nbsp;</em>\r\n");
        out.write("                      <b>Thông báo</b>\r\n");
        out.write("                      ");
        if (_jspx_meth_html_005fimg_005f6(_jspx_th_html_005flink_005f10, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f10);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f10, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f6 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f6.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f10);
    // /jsp/common/header.jsp(134,22) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f6.setAlt("|");
    // /jsp/common/header.jsp(134,22) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f6.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f6 = _jspx_th_html_005fimg_005f6.doStartTag();
    if (_jspx_th_html_005fimg_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f6);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f11 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f11.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(144,16) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f11.setStyleId("system");
    // /jsp/common/header.jsp(144,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f11.setHref("userlistview.do");
    // /jsp/common/header.jsp(144,16) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f11.setStyleClass("jla");
    int _jspx_eval_html_005flink_005f11 = _jspx_th_html_005flink_005f11.doStartTag();
    if (_jspx_eval_html_005flink_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f11.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                  <em class=\"system-off\">&nbsp;</em>\r\n");
        out.write("                  <b>Quản trị hệ thống</b>\r\n");
        out.write("                  ");
        if (_jspx_meth_html_005fimg_005f7(_jspx_th_html_005flink_005f11, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleId_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f11);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f11, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f7 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f7.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f11);
    // /jsp/common/header.jsp(147,18) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f7.setAlt("|");
    // /jsp/common/header.jsp(147,18) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f7.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f7 = _jspx_th_html_005fimg_005f7.doStartTag();
    if (_jspx_th_html_005fimg_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f7);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f12 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f12.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(150,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f12.setHref("userlistview.do");
    int _jspx_eval_html_005flink_005f12 = _jspx_th_html_005flink_005f12.doStartTag();
    if (_jspx_eval_html_005flink_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f12.doInitBody();
      }
      do {
        out.write("Danh sách người sử dụng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f12);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f13 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f13.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(151,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f13.setHref("contractkindlistview.do");
    int _jspx_eval_html_005flink_005f13 = _jspx_th_html_005flink_005f13.doStartTag();
    if (_jspx_eval_html_005flink_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f13 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f13.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f13.doInitBody();
      }
      do {
        out.write("Danh sách nhóm hợp đồng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f13 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f13);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f14 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f14.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(152,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f14.setHref("contracttemplatelistview.do");
    int _jspx_eval_html_005flink_005f14 = _jspx_th_html_005flink_005f14.doStartTag();
    if (_jspx_eval_html_005flink_005f14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f14 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f14.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f14.doInitBody();
      }
      do {
        out.write("Danh sách tên hợp đồng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f14 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f14);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f15 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f15.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(153,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f15.setHref("banklistview.do");
    int _jspx_eval_html_005flink_005f15 = _jspx_th_html_005flink_005f15.doStartTag();
    if (_jspx_eval_html_005flink_005f15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f15 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f15.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f15.doInitBody();
      }
      do {
        out.write("Danh sách ngân hàng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f15 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f15);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f16 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f16.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(154,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f16.setHref("contractHistorylistview.do");
    int _jspx_eval_html_005flink_005f16 = _jspx_th_html_005flink_005f16.doStartTag();
    if (_jspx_eval_html_005flink_005f16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f16 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f16.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f16.doInitBody();
      }
      do {
        out.write("Lịch sử thay đổi hợp đồng");
        int evalDoAfterBody = _jspx_th_html_005flink_005f16.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f16 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f16);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f17 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f17.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(155,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f17.setHref("accesshistorylist.do");
    int _jspx_eval_html_005flink_005f17 = _jspx_th_html_005flink_005f17.doStartTag();
    if (_jspx_eval_html_005flink_005f17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f17 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f17.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f17.doInitBody();
      }
      do {
        out.write("Lịch sử truy cập hệ thống");
        int evalDoAfterBody = _jspx_th_html_005flink_005f17.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f17 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f17);
    return false;
  }

  private boolean _jspx_meth_logic_005fequal_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:equal
    org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_005fequal_005f2 = (org.apache.struts.taglib.logic.EqualTag) _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.EqualTag.class);
    _jspx_th_logic_005fequal_005f2.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fequal_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(156,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f2.setValue("true");
    // /jsp/common/header.jsp(156,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f2.setName("CommonContext");
    // /jsp/common/header.jsp(156,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fequal_005f2.setProperty("userInfo.hiddenFlg");
    int _jspx_eval_logic_005fequal_005f2 = _jspx_th_logic_005fequal_005f2.doStartTag();
    if (_jspx_eval_logic_005fequal_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        <li>");
        if (_jspx_meth_html_005flink_005f18(_jspx_th_logic_005fequal_005f2, _jspx_page_context))
          return true;
        out.write("</li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_logic_005fequal_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fequal_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fequal_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fequal_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fequal_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f18 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f18.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fequal_005f2);
    // /jsp/common/header.jsp(157,28) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f18.setHref("systemconfigview.do");
    int _jspx_eval_html_005flink_005f18 = _jspx_th_html_005flink_005f18.doStartTag();
    if (_jspx_eval_html_005flink_005f18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f18 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f18.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f18.doInitBody();
      }
      do {
        out.write("Cấu hình hệ thống");
        int evalDoAfterBody = _jspx_th_html_005flink_005f18.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f18 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f18);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f8 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f8.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(166,20) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f8.setAlt("|");
    // /jsp/common/header.jsp(166,20) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f8.setSrc("./image/menu_sperator.png");
    int _jspx_eval_html_005fimg_005f8 = _jspx_th_html_005fimg_005f8.doStartTag();
    if (_jspx_th_html_005fimg_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f8);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f19 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f19.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(174,10) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f19.setStyleClass("acc_link");
    // /jsp/common/header.jsp(174,10) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f19.setHref("/uchi_help/");
    // /jsp/common/header.jsp(174,10) name = target type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f19.setTarget("_blank");
    int _jspx_eval_html_005flink_005f19 = _jspx_th_html_005flink_005f19.doStartTag();
    if (_jspx_eval_html_005flink_005f19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f19 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f19.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f19.doInitBody();
      }
      do {
        out.write("<img style=\"margin-bottom: -4px;\" src=\"./image/help.png\"> Trợ giúp");
        int evalDoAfterBody = _jspx_th_html_005flink_005f19.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f19 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005ftarget_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f19);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f20 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f20.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(175,10) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f20.setStyleClass("acc_link");
    // /jsp/common/header.jsp(175,10) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f20.setHref("contact.do");
    int _jspx_eval_html_005flink_005f20 = _jspx_th_html_005flink_005f20.doStartTag();
    if (_jspx_eval_html_005flink_005f20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f20 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f20.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f20.doInitBody();
      }
      do {
        out.write("<img style=\"margin-bottom: -4px;\" src=\"./image/contact.png\"> Liên hệ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f20.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f20 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f20);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f21 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f21.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/header.jsp(176,10) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f21.setStyleClass("acc_link");
    // /jsp/common/header.jsp(176,10) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f21.setHref("userprofile.do");
    int _jspx_eval_html_005flink_005f21 = _jspx_th_html_005flink_005f21.doStartTag();
    if (_jspx_eval_html_005flink_005f21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f21 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f21.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f21.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("            <img width=\"12.5px\" src=\"./image/profile.png\" style=\"margin-bottom: -2px;\"> Tài khoản\r\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f21.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f21 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fstyleClass_005fhref.reuse(_jspx_th_html_005flink_005f21);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f9 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f9.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/admin/ADM019.jsp(13,17) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f9.setAlt("*");
    // /jsp/admin/ADM019.jsp(13,17) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f9.setSrc("./image/bullet_square.gif");
    int _jspx_eval_html_005fimg_005f9 = _jspx_th_html_005fimg_005f9.doStartTag();
    if (_jspx_th_html_005fimg_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f9);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f22(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f22 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f22.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/admin/ADM019.jsp(16,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f22.setHref("userlistview.do");
    int _jspx_eval_html_005flink_005f22 = _jspx_th_html_005flink_005f22.doStartTag();
    if (_jspx_eval_html_005flink_005f22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f22 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f22.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f22.doInitBody();
      }
      do {
        out.write("Quản trị hệ thống");
        int evalDoAfterBody = _jspx_th_html_005flink_005f22.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f22 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f22);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f22);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f23(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f23 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f23.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/admin/ADM019.jsp(20,16) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f23.setHref("#");
    int _jspx_eval_html_005flink_005f23 = _jspx_th_html_005flink_005f23.doStartTag();
    if (_jspx_eval_html_005flink_005f23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f23 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f23.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f23.doInitBody();
      }
      do {
        out.write("Lịch sử thay đổi hợp đồng, giao dịch");
        int evalDoAfterBody = _jspx_th_html_005flink_005f23.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f23 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f23);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f23);
    return false;
  }

  private boolean _jspx_meth_logic_005fpresent_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:present
    org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_005fpresent_005f2 = (org.apache.struts.taglib.logic.PresentTag) _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.get(org.apache.struts.taglib.logic.PresentTag.class);
    _jspx_th_logic_005fpresent_005f2.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fpresent_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/error_message.jsp(5,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fpresent_005f2.setName("org.apache.struts.action.ERROR");
    int _jspx_eval_logic_005fpresent_005f2 = _jspx_th_logic_005fpresent_005f2.doStartTag();
    if (_jspx_eval_logic_005fpresent_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    <div class=\"err_box\" id=\"err_box\">\r\n");
        out.write("        ");
        if (_jspx_meth_html_005ferrors_005f0(_jspx_th_logic_005fpresent_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    </div>\r\n");
        int evalDoAfterBody = _jspx_th_logic_005fpresent_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fpresent_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005ferrors_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fpresent_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:errors
    org.apache.struts.taglib.html.ErrorsTag _jspx_th_html_005ferrors_005f0 = (org.apache.struts.taglib.html.ErrorsTag) _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody.get(org.apache.struts.taglib.html.ErrorsTag.class);
    _jspx_th_html_005ferrors_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005ferrors_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f2);
    int _jspx_eval_html_005ferrors_005f0 = _jspx_th_html_005ferrors_005f0.doStartTag();
    if (_jspx_th_html_005ferrors_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody.reuse(_jspx_th_html_005ferrors_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fnobody.reuse(_jspx_th_html_005ferrors_005f0);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fmessages_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f6 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f6.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fmessages_005f0);
    // /jsp/common/error_message.jsp(14,12) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f6.setName("message");
    // /jsp/common/error_message.jsp(14,12) name = filter type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f6.setFilter(false);
    int _jspx_eval_bean_005fwrite_005f6 = _jspx_th_bean_005fwrite_005f6.doStartTag();
    if (_jspx_th_bean_005fwrite_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f6);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f0 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    // /jsp/admin/ADM019.jsp(32,20) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setStyleId("firstControl");
    // /jsp/admin/ADM019.jsp(32,20) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setProperty("contractNumber");
    // /jsp/admin/ADM019.jsp(32,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(32,20) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setMaxlength("20");
    int _jspx_eval_html_005ftext_005f0 = _jspx_th_html_005ftext_005f0.doStartTag();
    if (_jspx_th_html_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fproperty_005fname_005fmaxlength_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f1 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    // /jsp/admin/ADM019.jsp(36,17) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setProperty("contractContent");
    // /jsp/admin/ADM019.jsp(36,17) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(36,17) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setStyle("width:200px");
    int _jspx_eval_html_005ftext_005f1 = _jspx_th_html_005ftext_005f1.doStartTag();
    if (_jspx_th_html_005ftext_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody.reuse(_jspx_th_html_005ftext_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyle_005fproperty_005fname_005fnobody.reuse(_jspx_th_html_005ftext_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005fimage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:image
    org.apache.struts.taglib.html.ImageTag _jspx_th_html_005fimage_005f0 = (org.apache.struts.taglib.html.ImageTag) _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImageTag.class);
    _jspx_th_html_005fimage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    // /jsp/admin/ADM019.jsp(39,19) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimage_005f0.setAlt("Tìm kiếm");
    // /jsp/admin/ADM019.jsp(39,19) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimage_005f0.setSrc("./image/btn_search.png");
    int _jspx_eval_html_005fimage_005f0 = _jspx_th_html_005fimage_005f0.doStartTag();
    if (_jspx_th_html_005fimage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimage_0026_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimage_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f24(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f24 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f24.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    // /jsp/admin/ADM019.jsp(72,28) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f24.setAction("/contractHistoryListselect.do");
    // /jsp/admin/ADM019.jsp(72,28) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f24.setName("paramsName");
    int _jspx_eval_html_005flink_005f24 = _jspx_th_html_005flink_005f24.doStartTag();
    if (_jspx_eval_html_005flink_005f24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f24 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f24.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f24.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_bean_005fwrite_005f7(_jspx_th_html_005flink_005f24, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f24.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f24 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction.reuse(_jspx_th_html_005flink_005f24);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fname_005faction.reuse(_jspx_th_html_005flink_005f24);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005flink_005f24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f7 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f7.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005flink_005f24);
    // /jsp/admin/ADM019.jsp(73,32) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f7.setName("contract");
    // /jsp/admin/ADM019.jsp(73,32) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f7.setProperty("contractNumber");
    int _jspx_eval_bean_005fwrite_005f7 = _jspx_th_bean_005fwrite_005f7.doStartTag();
    if (_jspx_th_bean_005fwrite_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f7);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f8 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f8.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    // /jsp/admin/ADM019.jsp(77,28) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f8.setName("contract");
    // /jsp/admin/ADM019.jsp(77,28) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f8.setProperty("contractContentDisp");
    // /jsp/admin/ADM019.jsp(77,28) name = filter type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f8.setFilter(false);
    int _jspx_eval_bean_005fwrite_005f8 = _jspx_th_bean_005fwrite_005f8.doStartTag();
    if (_jspx_th_bean_005fwrite_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f8);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f9 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f9.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    // /jsp/admin/ADM019.jsp(79,28) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f9.setName("contract");
    // /jsp/admin/ADM019.jsp(79,28) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f9.setProperty("executeContent");
    int _jspx_eval_bean_005fwrite_005f9 = _jspx_th_bean_005fwrite_005f9.doStartTag();
    if (_jspx_th_bean_005fwrite_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f9);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f10 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f10.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    // /jsp/admin/ADM019.jsp(80,28) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f10.setName("contract");
    // /jsp/admin/ADM019.jsp(80,28) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f10.setProperty("executePerson");
    int _jspx_eval_bean_005fwrite_005f10 = _jspx_th_bean_005fwrite_005f10.doStartTag();
    if (_jspx_th_bean_005fwrite_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f10);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f11 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f11.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f1);
    // /jsp/admin/ADM019.jsp(81,28) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f11.setName("contract");
    // /jsp/admin/ADM019.jsp(81,28) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f11.setProperty("executeDateTime");
    // /jsp/admin/ADM019.jsp(81,28) name = format type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f11.setFormat("dd/MM/yyyy hh:mm:ss");
    int _jspx_eval_bean_005fwrite_005f11 = _jspx_th_bean_005fwrite_005f11.doStartTag();
    if (_jspx_th_bean_005fwrite_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.reuse(_jspx_th_bean_005fwrite_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.reuse(_jspx_th_bean_005fwrite_005f11);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f12 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f12.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(90,29) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f12.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(90,29) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f12.setProperty("totalCount");
    int _jspx_eval_bean_005fwrite_005f12 = _jspx_th_bean_005fwrite_005f12.doStartTag();
    if (_jspx_th_bean_005fwrite_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f12);
    return false;
  }

  private boolean _jspx_meth_logic_005fgreaterThan_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:greaterThan
    org.apache.struts.taglib.logic.GreaterThanTag _jspx_th_logic_005fgreaterThan_005f0 = (org.apache.struts.taglib.logic.GreaterThanTag) _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.GreaterThanTag.class);
    _jspx_th_logic_005fgreaterThan_005f0.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fgreaterThan_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(94,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(94,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setValue("1");
    // /jsp/admin/ADM019.jsp(94,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setProperty("totalPage");
    int _jspx_eval_logic_005fgreaterThan_005f0 = _jspx_th_logic_005fgreaterThan_005f0.doStartTag();
    if (_jspx_eval_logic_005fgreaterThan_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                             ");
        if (_jspx_meth_html_005flink_005f25(_jspx_th_logic_005fgreaterThan_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        if (_jspx_meth_html_005flink_005f26(_jspx_th_logic_005fgreaterThan_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_logic_005fgreaterThan_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fgreaterThan_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f25(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f25 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f25.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f0);
    // /jsp/admin/ADM019.jsp(95,29) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f25.setHref("javascript:direction('first')");
    int _jspx_eval_html_005flink_005f25 = _jspx_th_html_005flink_005f25.doStartTag();
    if (_jspx_eval_html_005flink_005f25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f25 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f25.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f25.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                    <img id=\"imgfirst\" class=\"pager-first\" src=\"./image/first.png\" alt= \"first\"/>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f25.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f25 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f25);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f25);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f26(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f26 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f26.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f0);
    // /jsp/admin/ADM019.jsp(98,28) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f26.setHref("javascript:direction('ahead')");
    int _jspx_eval_html_005flink_005f26 = _jspx_th_html_005flink_005f26.doStartTag();
    if (_jspx_eval_html_005flink_005f26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f26 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f26.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f26.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                    <img id=\"imgprev\" class=\"pager-first\" src=\"./image/prev.png\" alt= \"prev\"/>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f26.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f26 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f26);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f26);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f13 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f13.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(104,24) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f13.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(104,24) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f13.setProperty("page");
    int _jspx_eval_bean_005fwrite_005f13 = _jspx_th_bean_005fwrite_005f13.doStartTag();
    if (_jspx_th_bean_005fwrite_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f13);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f14 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f14.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(106,24) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f14.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(106,24) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f14.setProperty("totalPage");
    int _jspx_eval_bean_005fwrite_005f14 = _jspx_th_bean_005fwrite_005f14.doStartTag();
    if (_jspx_th_bean_005fwrite_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f14);
    return false;
  }

  private boolean _jspx_meth_logic_005fgreaterThan_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:greaterThan
    org.apache.struts.taglib.logic.GreaterThanTag _jspx_th_logic_005fgreaterThan_005f1 = (org.apache.struts.taglib.logic.GreaterThanTag) _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.GreaterThanTag.class);
    _jspx_th_logic_005fgreaterThan_005f1.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fgreaterThan_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(109,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setName("contractHistoryListViewHelper");
    // /jsp/admin/ADM019.jsp(109,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setValue("1");
    // /jsp/admin/ADM019.jsp(109,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setProperty("totalPage");
    int _jspx_eval_logic_005fgreaterThan_005f1 = _jspx_th_logic_005fgreaterThan_005f1.doStartTag();
    if (_jspx_eval_logic_005fgreaterThan_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        ");
        if (_jspx_meth_html_005flink_005f27(_jspx_th_logic_005fgreaterThan_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        ");
        if (_jspx_meth_html_005flink_005f28(_jspx_th_logic_005fgreaterThan_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_logic_005fgreaterThan_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fgreaterThan_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f27(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f27 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f27.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f1);
    // /jsp/admin/ADM019.jsp(110,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f27.setHref("javascript:direction('next')");
    int _jspx_eval_html_005flink_005f27 = _jspx_th_html_005flink_005f27.doStartTag();
    if (_jspx_eval_html_005flink_005f27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f27 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f27.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f27.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                <img id=\"imgnext\" class=\"pager-first\" src=\"./image/next.png\" alt= \"next\"/>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f27.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f27 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f27);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f27);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f28(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f28 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f28.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f1);
    // /jsp/admin/ADM019.jsp(113,24) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f28.setHref("javascript:direction('end')");
    int _jspx_eval_html_005flink_005f28 = _jspx_th_html_005flink_005f28.doStartTag();
    if (_jspx_eval_html_005flink_005f28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f28 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f28.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f28.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                                <img id=\"imglast\" class=\"pager-first\" src=\"./image/last.png\" alt= \"last\"/>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f28.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f28 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f28);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f28);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f0 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/admin/ADM019.jsp(118,16) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f0.setProperty("direction");
    int _jspx_eval_html_005fhidden_005f0 = _jspx_th_html_005fhidden_005f0.doStartTag();
    if (_jspx_th_html_005fhidden_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
    return false;
  }

  private boolean _jspx_meth_logic_005fpresent_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:present
    org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_005fpresent_005f4 = (org.apache.struts.taglib.logic.PresentTag) _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.get(org.apache.struts.taglib.logic.PresentTag.class);
    _jspx_th_logic_005fpresent_005f4.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fpresent_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    // /jsp/common/footer.jsp(12,9) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fpresent_005f4.setName("CommonContext");
    int _jspx_eval_logic_005fpresent_005f4 = _jspx_th_logic_005fpresent_005f4.doStartTag();
    if (_jspx_eval_logic_005fpresent_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t            ");
        if (_jspx_meth_bean_005fwrite_005f15(_jspx_th_logic_005fpresent_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                - Địa chỉ: ");
        if (_jspx_meth_bean_005fwrite_005f16(_jspx_th_logic_005fpresent_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_logic_005fpresent_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fpresent_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fpresent_0026_005fname.reuse(_jspx_th_logic_005fpresent_005f4);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fpresent_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f15 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f15.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f4);
    // /jsp/common/footer.jsp(13,13) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f15.setName("CommonContext");
    // /jsp/common/footer.jsp(13,13) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f15.setProperty("systemOfficeName");
    int _jspx_eval_bean_005fwrite_005f15 = _jspx_th_bean_005fwrite_005f15.doStartTag();
    if (_jspx_th_bean_005fwrite_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f15);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fpresent_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f16 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f16.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fpresent_005f4);
    // /jsp/common/footer.jsp(14,27) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f16.setName("CommonContext");
    // /jsp/common/footer.jsp(14,27) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f16.setProperty("systemOfficeAddress");
    int _jspx_eval_bean_005fwrite_005f16 = _jspx_th_bean_005fwrite_005f16.doStartTag();
    if (_jspx_th_bean_005fwrite_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f16);
    return false;
  }
}
