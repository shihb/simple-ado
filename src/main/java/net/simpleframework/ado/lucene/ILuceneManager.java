package net.simpleframework.ado.lucene;

import java.util.Map;

import net.simpleframework.ado.IADOManager;
import net.simpleframework.ado.query.IDataQuery;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface ILuceneManager extends IADOManager {

	/**
	 * 判断索引是否存在
	 * 
	 * @return
	 */
	boolean indexExists();

	/**
	 * 重构索引
	 */
	void rebuildIndex();

	/**
	 * 往索引里添加对象
	 * 
	 * @param objects
	 */
	void doAddIndex(Object... objects);

	/**
	 * 
	 * @param idkey
	 * @param objects
	 */
	void doUpdateIndex(Object... objects);

	/**
	 * 删除索引
	 * 
	 * @param objects
	 */
	void doDeleteIndex(Object... objects);

	/**
	 * 查询
	 * 
	 * @param queryString
	 * @param callback
	 * @param beanClass
	 */
	<T> IDataQuery<T> query(String queryString, Class<T> beanClass);

	/**
	 * 
	 * @param queryString
	 * @param callback
	 */
	IDataQuery<Map<String, Object>> query(String queryString);

	/**
	 * 
	 * @param queryString
	 * @return
	 */
	String[] getQueryTokens(String queryString);
}
