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
import javax.annotation.Nullable;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for Druid
 *
 * @author David Hsing
 * @reference "https://github.com/alibaba/druid/wiki/DruidDataSource配置属性列表"
 */
@Getter
@Setter
@ToString
@SuppressWarnings({"unused", "JavadocDeclaration", "JavadocLinkAsPlainText"})
public class DruidDataSourceProperties extends DataSourceProperties {
    /**
     * @see com.alibaba.druid.pool.DruidAbstractDataSource
     */
    private Boolean defaultAutoCommit;
    private Boolean defaultReadOnly;
    private Integer defaultTransactionIsolation;
    private String defaultCatalog;
    private Integer initialSize;
    private Integer maxActive;
    private Integer minIdle;
    private Long maxWait;
    private String validationQuery;
    private Integer validationQueryTimeout;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;
    private Boolean poolPreparedStatements;
    private Boolean sharePreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private Boolean initExceptionThrow;
    private Boolean clearFiltersEnable;
    private Integer queryTimeout;
    private Integer transactionQueryTimeout;
    private Boolean accessToUnderlyingConnectionAllowed;
    private Long timeBetweenEvictionRunsMillis;
    private Integer numTestsPerEvictionRun;
    private Long minEvictableIdleTimeMillis;
    private Long maxEvictableIdleTimeMillis;
    private Long keepAliveBetweenTimeMillis;
    private Long phyTimeoutMillis;
    private Long phyMaxUseCount;
    private Boolean removeAbandoned;
    private Long removeAbandonedTimeoutMillis;
    private Boolean logAbandoned;
    private Integer maxOpenPreparedStatements;
    private List<String> connectionInitSqls;
    private Long timeBetweenConnectErrorMillis;
    private Integer connectionErrorRetryAttempts;
    private Boolean breakAfterAcquireFailure;
    private Long transactionThresholdMillis;
    private Boolean useUnfairLock;
    private Boolean useLocalSessionState;
    private Long timeBetweenLogStatsMillis;
    private Boolean asyncCloseConnectionEnable;
    private Boolean failFast;
    private Integer failContinuous;
    private Long failContinuousTimeMillis;
    private Boolean initGlobalVariants;
    private Boolean initVariants;
    private String connectionProperties;

    /**
     * @see com.alibaba.druid.pool.DruidDataSource
     */
    private Boolean resetStatEnable;
    private Long closeTimeMillis;
    private Boolean useGlobalDataSourceStat;
    private Boolean mbeanRegistered;
    private Boolean logDifferentThread;
    private Boolean keepAlive;
    private Boolean asyncInit;
    private Boolean killWhenSocketReadTimeout;
    private Boolean checkExecuteTime;
    private Boolean loadSpifilterSkip;

    /**
     * @see com.alibaba.druid.pool.DruidDataSource#configFromPropeties
     */
    private String filters;    // Separated by ',' and trimmed

    @SuppressWarnings("DataFlowIssue")
    public void setConnectionProperties(@Nullable String connectionProperties) {
        this.connectionProperties = StringUtils.trimAllWhitespace(connectionProperties);
    }

    @SuppressWarnings("DataFlowIssue")
    public void setFilters(@Nullable String filters) {
        this.filters = StringUtils.trimAllWhitespace(filters);
    }
}
