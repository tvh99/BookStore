package vn.com.stanford.je0824.bookstore.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AuthorizationFilter implements Filter {
    /**
     * Default constructor.
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * Kiểm tra người dùng đã đăng nhập thành công hay chưa thì mới sử dụng được các chức năng của hệ thống
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();

        //Nếu đăng nhập thành công
        if(session != null && session.getAttribute("userOnline") != null)
        {
            String userName = "" + session.getAttribute("userOnline");

            System.out.println("Đăng nhập với username: " + userName);
        }
        else
        {
            HttpServletResponse res = (HttpServletResponse) response;

            //Di chuyển đến trang đăng nhập
            res.sendRedirect("../DangNhap.jsp");
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
