package bookstore.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class Encoding implements Filter {

    class ReEncodedRequest extends HttpServletRequestWrapper  {

        public ReEncodedRequest(ServletRequest request) {
            super((HttpServletRequest)request);
        }
        
        @Override
        public String getParameter(String paramName) {
            String value = super.getParameter(paramName);
            try {
                if(value != null && this.getCharacterEncoding() == null) {
                    value = new String(value.getBytes("ISO-8859-1"),"UTF8");
                }
            } catch (UnsupportedEncodingException ex) {
                value = null;
            }
            return value;
    	}
    
    }
    
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public Encoding() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new ReEncodedRequest(request), response);
        //chain.doFilter(request, response);
    }


    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
        /**
     * Return the filter configuration object for this filter.
     * @return FilterConfig
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
