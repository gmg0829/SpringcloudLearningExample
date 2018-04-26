package com.gmg.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: gmg
 * @Date: 2018/4/11 16:57
 * @Description:限流过滤器  控制每秒请求接口次数
 */
public class RateLimitZuulFilter extends ZuulFilter{
    //每秒请求的次数
    private final RateLimiter rateLimiter=RateLimiter.create(1.0);
    @Override
    public String filterType() {

        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
            RequestContext currentContext = RequestContext.getCurrentContext();

            HttpServletResponse response = currentContext.getResponse();

            if (!rateLimiter.tryAcquire()){

                   /* HttpStatus httpStatus=HttpStatus.TOO_MANY_REQUESTS;
                    response.setContentType(MediaType.TEXT_PLAIN_VALUE);
                    response.setStatus(httpStatus.value());
                    response.getWriter().append(httpStatus.getReasonPhrase());
                    currentContext.setSendZuulResponse(false);
                    throw new ZuulException(httpStatus.getReasonPhrase(),httpStatus.value(),httpStatus.getReasonPhrase());*/
                     currentContext.setResponseBody("服务繁忙，请稍后重试!");


              }
        return null;
    }
}
