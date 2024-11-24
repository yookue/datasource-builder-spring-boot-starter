/*
 * Copyright (c) 2020 Yookue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yookue.springstarter.datasourcebuilder.constant;


/**
 * Constants for supported datasource pools
 *
 * @author David Hsing
 */
@SuppressWarnings("unused")
public abstract class DataSourcePoolConst {
    public static final String C3P0 = "com.mchange.v2.c3p0.ComboPooledDataSource";    // $NON-NLS-1$
    public static final String DBCP2 = "org.apache.commons.dbcp2.BasicDataSource";    // $NON-NLS-1$
    public static final String DRUID = "com.alibaba.druid.pool.DruidDataSource";    // $NON-NLS-1$
    public static final String HIKARI = "com.zaxxer.hikari.HikariDataSource";    // $NON-NLS-1$
    public static final String ORACLE_UCP = "oracle.ucp.jdbc.PoolDataSourceImpl";    // $NON-NLS-1$
    public static final String ORACLE_UCP_XA = "oracle.ucp.jdbc.PoolXADataSourceImpl";    // $NON-NLS-1$
    public static final String VIBUR = "org.vibur.dbcp.ViburDBCPDataSource";    // $NON-NLS-1$
    public static final String TOMCAT = "org.apache.tomcat.jdbc.pool.DataSource";    // $NON-NLS-1$
}
