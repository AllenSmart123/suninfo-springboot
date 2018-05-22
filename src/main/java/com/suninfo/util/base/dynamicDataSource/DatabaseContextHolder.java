package com.suninfo.util.base.dynamicDataSource;

/**
 * 
 * 数据源操作
 * 
 * @ClassName: DatabaseContextHolder
 * @author Comsys-chnepf
 * @date 2015-12-26 下午2:24:11
 * 
 */
public class DatabaseContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 
	 * setDateSource(设置数据源)
	 * 
	 * @author Comsys-chnepf
	 * @date 2015-12-17 下午3:41:17
	 * @Title: setDateSource
	 * @Description: TODO
	 * @param @param DateSource 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void setDateSource( String DateSource ) {
		contextHolder.set( DateSource );
	}

	/**
	 * 
	 * getDateSource(获取数据源)
	 * 
	 * @author Comsys-chnepf
	 * @date 2015-12-17 下午3:41:38
	 * @Title: getDateSource
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getDateSource() {
		return contextHolder.get();
	}

	/**
	 * 
	 * clearDateSource(清空数据源)
	 * 
	 * @author Comsys-chnepf
	 * @date 2015-12-17 下午3:41:50
	 * @Title: clearDateSource
	 * @Description: TODO
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void clearDateSource() {
		contextHolder.remove();
	}
}
