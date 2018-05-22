package com.suninfo.util.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Criteria {

	/**
	 * 存放条件查询值
	 */
	private Map<String, Object> condition;

	/**
	 * 是否相异
	 */
	protected boolean distinct;

	private int currentPage = 1; // 当前页

	private int totalCount = 0; // 总行数

	private int pageSize = 20; // 页大小
	
	private List pageList ; //查询结果数据

	/**
	 * 排序字段
	 */
	protected String orderByClause;

	protected Criteria(Criteria example){
		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.distinct = example.distinct;

	}

	public Criteria(){
		condition = new HashMap<String, Object>();
	}

	public void clear() {
		condition.clear();
		orderByClause = null;
		distinct = false;

	}

	/**
	 * @param condition
	 *            查询的条件名称
	 * @param value
	 *            查询的值
	 */
	public Criteria put( String condition, Object value ) {
		this.condition.put( condition, value );
		return ( Criteria )this;
	}

	/**
	 * @param orderByClause
	 *            排序字段
	 */
	public void setOrderByClause( String orderByClause ) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @param distinct
	 *            是否相异
	 */
	public void setDistinct( boolean distinct ) {
		this.distinct = distinct;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setCondition( Map<String, Object> condition ) {
		this.condition = condition;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage( int currentPage ) {
		this.currentPage = currentPage;
	}

	/**
	 * 得到总行数
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		int pageCount = this.totalCount / this.pageSize + 1;
		// 如果模板==0，且总数大于1，则减一
		if( ( this.totalCount % this.pageSize == 0 ) && pageCount > 1 )
			pageCount--;
		return pageCount;
	}

	public void setTotalCount( int totalCount ) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize( int pageSize ) {
		this.pageSize = pageSize;
	}

	
	public List getPageList() {
		return pageList;
	}

	
	public void setPageList( List pageList ) {
		this.pageList = pageList;
	}

}