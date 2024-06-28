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
 * Properties for Hikari
 *
 * @author David Hsing
 * @see "com.zaxxer.hikari.HikariConfig"
 */
@Getter
@Setter
@ToString
public class HikariDataSourceProperties extends DataSourceProperties {
    private String catalog;
    private Long connectionTimeout;
    private Long validationTimeout;
    private Long idleTimeout;
    private Long leakDetectionThreshold;
    private Long maxLifetime;
    private Integer maxPoolSize;
    private Integer minIdle;
    private Long initializationFailTimeout;
    private String connectionInitSql;
    private String connectionTestQuery;
    private String exceptionOverrideClassName;
    private String transactionIsolationName;
    private Boolean isAutoCommit;
    private Boolean isReadOnly;
    private Boolean isIsolateInternalQueries;
    private Boolean isRegisterMbeans;
    private Boolean isAllowPoolSuspension;
    private Properties healthCheckProperties = new Properties();
    private Long keepaliveTime;
    private Boolean sealed;
}
