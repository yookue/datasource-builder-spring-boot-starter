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

package com.yookue.springstarter.datasourcebuilder.config;


import javax.sql.DataSource;
import jakarta.annotation.Nonnull;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcOperations;
import com.yookue.springstarter.datasourcebuilder.composer.DataSourceBuilder;
import com.yookue.springstarter.datasourcebuilder.composer.impl.DataSourceBuilderImpl;


/**
 * Configuration for {@link com.yookue.springstarter.datasourcebuilder.composer.DataSourceBuilder}
 *
 * @author David Hsing
 * @see com.yookue.springstarter.datasourcebuilder.composer.DataSourceBuilder
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "spring.datasource-builder", name = "enabled", havingValue = "true", matchIfMissing = true)
@ConditionalOnClass(value = {DataSource.class, JdbcOperations.class})
@AutoConfigureOrder(value = Ordered.HIGHEST_PRECEDENCE + 10000)
public class DataSourceBuilderConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public DataSourceBuilder dataSourceBuilder(@Nonnull ApplicationContext context, @Nonnull Environment environment, @Nonnull ResourceLoader loader) {
        return new DataSourceBuilderImpl(context, environment, loader.getClassLoader());
    }
}
