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


import java.lang.reflect.Field;
import javax.sql.DataSource;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import com.yookue.springstarter.datasourcebuilder.constant.DataSourcePoolConst;
import com.yookue.springstarter.datasourcebuilder.property.C3p0DataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.Dbcp2DataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.DruidDataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.HikariDataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.OracleUcpDataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.TomcatDataSourceProperties;
import com.yookue.springstarter.datasourcebuilder.property.ViburDataSourceProperties;
import lombok.extern.slf4j.Slf4j;


/**
 * Abstract builder that extended from {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration}
 *
 * @author David Hsing
 * @see org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration
 */
@Slf4j
public abstract class AbstractDataSourceBuilder extends DataSourceConfiguration {
    public static DataSource buildDataSource(@Nonnull DataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        Class<? extends DataSource> type = properties.getType();
        if (type == null) {
            if (log.isWarnEnabled()) {
                log.warn("Data source with url '{}' is missing 'type' property, using generic type instead", properties.getUrl());
            }
            return JdbcConfigurationUtils.genericDataSource(properties, details);
        }
        return buildDataSource(properties, details, ClassUtils.getQualifiedName(type));
    }

    public static DataSource buildDataSource(@Nonnull DataSourceProperties properties, @Nullable JdbcConnectionDetails details, @Nonnull String poolType) {
        if (!StringUtils.hasText(poolType)) {
            return JdbcConfigurationUtils.genericDataSource(properties, details);
        }
        return switch (poolType) {
            case DataSourcePoolConst.C3P0 -> C3p0DataSourceBuilder.buildDataSource((C3p0DataSourceProperties) properties, details);
            case DataSourcePoolConst.DBCP2 -> Dbcp2DataSourceBuilder.buildDataSource((Dbcp2DataSourceProperties) properties, details);
            case DataSourcePoolConst.DRUID -> DruidDataSourceBuilder.buildDataSource((DruidDataSourceProperties) properties, details);
            case DataSourcePoolConst.HIKARI -> HikariDataSourceBuilder.buildDataSource((HikariDataSourceProperties) properties, details);
            case DataSourcePoolConst.ORACLE_UCP -> OracleUcpDataSourceBuilder.buildDataSource((OracleUcpDataSourceProperties) properties, details);
            case DataSourcePoolConst.ORACLE_UCP_XA -> OracleUcpDataSourceBuilder.buildXaDataSource((OracleUcpDataSourceProperties) properties, details);
            case DataSourcePoolConst.VIBUR -> ViburDataSourceBuilder.buildDataSource((ViburDataSourceProperties) properties, details);
            case DataSourcePoolConst.TOMCAT -> TomcatDataSourceBuilder.buildDataSource((TomcatDataSourceProperties) properties, details);
            default -> {
                if (log.isWarnEnabled()) {
                    log.warn("Data source with url '{}' is an unsupported type, using generic type instead", properties.getUrl());
                }
                yield JdbcConfigurationUtils.genericDataSource(properties, details);
            }
        };
    }

    public static void setDataSourceProperties(@Nonnull DataSource dataSource, @Nonnull DataSourceProperties properties) {
        Field[] fields = properties.getClass().getDeclaredFields();
        if (ObjectUtils.isEmpty(fields)) {
            return;
        }
        for (Field field : fields) {
            try {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, properties);
                if (!ObjectUtils.isEmpty(value)) {
                    ReflectionUtils.setField(field, dataSource, value);
                }
            } catch (Exception ignored) {
            }
        }
    }
}
