package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.ContextLifecycleFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.FilterRegistry;
import com.netflix.zuul.http.ZuulServlet;
import com.netflix.zuul.monitoring.MonitoringHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Component
	public static class MyCommandLineRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			MonitoringHelper.initMocks();
			initJavaFilters();
		}

		private void initJavaFilters() {
			final FilterRegistry r = FilterRegistry.instance();

			r.put("javaPreFilter", new ZuulFilter() {
				@Override
				public int filterOrder() {
					return 50000;
				}

				@Override
				public String filterType() {
					return "pre";
				}

				@Override
				public boolean shouldFilter() {
					return true;
				}

				@Override
				public Object run() {
					System.out.println("running javaPreFilter");
					RequestContext.getCurrentContext().set("name", "Melo15zhang");
					return null;
				}
			});

			r.put("javaRoutingFilter", new ZuulFilter() {
				@Override
				public int filterOrder() {
					return 50000;
				}

				@Override
				public String filterType() {
					return "route";
				}

				@Override
				public boolean shouldFilter() {
					return true;
				}

				@Override
				public Object run() {
					System.out.println("running javaRoutingFilter");
					try {
						RequestContext.getCurrentContext().getResponse().sendRedirect("http://localhost:8001/");
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
			});

			r.put("javaPostFilter", new ZuulFilter() {
				@Override
				public int filterOrder() {
					return 50000;
				}

				@Override
				public String filterType() {
					return "post";
				}

				@Override
				public boolean shouldFilter() {
					return true;
				}

				@Override
				public Object run() {
					System.out.println("running javaPostFilter");
					System.out.println(RequestContext.getCurrentContext().get("name").toString());
					return null;
				}

			});

		}

	}

	@Bean
	public ServletRegistrationBean zuulServlet() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new ZuulServlet());
		servlet.addUrlMappings("/test");
		return servlet;
	}

	@Bean
	public FilterRegistrationBean contextLifecycleFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean(new ContextLifecycleFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}
}
