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


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for C3P0
 *
 * @author David Hsing
 * @see com.mchange.v2.c3p0.impl.WrapperConnectionPoolDataSourceBase
 */
@Getter
@Setter
@ToString
public class C3p0DataSourceProperties extends DataSourceProperties {
    private Integer acquireIncrement;
    private Integer acquireRetryAttempts;
    private Integer acquireRetryDelay;
    private Boolean autoCommitOnClose;
    private String automaticTestTable;
    private Boolean breakAfterAcquireFailure;
    private String connectionCustomizerClassName;
    private String connectionTesterClassName;
    private String contextClassLoaderSource;
    private Integer checkoutTimeout;
    private Boolean debugUnreturnedConnectionStackTraces;
    private String factoryClassLocation;
    private Boolean forceIgnoreUnresolvedTransactions;
    private Boolean forceSynchronousCheckins;
    private Integer idleConnectionTestPeriod;
    private Integer initialPoolSize;
    private Integer maxAdministrativeTaskTime;
    private Integer maxConnectionAge;
    private Integer maxIdleTime;
    private Integer maxIdleTimeExcessConnections;
    private Integer maxPoolSize;
    private Integer maxStatements;
    private Integer maxStatementsPerConnection;
    private Integer minPoolSize;
    private String overrideDefaultPassword;
    private String overrideDefaultUser;
    private String preferredTestQuery;
    private Boolean privilegeSpawnedThreads;
    private Integer propertyCycle;
    private Integer statementCacheNumDeferredCloseThreads;
    private Boolean testConnectionOnCheckin;
    private Boolean testConnectionOnCheckout;
    private Integer unreturnedConnectionTimeout;
    private Boolean usesTraditionalReflectiveProxies;
}
