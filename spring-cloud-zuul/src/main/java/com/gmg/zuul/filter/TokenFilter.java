package com.gmg.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 *@author	作者：gmg
 *@date	创建时间：2018年4月9日 下午5:36:15
 *@version	版本： 1.0
 *说明：服务过滤，继承ZuulFilter做安全控制  黑白名单控制策略过滤器
 */
public class TokenFilter extends ZuulFilter {

	private final Logger log = LoggerFactory.getLogger(TokenFilter.class);



	//过滤的顺序 越小优先级越高
	@Override
	public int filterOrder() {
		return 0;
	}

	//过滤器类型，pre：路由之前/routing：路由之时 /post： 路由之后 /error：发送错误调用
	@Override
	public String filterType() {
		//路由之前调用
		return "pre";
	}
	
	//当return返回true时过滤 指定过滤器的有效范围
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//过滤器的具体逻辑
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

		//白名单  建议白名单配置在数据库更优
		List<String> uris=new ArrayList<String>();
		uris.add("/api-a/consumer");
		uris.add("/api-b/test/01");
		uris.add("/api-b/consumer");

		String uri = request.getRequestURI();
		log.info("请求路径：{}", uri);

        String token = request.getHeader("token");
		log.info("token：{}", token);

		if(!uris.contains(uri)){
			if (token == null) {
				//token验证失败，抛出异常拦截请求
				log.error("token验证失败，抛出异常拦截请求");
				ctx.setResponseStatusCode(499);
				ctx.setResponseBody("token不能为空!");
			}
		}
		return null;
    }

}
