package com.osp.npo.app.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

/**
 * SetCharacterEncodingFilter class
 * 
 * @author haint
 * @version $Revision: 17057 $
 */
public class SetCharacterEncodingFilter implements Filter {


    protected String encoding = null;
    protected String locale = null;

    protected FilterConfig filterConfig = null;


    protected boolean ignore = true;



    public void destroy() {
        this.encoding = null;
        this.locale = null;
        this.filterConfig = null;
    }


    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;

        if (ignore || (request.getCharacterEncoding() == null)) {
            String encode = selectEncoding(request);
            if (encode != null) {
                request.setCharacterEncoding(encode);
            }
        }
        Locale locale = new Locale(this.locale);
        HttpSession session = req.getSession( );
        session.setAttribute(Globals.LOCALE_KEY, locale);

        
        chain.doFilter(request, response);
    }


    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;
        this.locale = filterConfig.getInitParameter("locale");
        this.encoding = filterConfig.getInitParameter("encoding");
        String value = filterConfig.getInitParameter("ignore");
        if (value == null) {
            this.ignore = true;
        } else if (value.equalsIgnoreCase("true")) {
            this.ignore = true;
        } else if (value.equalsIgnoreCase("yes")) {
            this.ignore = true;
        } else {
            this.ignore = false;
        }

    }


    protected String selectEncoding(ServletRequest request) {
        
        return this.encoding;

    }
}
