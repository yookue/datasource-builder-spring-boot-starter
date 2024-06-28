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


import java.util.Properties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for Tomcat
 *
 * @author David Hsing
 * @see "org.apache.tomcat.jdbc.pool.PoolProperties"
 */
@Getter
@Setter
@ToString
public class TomcatDataSourceProperties extends DataSourceProperties {
    private Properties dbProperties = new Properties();
    private Boolean defaultAutoCommit;
    private Boolean defaultReadOnly;
    private Integer defaultTransactionIsolation;
    private String defaultCatalog;
    private String connectionProperties;
    private Integer initialSize;
    private Integer maxActive;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;
    private String validationQuery;
    private Integer validationQueryTimeout;
    private String validatorClassName;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer numTestsPerEvictionRun;
    private Integer minEvictableIdleTimeMillis;
    private Boolean accessToUnderlyingConnectionAllowed;
    private Boolean removeAbandoned;
    private Integer removeAbandonedTimeout;
    private Boolean logAbandoned;
    private Long validationInterval;
    private Boolean jmxEnabled;
    private String initSQL;
    private Boolean testOnConnect;
    private String jdbcInterceptors;
    private Boolean fairQueue;
    private Boolean useEquals;
    private Integer abandonWhenPercentageFull;
    private Long maxAge;
    private Boolean useLock;
    private Integer suspectTimeout;
    private Object dataSource;
    private String dataSourceJNDI;
    private Boolean alternateUsernameAllowed;
    private Boolean commitOnReturn;
    private Boolean rollbackOnReturn;
    private Boolean useDisposableConnectionFacade;
    private Boolean logValidationErrors;
    private Boolean propagateInterruptState;
    private Boolean ignoreExceptionOnPreLoad;
    private Boolean useStatementFacade;
}
