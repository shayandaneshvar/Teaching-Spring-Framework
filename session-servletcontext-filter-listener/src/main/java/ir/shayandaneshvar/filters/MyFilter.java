package ir.shayandaneshvar.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@WebFilter(urlPatterns = "/hello-servlet")
public class MyFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        long before = System.nanoTime();
        chain.doFilter(request, response);
        long after = System.nanoTime();
        out.print("<br/>Total response time: " + (after - before) + " ns. <hr/>");
        Enumeration<String> enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            out.println("<br>" + config.getInitParameter(enumeration.nextElement()));
        }
        out.close();
    }

    @Override
    public void destroy() {
    }
}
