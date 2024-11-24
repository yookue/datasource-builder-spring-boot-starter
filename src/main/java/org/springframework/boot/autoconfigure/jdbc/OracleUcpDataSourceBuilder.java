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

package org.springframework.boot.autoconfigure.jdbc;


import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import com.yookue.springstarter.datasourcebuilder.property.OracleUcpDataSourceProperties;
import oracle.ucp.jdbc.PoolDataSourceImpl;
import oracle.ucp.jdbc.PoolXADataSourceImpl;


/**
 * {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration} for Oracle UCP
 *
 * @author David Hsing
 */
@SuppressWarnings("unused")
public abstract class OracleUcpDataSourceBuilder extends AbstractDataSourceBuilder {
    public static PoolDataSourceImpl buildDataSource(@Nonnull OracleUcpDataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        JdbcConnectionDetails alias = (details != null) ? details : JdbcConfigurationUtils.connectionDetails(properties);
        PoolDataSourceImpl dataSource = JdbcConfigurationUtils.createDataSource(alias, PoolDataSourceImpl.class, null);
        setDataSourceProperties(dataSource, properties);
        return dataSource;
    }

    public static PoolXADataSourceImpl buildXaDataSource(@Nonnull OracleUcpDataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        JdbcConnectionDetails alias = (details != null) ? details : JdbcConfigurationUtils.connectionDetails(properties);
        PoolXADataSourceImpl dataSource = JdbcConfigurationUtils.createDataSource(alias, PoolXADataSourceImpl.class, null);
        setDataSourceProperties(dataSource, properties);
        return dataSource;
    }
}
