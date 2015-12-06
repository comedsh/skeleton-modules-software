package com.fenghua.auto.backend.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fenghua.auto.backend.common.utils.mail.SimpleMailSender;

@Component
@Aspect
public class PerformanceListener {
	
	private static final Log LOG = LogFactory.getLog(PerformanceListener.class);
	
	@Resource
	private long performanceTimeThreshold; 
	
	@Resource
	private String performanceReceiver;
	@Resource
	private String performanceCclist;

	@Resource
	private String smtpHost;
	@Resource
	private String smtpPort;
	@Resource
	private String mailSender;
	@Resource
	private String mailPwd;
	
	// 定义一个切入点
	@Pointcut("execution(* com.fenghua.auto.backend.dao.impl.*.*(..))")
	private void aspect() {
	}

	@Around("aspect()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		
		final String className = pjp.getTarget().getClass().getName();
		final Object [] args = pjp.getArgs();
		final String method = pjp.toShortString().split("\\.")[1].replace("(", "");
		
		long start = System.currentTimeMillis();
		Object object = pjp.proceed();// 执行该方法
		long end = System.currentTimeMillis();
		
		final long excuteTime = end - start;
		LOG.debug(className+"."+method+"(..) : " + excuteTime + "(ms)");
		
		if(excuteTime > performanceTimeThreshold){
			Executors.newCachedThreadPool().execute(new Thread(){
				@Override
				public void run() {
					Address[] addrArray = null;
					if(StringUtils.isNotBlank(performanceCclist)){
						List<Address> addrList= new ArrayList<Address>();
						for(String addr : performanceCclist.split(",")){
							try {
								addrList.add(new InternetAddress(addr.trim()));
							} catch (AddressException e) {
								e.printStackTrace();
							}
						}
						
						addrArray = new Address[addrList.size()];
						addrList.toArray(addrArray);
					}
					
					StringBuilder params = new StringBuilder();
					
					for(int i=0;i<args.length;i++){
						params.append(" 参数").append(i+1).append("： <br /> ").append(args[i]).append("<br /> ");
					}
					
					try {
						SimpleMailSender.sendHtmlMail(addrArray,performanceReceiver, "【性能告警】"+(className+"."+method+"(..) : "+ excuteTime + "(ms)"), params.toString());
					} catch (Exception e) {
						LOG.error("doBasicProfiling Exception:", e);
					}
				}
			});
		}
		
		return object;
	}
}
