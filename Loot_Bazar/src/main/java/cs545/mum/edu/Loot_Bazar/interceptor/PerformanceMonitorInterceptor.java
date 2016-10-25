package cs545.mum.edu.Loot_Bazar.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor implements HandlerInterceptor{

	ThreadLocal<StopWatch> stopWatchLocal=new ThreadLocal<>();
	Logger logger=Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		StopWatch stopWatch= new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Accessing URL path: "+getURLPath(request));
		logger.info("Request Processing started on: "+getCurrentTime());
		return true;
	}

	private String getCurrentTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
		
	}

	private String getURLPath(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String currentPath=request.getRequestURI();
		String queryString=request.getQueryString();
		queryString=queryString==null? "": "?" +queryString;
		return currentPath+queryString;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Request processing ended on "+ getCurrentTime());
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		StopWatch stopWatch=stopWatchLocal.get();
		stopWatch.stop();
		logger.info("Total time taken for processing : "+stopWatch.getTotalTimeMillis()+" ms");
		stopWatchLocal.set(null);
		logger.info("=====================================");
		
	}

}
