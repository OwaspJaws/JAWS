package org.owasp.jaws.good.validation;

import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by massoo on 16/11/14.
 */
public class InputValidationFilter implements Filter {

    public static final Logger LOG = LoggerFactory.getLogger(InputValidationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("Hooking SecurityWrapperRequest for security purposes!");
        chain.doFilter(new SecurityWrapperRequest( (HttpServletRequest)request ), response);
    }

    @Override
    public void destroy() {

    }
}
