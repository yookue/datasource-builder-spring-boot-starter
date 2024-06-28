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
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yookue.springstarter.datasourcebuilder.property.C3p0DataSourceProperties;


/**
 * {@link org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration} for C3P0
 *
 * @author David Hsing
 */
public abstract class C3p0DataSourceBuilder extends AbstractDataSourceBuilder {
    public static ComboPooledDataSource buildDataSource(@Nonnull C3p0DataSourceProperties properties) {
        ComboPooledDataSource dataSource = createDataSource(properties, ComboPooledDataSource.class);
        setDataSourceProperties(dataSource, properties);
        return dataSource;
    }
}
