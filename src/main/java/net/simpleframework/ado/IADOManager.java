package net.simpleframework.ado;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IADOManager {

	/**
	 * 添加监听器
	 * 
	 * @param listener
	 */
	void addListener(IADOListener listener);

	/**
	 * 移除监听器
	 * 
	 * @param listener
	 * @return
	 */
	boolean removeListener(IADOListener listener);

	void reset();
}
