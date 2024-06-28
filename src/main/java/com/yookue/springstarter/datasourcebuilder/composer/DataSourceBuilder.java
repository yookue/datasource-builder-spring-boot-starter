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

package com.yookue.springstarter.datasourcebuilder.composer;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.jdbc.XADataSourceWrapper;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import com.yookue.springstarter.datasourcebuilder.enumeration.DataSourcePoolType;


/**
 * Composer interface for datasource builder
 *
 * @author David Hsing
 */
@SuppressWarnings("unused")
public interface DataSourceBuilder {
    DataSource dataSource(@Nonnull DataSourceProperties properties);

    DataSource dataSource(@Nonnull DataSourceProperties properties, @Nonnull DataSourcePoolType type);

    DataSource dataSource(@Nonnull String prefix, @Nonnull Class<? extends DataSourceProperties> clazz);

    DataSourceProperties dataSourceProperties(@Nonnull Environment environment, @Nonnull String prefix);

    DataSourceProperties dataSourceProperties(@Nonnull Environment environment, @Nonnull String prefix, @Nullable DataSourcePoolType type);

    DataSourceProperties dataSourceProperties(@Nonnull String prefix, @Nonnull Class<? extends DataSourceProperties> clazz);

    DataSourceProperties dataSourceProperties(@Nonnull Environment environment, @Nonnull String prefix, @Nonnull Class<? extends DataSourceProperties> clazz);

    DataSourceTransactionManager jdbcTransactionManager(@Nonnull DataSource dataSource, @Nonnull ObjectProvider<TransactionManagerCustomizers> customizers);

    JpaTransactionManager jpaTransactionManager(@Nonnull ObjectProvider<TransactionManagerCustomizers> customizers);

    JpaTransactionManager jpaTransactionManager(@Nullable EntityManagerFactory factory, @Nonnull ObjectProvider<TransactionManagerCustomizers> customizers);

    DataSource xaDataSource(@Nonnull XADataSourceWrapper wrapper, @Nonnull DataSourceProperties properties) throws Exception;
}
