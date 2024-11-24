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

package com.yookue.springstarter.datasourcebuilder.property;


import java.util.List;
import java.util.Properties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for DBCP2
 *
 * @author David Hsing
 * @see org.apache.commons.dbcp2.BasicDataSource
 */
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class Dbcp2DataSourceProperties extends DataSourceProperties {
    private Boolean defaultAutoCommit;
    private Boolean defaultReadOnly;
    private Integer defaultTransactionIsolation;
    private Integer defaultQueryTimeoutSeconds;
    private String defaultCatalog;
    private String defaultSchema;
    private Boolean cacheState;
    private Boolean lifo;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer initialSize;
    private Long maxWaitMillis;
    private Boolean poolPreparedStatements;
    private Boolean clearStatementPoolOnReturn;
    private Integer maxOpenPreparedStatements;
    private Boolean testOnCreate;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Long timeBetweenEvictionRunsMillis;
    private Integer numTestsPerEvictionRun;
    private Long minEvictableIdleTimeMillis;
    private Long softMinEvictableIdleTimeMillis;
    private String evictionPolicyClassName;
    private Boolean testWhileIdle;
    private String validationQuery;
    private Integer validationQueryTimeoutSeconds;
    private String connectionFactoryClassName;
    private List<String> connectionInitSqls;
    private Boolean accessToUnderlyingConnectionAllowed;
    private Long maxConnLifetimeMillis;
    private Boolean logExpiredConnections;
    private String jmxName;
    private Boolean autoCommitOnReturn;
    private Boolean rollbackOnReturn;
    private Boolean fastFailValidation;
    private Properties connectionProperties = new Properties();
}
