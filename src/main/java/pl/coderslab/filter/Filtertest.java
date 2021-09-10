package pl.coderslab.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "")
public class Filtertest implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter");
        log.error("filter");
        chain.doFilter(request, response);
    }
}
