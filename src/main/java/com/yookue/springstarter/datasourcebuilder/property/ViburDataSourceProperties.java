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
 * Properties for Vibur
 *
 * @author David Hsing
 * @see "org.vibur.dbcp.ViburConfig"
 */
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class ViburDataSourceProperties extends DataSourceProperties {
    private Properties driverProperties = new Properties();
    private Integer poolInitialSize;
    private Integer poolMaxSize;
    private Boolean poolFair;
    private Boolean poolEnableConnectionTracking;
    private Boolean allowConnectionAfterTermination;
    private Boolean allowUnwrapping;
    private Long acquireRetryDelayInMs;
    private Long connectionTimeoutInMs;
    private Integer acquireRetryAttempt;
    private Integer loginTimeoutInSeconds;
    private Integer connectionIdleLimitInSeconds;
    private Integer validateTimeoutInSeconds;
    private String testConnectionQuery;
    private String initSQL;
    private Boolean useNetworkTimeout;
    private Long logQueryExecutionLongerThanMs;
    private Boolean logStackTraceForLongQueryExecution;
    private Long logLargeResultSet;
    private Boolean logStackTraceForLargeResultSet;
    private Boolean includeQueryParameters;
    private Long logConnectionLongerThanMs;
    private Boolean logStackTraceForLongConnection;
    private Boolean logTakenConnectionsOnTimeout;
    private Boolean logAllStackTracesOnTimeout;
    private Boolean clearSQLWarnings;
    private Boolean resetDefaultsAfterUse;
    private Boolean defaultAutoCommit;
    private Boolean defaultReadOnly;
    private String defaultTransactionIsolation;
    private String defaultCatalog;
    private Integer statementCacheMaxSize;
    private String poolReducerClass;
    private Integer reducerTimeIntervalInSeconds;
    private Integer reducerSamples;
    private String criticalSQLStates;
    private Boolean enableJMX;
}
