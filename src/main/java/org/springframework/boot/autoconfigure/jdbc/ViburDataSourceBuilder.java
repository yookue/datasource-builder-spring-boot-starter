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
import org.vibur.dbcp.ViburDBCPDataSource;
import org.vibur.dbcp.ViburDataSource;
import com.yookue.springstarter.datasourcebuilder.property.ViburDataSourceProperties;


/**
 * {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration} for Vibur
 *
 * @author David Hsing
 */
public abstract class ViburDataSourceBuilder extends AbstractDataSourceBuilder {
    public static ViburDataSource buildDataSource(@Nonnull ViburDataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        JdbcConnectionDetails alias = (details != null) ? details : JdbcConfigurationUtils.connectionDetails(properties);
        ViburDataSource dataSource = JdbcConfigurationUtils.createDataSource(alias, ViburDBCPDataSource.class, null);
        setDataSourceProperties(dataSource, properties);
        return dataSource;
    }
}
