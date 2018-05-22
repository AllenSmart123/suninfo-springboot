package com.suninfo.util.base.dynamicDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * 获取数据源
 * 
 * @ClassName: DynamicDataSource
 * @author Comsys-chnepf
 * @date 2015-12-26 下午1:50:45
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DatabaseContextHolder.getDateSource();
	}

}