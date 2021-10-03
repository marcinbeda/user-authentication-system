package pl.beda.UserAuthenticationSystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// IT'S NOT IMPORTANT CLASS FOR THIS PROJECT

@Component
@Order(2)
public class HeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse newResponse = (HttpServletResponse) response;
		newResponse.addHeader("test", "test");
		chain.doFilter(request, newResponse);
	}
}
