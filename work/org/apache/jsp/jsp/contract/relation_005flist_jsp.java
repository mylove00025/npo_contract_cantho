package org.apache.jsp.jsp.contract;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relation_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhtml;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fhtml = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fhtml.release();
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle.release();
    _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.release();
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.release();
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      //  html:html
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml.get(org.apache.struts.taglib.html.HtmlTag.class);
      _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
      _jspx_th_html_005fhtml_005f0.setParent(null);
      int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
      if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    \r\n");
          out.write("    \r\n");
          out.write("    ");
          //  html:form
          org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle.get(org.apache.struts.taglib.html.FormTag.class);
          _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
          _jspx_th_html_005fform_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
          // /jsp/contract/relation_list.jsp(10,4) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_html_005fform_005f0.setStyle("position: absolute; left:685px;top:310px;");
          // /jsp/contract/relation_list.jsp(10,4) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_html_005fform_005f0.setStyleId("form");
          // /jsp/contract/relation_list.jsp(10,4) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_html_005fform_005f0.setStyle("background-color: white;");
          int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
          if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("       \r\n");
              out.write("        ");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_005fnotEmpty_005f0 = (org.apache.struts.taglib.logic.NotEmptyTag) _005fjspx_005ftagPool_005flogic_005fnotEmpty_0026_005fproperty_005fname.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_005fnotEmpty_005f0.setPageContext(_jspx_page_context);
              _jspx_th_logic_005fnotEmpty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
              // /jsp/contract/relation_list.jsp(12,8) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fnotEmpty_005f0.setName("customerListViewHelper");
              // /jsp/contract/relation_list.jsp(12,8) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_logic_005fnotEmpty_005f0.setProperty("customerList");
              int _jspx_eval_logic_005fnotEmpty_005f0 = _jspx_th_logic_005fnotEmpty_005f0.doStartTag();
              if (_jspx_eval_logic_005fnotEmpty_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("            <table id=\"customerList\" class=\"tbl-list\" style=\"-moz-box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5); background-color: #FFFFFF; border: 1px solid #999999; border-top: none; display: block; left: 751px; top: -1px; visibility: visible;text-align: center;\" >\r\n");
                  out.write("            ");
                  if (_jspx_meth_html_005fimg_005f0(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("              ");
                  if (_jspx_meth_html_005fimg_005f1(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("              \r\n");
                  out.write("                ");
                  //  logic:iterate
                  org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_005fiterate_005f0 = (org.apache.struts.taglib.logic.IterateTag) _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.get(org.apache.struts.taglib.logic.IterateTag.class);
                  _jspx_th_logic_005fiterate_005f0.setPageContext(_jspx_page_context);
                  _jspx_th_logic_005fiterate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
                  // /jsp/contract/relation_list.jsp(17,16) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f0.setId("selectObject");
                  // /jsp/contract/relation_list.jsp(17,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f0.setName("customerListViewHelper");
                  // /jsp/contract/relation_list.jsp(17,16) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f0.setProperty("customerList");
                  // /jsp/contract/relation_list.jsp(17,16) name = indexId type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
                  _jspx_th_logic_005fiterate_005f0.setIndexId("i");
                  int _jspx_eval_logic_005fiterate_005f0 = _jspx_th_logic_005fiterate_005f0.doStartTag();
                  if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object selectObject = null;
                    java.lang.Integer i = null;
                    if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_logic_005fiterate_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_logic_005fiterate_005f0.doInitBody();
                    }
                    selectObject = (java.lang.Object) _jspx_page_context.findAttribute("selectObject");
                    i = (java.lang.Integer) _jspx_page_context.findAttribute("i");
                    do {
                      out.write("\r\n");
                      out.write("                    <tr onmouseover=\"style.backgroundColor='#D6D5D9';\" onmouseout=\"style.backgroundColor='#FFFFFF'\" class=\"tbl-row");
                      out.print(i % 2);
                      out.write(">\" style=\"width: 100%;  border-bottom: none; border-top:none\">                       \r\n");
                      out.write("                        <td  class=\"onmouseover\" onmouseover=\"\" style=\"cursor: pointer;text-align: left;border-top: 1px solid #999999; border-right: none; border-left: none; min-width: 50px \">\r\n");
                      out.write("                       \t\t<span  id=\"selectObject");
                      out.print(i );
                      out.write("\"  onclick=\"getRelation(");
                      out.print(i );
                      out.write(");\">");
                      if (_jspx_meth_bean_005fwrite_005f0(_jspx_th_logic_005fiterate_005f0, _jspx_page_context))
                        return;
                      out.write("</span>\r\n");
                      out.write("                       \t\t<textarea id=\"customerinfo");
                      out.print(i );
                      out.write("\" style=\"display: none; \">");
                      if (_jspx_meth_bean_005fwrite_005f1(_jspx_th_logic_005fiterate_005f0, _jspx_page_context))
                        return;
                      out.write("</textarea>\r\n");
                      out.write("                        </td>\r\n");
                      out.write("                       <td style=\"text-align: right;border-top: 1px solid #999999; font-size: 7pt; color: #B45133; border-right: none; border-left: none; \">");
                      if (_jspx_meth_bean_005fwrite_005f2(_jspx_th_logic_005fiterate_005f0, _jspx_page_context))
                        return;
                      out.write("</td>\r\n");
                      out.write("                    </tr>  \r\n");
                      out.write("                   \r\n");
                      out.write("                ");
                      int evalDoAfterBody = _jspx_th_logic_005fiterate_005f0.doAfterBody();
                      selectObject = (java.lang.Object) _jspx_page_context.findAttribute("selectObject");
                      i = (java.lang.Integer) _jspx_page_context.findAttribute("i");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_logic_005fiterate_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.popBody();
                    }
                  }
                  if (_jspx_th_logic_005fiterate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
                    return;
                  }
                  _005fjspx_005ftagPool_005flogic_005fiterate_0026_005fproperty_005fname_005findexId_005fid.reuse(_jspx_th_logic_005fiterate_005f0);
                  out.write("\r\n");
                  out.write("        \r\n");
                  out.write("            ");
                  if (_jspx_meth_logic_005fgreaterThan_005f0(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("            ");
                  if (_jspx_meth_html_005fhidden_005f0(_jspx_th_logic_005fnotEmpty_005f0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("       \r\n");
                  out.write("           </table>\r\n");
                  out.write("           \r\n");
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
            _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle.reuse(_jspx_th_html_005fform_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fstyle_005fstyle.reuse(_jspx_th_html_005fform_005f0);
          out.write("\r\n");
          out.write("  \r\n");
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("highlightWhenSearch();\r\n");
      out.write("var check;\r\n");
      out.write("var check2=\"\";\r\n");
      out.write("check2=navigator.appName;\r\n");
      out.write("check3=navigator.appVersion;\r\n");
      out.write("if (check2==\"Netscape\") {\r\n");
      out.write("\tif (check3==\"5.0 (Windows; vi)\") {\r\n");
      out.write("\t check=1;\r\n");
      out.write("\t} else check=3;\r\n");
      out.write("} else {\r\n");
      out.write("\t check=2;\r\n");
      out.write("}\r\n");
      out.write("if (check==1) {\r\n");
      out.write("\tif (relationObject==1){\r\n");
      out.write("\t document.getElementById('relationobjectlist1').querySelector(\"#sharp1\").style.display=\"\";\r\n");
      out.write("\t document.getElementById('relationobjectlist1').querySelector(\"#sharp2\").style.display=\"none\";\r\n");
      out.write("\t} else if (relationObject==2){\r\n");
      out.write("\t\tdocument.getElementById('relationobjectlist2').querySelector(\"#sharp1\").style.display=\"\";\r\n");
      out.write("\t\tdocument.getElementById('relationobjectlist2').querySelector(\"#sharp2\").style.display=\"none\";\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp1\").style.display=\"\";\r\n");
      out.write("\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp2\").style.display=\"none\";\r\n");
      out.write("\t}\r\n");
      out.write("} else if (check==2) {\r\n");
      out.write("\tif (relationObject==1){\r\n");
      out.write("\t\t document.getElementById('relationobjectlist1').querySelector(\"#sharp2\").style.display=\"\";\r\n");
      out.write("\t\t document.getElementById('relationobjectlist1').querySelector(\"#sharp1\").style.display=\"none\";\r\n");
      out.write("\t\t} else if (relationObject==2){\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist2').querySelector(\"#sharp2\").style.display=\"\";\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist2').querySelector(\"#sharp1\").style.display=\"none\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp2\").style.display=\"\";\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp1\").style.display=\"none\";\r\n");
      out.write("\t\t}\r\n");
      out.write("} else {\r\n");
      out.write("\tif (relationObject==1){\r\n");
      out.write("\t\t document.getElementById('relationobjectlist1').querySelector(\"#sharp1\").style.display=\"none\";\r\n");
      out.write("\t\t document.getElementById('relationobjectlist1').querySelector(\"#sharp2\").style.display=\"\";\r\n");
      out.write("\t\t} else if (relationObject==2){\r\n");
      out.write("\t\t\t$('#relationobjectlist2 #sharp1').hide();\r\n");
      out.write("\t\t\t$('#relationobjectlist2 #sharp2').show();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp1\").style.display=\"none\";\r\n");
      out.write("\t\t\tdocument.getElementById('relationobjectlist3').querySelector(\"#sharp2\").style.display=\"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("function highlightWhenSearch() {\r\n");
      out.write("    \r\n");
      out.write("    //var searchString = getSearchString();\r\n");
      out.write("    if (relationObject==1) {\r\n");
      out.write("    var searchString = $('#keyHighLight1').val();\r\n");
      out.write("    var textContainerNode = document.getElementById(\"relationobjectlist1\");\r\n");
      out.write("    } else if (relationObject==2){\r\n");
      out.write("    \tvar searchString = $('#keyHighLight2').val();\r\n");
      out.write("    \tvar textContainerNode = document.getElementById(\"relationobjectlist2\");\r\n");
      out.write("    } else {\r\n");
      out.write("    \tvar searchString = $('#keyHighLight3').val();\r\n");
      out.write("    var textContainerNode = document.getElementById(\"relationobjectlist3\");\r\n");
      out.write("    } \r\n");
      out.write("    if (searchString != \"\") {\r\n");
      out.write("        // Starting node, parent to all nodes you want to search\r\n");
      out.write("//        var textContainerNode = document.getElementById(\"customerListContent\");\r\n");
      out.write("        \r\n");
      out.write("        if (textContainerNode != null) {\r\n");
      out.write("            // Split search terms on '|' and iterate over resulting array              \r\n");
      out.write("            var searchTerms = searchString.split('|');\r\n");
      out.write("            for (var i in searchTerms)  {\r\n");
      out.write("            \tsearchTerms[i]=escape(searchTerms[i]);\r\n");
      out.write("              // The regex is the secret, it prevents text within tag declarations to be affected\r\n");
      out.write("              var regex = new RegExp(\">([^<]*)?(\"+searchTerms[i]+\")([^>]*)?<\",\"ig\");\r\n");
      out.write("              //var regex = searchTerms[i];\r\n");
      out.write("             \r\n");
      out.write("              var tempinnerHTML = textContainerNode.innerHTML;\r\n");
      out.write("              // Do regex replace\r\n");
      out.write("              // Inject span with class of 'highlighted termX' for google style highlighting\r\n");
      out.write("              if (relationObject==1){\r\n");
      out.write("              $('#relationobjectlist1').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<'));\r\n");
      out.write("              } else if (relationObject==2) {\r\n");
      out.write("            \t  $('#relationobjectlist2').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<')); \r\n");
      out.write("              } else $('#relationobjectlist3').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<'));\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
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

  private boolean _jspx_meth_html_005fimg_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f0 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/contract/relation_list.jsp(14,12) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f0.setStyleId("sharp1");
    // /jsp/contract/relation_list.jsp(14,12) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f0.setStyle(" position: absolute; left:671px; margin-top: 5px");
    // /jsp/contract/relation_list.jsp(14,12) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f0.setAlt("*");
    // /jsp/contract/relation_list.jsp(14,12) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f0.setSrc("./image/icon_sharp2.png");
    int _jspx_eval_html_005fimg_005f0 = _jspx_th_html_005fimg_005f0.doStartTag();
    if (_jspx_th_html_005fimg_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fimg_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fnotEmpty_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:img
    org.apache.struts.taglib.html.ImgTag _jspx_th_html_005fimg_005f1 = (org.apache.struts.taglib.html.ImgTag) _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.get(org.apache.struts.taglib.html.ImgTag.class);
    _jspx_th_html_005fimg_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fimg_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fnotEmpty_005f0);
    // /jsp/contract/relation_list.jsp(15,14) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f1.setStyleId("sharp2");
    // /jsp/contract/relation_list.jsp(15,14) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f1.setStyle(" position: absolute; left:-16px; margin-top: 5px");
    // /jsp/contract/relation_list.jsp(15,14) name = alt type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f1.setAlt("*");
    // /jsp/contract/relation_list.jsp(15,14) name = src type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fimg_005f1.setSrc("./image/icon_sharp2.png");
    int _jspx_eval_html_005fimg_005f1 = _jspx_th_html_005fimg_005f1.doStartTag();
    if (_jspx_th_html_005fimg_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fimg_0026_005fstyleId_005fstyle_005fsrc_005falt_005fnobody.reuse(_jspx_th_html_005fimg_005f1);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f0 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f0);
    // /jsp/contract/relation_list.jsp(20,90) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f0.setName("selectObject");
    // /jsp/contract/relation_list.jsp(20,90) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f0.setProperty("customerInfoDisp");
    // /jsp/contract/relation_list.jsp(20,90) name = filter type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f0.setFilter(false);
    int _jspx_eval_bean_005fwrite_005f0 = _jspx_th_bean_005fwrite_005f0.doStartTag();
    if (_jspx_th_bean_005fwrite_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005ffilter_005fnobody.reuse(_jspx_th_bean_005fwrite_005f0);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f1 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f1.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f0);
    // /jsp/contract/relation_list.jsp(21,84) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f1.setName("selectObject");
    // /jsp/contract/relation_list.jsp(21,84) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f1.setProperty("customerInfo");
    int _jspx_eval_bean_005fwrite_005f1 = _jspx_th_bean_005fwrite_005f1.doStartTag();
    if (_jspx_th_bean_005fwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fnobody.reuse(_jspx_th_bean_005fwrite_005f1);
    return false;
  }

  private boolean _jspx_meth_bean_005fwrite_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fiterate_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_005fwrite_005f2 = (org.apache.struts.taglib.bean.WriteTag) _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_005fwrite_005f2.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fwrite_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fiterate_005f0);
    // /jsp/contract/relation_list.jsp(23,156) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f2.setName("selectObject");
    // /jsp/contract/relation_list.jsp(23,156) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f2.setProperty("frequency");
    // /jsp/contract/relation_list.jsp(23,156) name = format type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fwrite_005f2.setFormat("#,###,###");
    int _jspx_eval_bean_005fwrite_005f2 = _jspx_th_bean_005fwrite_005f2.doStartTag();
    if (_jspx_th_bean_005fwrite_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fwrite_0026_005fproperty_005fname_005fformat_005fnobody.reuse(_jspx_th_bean_005fwrite_005f2);
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
    // /jsp/contract/relation_list.jsp(28,12) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setName("customerListViewHelper");
    // /jsp/contract/relation_list.jsp(28,12) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setProperty("totalPage");
    // /jsp/contract/relation_list.jsp(28,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f0.setValue("1");
    int _jspx_eval_logic_005fgreaterThan_005f0 = _jspx_th_logic_005fgreaterThan_005f0.doStartTag();
    if (_jspx_eval_logic_005fgreaterThan_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <tr>\r\n");
        out.write("                    <td style=\"border:none\">\r\n");
        out.write("            <div class=\"pager\" style=\"border:none; background-color: white; width: 48px; height: 10px;text-align: center;margin: 0 auto;\">\r\n");
        out.write("        \r\n");
        out.write("                <div style=\"margin:0 auto;\">\r\n");
        out.write("                    ");
        if (_jspx_meth_logic_005fgreaterThan_005f1(_jspx_th_logic_005fgreaterThan_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    \r\n");
        out.write("                    ");
        if (_jspx_meth_logic_005fgreaterThan_005f2(_jspx_th_logic_005fgreaterThan_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                </div>\r\n");
        out.write("            </div>\r\n");
        out.write("                </td>\r\n");
        out.write("                <td style=\"border: none;\"></td>\r\n");
        out.write("            </tr>\r\n");
        out.write("            ");
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

  private boolean _jspx_meth_logic_005fgreaterThan_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:greaterThan
    org.apache.struts.taglib.logic.GreaterThanTag _jspx_th_logic_005fgreaterThan_005f1 = (org.apache.struts.taglib.logic.GreaterThanTag) _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.GreaterThanTag.class);
    _jspx_th_logic_005fgreaterThan_005f1.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fgreaterThan_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f0);
    // /jsp/contract/relation_list.jsp(34,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setName("customerListViewHelper");
    // /jsp/contract/relation_list.jsp(34,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setProperty("totalPage");
    // /jsp/contract/relation_list.jsp(34,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f1.setValue("1");
    int _jspx_eval_logic_005fgreaterThan_005f1 = _jspx_th_logic_005fgreaterThan_005f1.doStartTag();
    if (_jspx_eval_logic_005fgreaterThan_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                  \r\n");
        out.write("\t                    ");
        if (_jspx_meth_html_005flink_005f0(_jspx_th_logic_005fgreaterThan_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    <span>|</span>\r\n");
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

  private boolean _jspx_meth_html_005flink_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f0 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f1);
    // /jsp/contract/relation_list.jsp(36,21) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f0.setHref("javascript:direction('ahead')");
    int _jspx_eval_html_005flink_005f0 = _jspx_th_html_005flink_005f0.doStartTag();
    if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t                        <img style= \"padding: 0 1px 0 5px\" class=\"pager-prev\" src=\"./image/prev.png\" alt= \"prev\"/>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f0);
    return false;
  }

  private boolean _jspx_meth_logic_005fgreaterThan_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:greaterThan
    org.apache.struts.taglib.logic.GreaterThanTag _jspx_th_logic_005fgreaterThan_005f2 = (org.apache.struts.taglib.logic.GreaterThanTag) _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.get(org.apache.struts.taglib.logic.GreaterThanTag.class);
    _jspx_th_logic_005fgreaterThan_005f2.setPageContext(_jspx_page_context);
    _jspx_th_logic_005fgreaterThan_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f0);
    // /jsp/contract/relation_list.jsp(42,20) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f2.setName("customerListViewHelper");
    // /jsp/contract/relation_list.jsp(42,20) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f2.setProperty("totalPage");
    // /jsp/contract/relation_list.jsp(42,20) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_logic_005fgreaterThan_005f2.setValue("1");
    int _jspx_eval_logic_005fgreaterThan_005f2 = _jspx_th_logic_005fgreaterThan_005f2.doStartTag();
    if (_jspx_eval_logic_005fgreaterThan_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                    ");
        if (_jspx_meth_html_005flink_005f1(_jspx_th_logic_005fgreaterThan_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t                    \r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_logic_005fgreaterThan_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_005fgreaterThan_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005flogic_005fgreaterThan_0026_005fvalue_005fproperty_005fname.reuse(_jspx_th_logic_005fgreaterThan_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005flink_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_005fgreaterThan_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_005flink_005f1 = (org.apache.struts.taglib.html.LinkTag) _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_005flink_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005flink_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_005fgreaterThan_005f2);
    // /jsp/contract/relation_list.jsp(43,21) name = href type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005flink_005f1.setHref("javascript:direction('next')");
    int _jspx_eval_html_005flink_005f1 = _jspx_th_html_005flink_005f1.doStartTag();
    if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005flink_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005flink_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t                        <img style= \"padding: 0 5px 0 1px\" class=\"pager-next\" src=\"./image/next.png\" alt= \"next\"/>\r\n");
        out.write("\t                    ");
        int evalDoAfterBody = _jspx_th_html_005flink_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005flink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005flink_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005flink_0026_005fhref.reuse(_jspx_th_html_005flink_005f1);
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
    // /jsp/contract/relation_list.jsp(54,12) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f0.setProperty("direction");
    int _jspx_eval_html_005fhidden_005f0 = _jspx_th_html_005fhidden_005f0.doStartTag();
    if (_jspx_th_html_005fhidden_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
    return false;
  }
}
