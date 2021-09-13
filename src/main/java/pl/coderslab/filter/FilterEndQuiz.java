package pl.coderslab.filter;

import lombok.extern.slf4j.Slf4j;
import pl.coderslab.model.CurrentQuiz;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class FilterEndQuiz implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI();
        HttpSession session = request.getSession();
        CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
        if (currentQuiz == null || path.startsWith(currentQuiz.getPath())) {
            chain.doFilter(req, res);
        } else {
            HttpServletResponse response = (HttpServletResponse) res;
            response.sendRedirect(currentQuiz.getPath() + "/confirmation");
        }
    }
}
