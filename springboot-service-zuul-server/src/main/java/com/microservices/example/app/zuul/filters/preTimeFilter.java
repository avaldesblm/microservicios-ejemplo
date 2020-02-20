package com.microservices.example.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class preTimeFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(preTimeFilter.class);
	
	// Alguna validación para ejecutar el filtro (en este caso, siempre se va a ejecutar - true)
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	// Resuelve la lógica del filtro
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		log.info(String.format("%s request enrutado a %s", req.getMethod(), req.getRequestURL().toString()));
		Long timepoInicio = System.currentTimeMillis();
		req.setAttribute("tiempoInicio", timepoInicio);
		
		return null;
	}
	
	// Pre
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
