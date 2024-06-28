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


import javax.annotation.Nonnull;
import javax.sql.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.JdbcTransactionManagerConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


/**
 * Utilities for {@link org.springframework.jdbc.datasource.DataSourceTransactionManager}
 *
 * @author David Hsing
 * @see org.springframework.jdbc.datasource.DataSourceTransactionManager
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JdbcConfigurationUtils {
    public static DataSourceTransactionManager transactionManager(@Nonnull Environment environment, @Nonnull DataSource dataSource, @Nonnull ObjectProvider<TransactionManagerCustomizers> customizers) {
        JdbcTransactionManagerConfiguration configuration = new JdbcTransactionManagerConfiguration();
        return configuration.transactionManager(environment, dataSource, customizers);
    }
}
