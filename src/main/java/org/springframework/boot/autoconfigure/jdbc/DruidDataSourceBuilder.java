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


import java.util.List;
import java.util.Objects;
import java.util.Properties;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.yookue.springstarter.datasourcebuilder.property.DruidDataSourceProperties;


/**
 * {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration} for Druid
 *
 * @author David Hsing
 */
@SuppressWarnings("unused")
public abstract class DruidDataSourceBuilder extends DataSourceConfiguration {
    @Nullable
    public static DruidDataSource buildDataSource(@Nonnull DruidDataSourceProperties properties, @Nullable JdbcConnectionDetails details) {
        JdbcConnectionDetails alias = (details != null) ? details : JdbcConfigurationUtils.connectionDetails(properties);
        DruidDataSource dataSource = JdbcConfigurationUtils.createDataSource(alias, DruidDataSource.class, null);
        if (dataSource == null) {
            return null;
        }
        Properties druidProperties = new Properties();
        ReflectionUtils.doWithFields(DruidDataSourceProperties.class, field -> {
            try {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, properties);
                if (!ObjectUtils.isEmpty(value)) {
                    druidProperties.put(String.format("druid.%s", field.getName()), value);    // $NON-NLS-1$
                }
            } catch (Exception ignored) {
            }
        });
        dataSource.configFromPropeties(druidProperties);
        if (StringUtils.hasText(properties.getConnectionProperties())) {
            dataSource.setConnectionProperties(properties.getConnectionProperties());
        }
        // @see com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper#afterPropertiesSet
        if (!StringUtils.hasText(dataSource.getUsername())) {
            dataSource.setUsername(properties.determineUsername());
        }
        if (!StringUtils.hasText(dataSource.getPassword())) {
            dataSource.setPassword(properties.determinePassword());
        }
        if (!StringUtils.hasText(dataSource.getDriverClassName())) {
            dataSource.setDriverClassName(properties.determineDriverClassName());
        }
        return dataSource;
    }

    public static void addOrReplaceFilters(@Nullable DruidDataSource dataSource, @Nullable List<Filter> filters) {
        if (dataSource == null || CollectionUtils.isEmpty(filters)) {
            return;
        }
        List<Filter> proxyFilters = dataSource.getProxyFilters();
        if (CollectionUtils.isEmpty(proxyFilters)) {
            dataSource.setProxyFilters(filters);
        } else {
            filters.stream().filter(Objects::nonNull).forEach(filter -> proxyFilters.stream().filter(Objects::nonNull).filter(element -> ClassUtils.isAssignableValue(element.getClass(), filter) || ClassUtils.isAssignableValue(filter.getClass(), element)).findFirst().ifPresent(proxyFilters::remove));
            proxyFilters.addAll(filters);
        }
    }
}
