package com.suninfo.util.base.dynamicDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 
 * 动态数据源切换前置通知
 * 
 * @ClassName: DataSourceInterceptor
 * @author Comsys-chnepf
 * @date 2015-12-26 下午2:30:53
 * 
 */
public class DataSourceInterceptor implements MethodBeforeAdvice {

	private static Logger log = LoggerFactory.getLogger( DataSourceInterceptor.class );

	@Override
	public void before( Method method, Object[] args, Object target ) throws Throwable {
		Class<? extends Object> classz = target.getClass();
		Class<?>[] parameterTypes = method.getParameterTypes();
		try {
			Method m = classz.getMethod( method.getName(), parameterTypes );
			if( m != null && m.isAnnotationPresent( DataSource.class ) ) {
				DataSource data = m.getAnnotation( DataSource.class );
				DatabaseContextHolder.setDateSource( data.name() );
				log.error( "【" + classz.getName() + "." + m.getName() + "成功切换到" + data.name() + "数据库】" );
			}
		} catch( Exception e ) {
			log.error( e.toString() );
		}

	}

}
