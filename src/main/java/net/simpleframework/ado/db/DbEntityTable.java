package net.simpleframework.ado.db;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import net.simpleframework.ado.ColumnData;
import net.simpleframework.ado.db.common.TableColumn;
import net.simpleframework.common.StringUtils;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class DbEntityTable implements Serializable {

	private final Class<?> beanClass;

	private final String name;

	private final String[] uniqueColumns;

	private boolean noCache;

	private ColumnData defaultOrder;

	public DbEntityTable(final Class<?> beanClass, final String name) {
		this.beanClass = beanClass;
		this.name = name;
		this.uniqueColumns = new String[] { "id" };
	}

	public String getName() {
		return name;
	}

	public String[] getUniqueColumns() {
		return uniqueColumns;
	}

	public boolean isNoCache() {
		return noCache;
	}

	public DbEntityTable setNoCache(final boolean noCache) {
		this.noCache = noCache;
		return this;
	}

	public ColumnData getDefaultOrder() {
		return defaultOrder;
	}

	public DbEntityTable setDefaultOrder(final ColumnData defaultOrder) {
		this.defaultOrder = defaultOrder;
		return this;
	}

	public Class<?> getBeanClass() {
		return beanClass;
	}

	@SuppressWarnings("unchecked")
	public Map<String, TableColumn> getTableColumns() {
		final Class<?> beanClass = getBeanClass();
		return beanClass == null ? Collections.EMPTY_MAP : TableColumn
				.getTableColumns(getBeanClass());
	}

	public String getSqlName(final String propertyName) {
		final TableColumn tCol = getTableColumns().get(propertyName);
		return tCol != null ? tCol.getSqlName() : propertyName;
	}

	public String getBeanPropertyName(final String sqlName) {
		for (final TableColumn tCol : getTableColumns().values()) {
			if (sqlName.equalsIgnoreCase(tCol.getSqlName())) {
				return tCol.getName();
			}
		}
		return sqlName;
	}

	@Override
	public String toString() {
		return name + ", unique[" + StringUtils.join(uniqueColumns, "-") + "]";
	}

	private static final long serialVersionUID = -6445073606291514860L;
}
