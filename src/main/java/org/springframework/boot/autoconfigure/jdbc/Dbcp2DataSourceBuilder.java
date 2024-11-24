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
import org.apache.commons.dbcp2.BasicDataSource;
import com.yookue.springstarter.datasourcebuilder.property.Dbcp2DataSourceProperties;


/**
 * {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration} for DBCP2
 *
 * @author David Hsing
 */
@SuppressWarnings("unused")
public abstract class Dbcp2DataSourceBuilder extends AbstractDataSourceBuilder {
    public static BasicDataSource buildDataSource(@Nonnull Dbcp2DataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        JdbcConnectionDetails alias = (details != null) ? details : JdbcConfigurationUtils.connectionDetails(properties);
        BasicDataSource dataSource = JdbcConfigurationUtils.createDataSource(alias, BasicDataSource.class, null);
        setDataSourceProperties(dataSource, properties);
        return dataSource;
    }
}
