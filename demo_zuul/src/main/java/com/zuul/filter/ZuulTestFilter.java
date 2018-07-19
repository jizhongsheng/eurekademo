package com.zuul.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class ZuulTestFilter extends ZuulFilter {
    /*
    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
    1、pre 在路由之前
    2、routing 在路由时
    3、post 在路由之后
    4、error 在出错时
   filterOrder：过滤的顺序
   shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
   run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public String filterType() {
        return "pre";
    }
/*
 filterOrder：过滤的顺序
 */
    @Override
    public int filterOrder() {
        return 0;
    }
/*
shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
 */
    @Override
    public boolean shouldFilter() {
        return true;
    }
/*
run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     这个作用是在请求中检测是否有token 如果没有的话 就返回 token is empty
 */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Object token = request.getParameter("token");
        if(token == null){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty !");
            } catch (IOException e) {
                return  null ;
            }
        }
        return null;
    }
}
