package bookstore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class Timing implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Timing() {
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
        long initTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("Timming Filter -> Elapsed time: " + (System.currentTimeMillis() - initTime) + "msec");
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
