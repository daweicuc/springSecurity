package cuc.dawei.springsecuritydemo.service;

/**
 * @ClassName LoginAuthenticationFilter
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/21 22:43
 * @Version 1.0
 */

import com.google.code.kaptcha.Constants;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private String servletPath;
    public KaptchaAuthenticationFilter(String servletPath, String failureUrl) {
        super(servletPath);
        this.servletPath = servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if ("POST".equalsIgnoreCase(req.getMethod()) && "GET".equalsIgnoreCase(req.getMethod())&& servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (expect != null && !expect.equalsIgnoreCase(req.getParameter("code"))) {
                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));
                return;
            }
        }
        chain.doFilter(request, response);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }

//
//public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//
//    public LoginAuthenticationFilter() {
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        //获取表单提交的验证码的值
//        String verification = request.getParameter("code");
//        //获取下发的存在session中的验证码的值
//        String captcha = (String) request.getSession().getAttribute("vrifyCode");
//        System.out.println("Session  vrifyCode ---->"+captcha+"---- form code --->"+verification);
//        if (captcha==null){
//            System.out.println("验证码不为空");
//        }
//        else  if (!captcha.contentEquals(verification)) {
//            System.out.println("验证码不匹配");
//        }
//        //调用UsernamePasswordAuthenticationFilter的认证方法
//        return super.attemptAuthentication(request, response);
//    }
}

