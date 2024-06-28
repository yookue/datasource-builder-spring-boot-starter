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

package com.yookue.springstarter.datasourcebuilder.util;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.core.io.ResourceLoader;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.StringUtils;


/**
 * Utilities for Spring Data JPA configuration
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JpaConfigurationUtils {
    @Nonnull
    public static PersistenceUnitManager defaultPersistenceUnitManager(@Nullable String persistenceUnit, @Nullable String persistenceUnitRootLocation, @Nullable DataSource dataSource, @Nullable String packageToScan, @Nullable String mappingResource, @Nullable String xmlLocation, boolean jta, @Nullable ResourceLoader resourceLoader, @Nullable SharedCacheMode cacheMode, @Nullable ValidationMode validationMode, @Nullable PersistenceUnitPostProcessor postProcessor) {
        return defaultPersistenceUnitManager(persistenceUnit, persistenceUnitRootLocation, dataSource, (StringUtils.hasText(packageToScan) ? new String[]{packageToScan} : null), (StringUtils.hasText(mappingResource) ? new String[]{mappingResource} : null), (StringUtils.hasText(xmlLocation) ? new String[]{xmlLocation} : null), jta, resourceLoader, cacheMode, validationMode, (postProcessor == null ? null : new PersistenceUnitPostProcessor[]{postProcessor}));
    }

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    public static PersistenceUnitManager defaultPersistenceUnitManager(@Nullable String persistenceUnit, @Nullable String persistenceUnitRootLocation, @Nullable DataSource dataSource, @Nullable String[] packagesToScan, @Nullable String[] mappingResources, @Nullable String[] xmlLocations, boolean jta, @Nullable ResourceLoader resourceLoader, @Nullable SharedCacheMode cacheMode, @Nullable ValidationMode validationMode, @Nullable PersistenceUnitPostProcessor[] postProcessors) {
        DefaultPersistenceUnitManager manager = new DefaultPersistenceUnitManager();
        manager.setDefaultPersistenceUnitName(persistenceUnit);
        manager.setDefaultPersistenceUnitRootLocation(persistenceUnitRootLocation);
        if (jta) {
            manager.setDefaultJtaDataSource(dataSource);
        } else {
            manager.setDefaultDataSource(dataSource);
        }
        manager.setPackagesToScan(packagesToScan);
        manager.setMappingResources(mappingResources);
        if (xmlLocations != null) {
            manager.setPersistenceXmlLocations(xmlLocations);
        }
        if (resourceLoader != null) {
            manager.setResourceLoader(resourceLoader);
        }
        manager.setSharedCacheMode(cacheMode);
        manager.setValidationMode(validationMode);
        manager.setPersistenceUnitPostProcessors(postProcessors);
        manager.afterPropertiesSet();
        return manager;
    }

    @Nonnull
    public static EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter(@Nonnull JpaProperties properties) {
        EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        if (properties.getDatabase() != null) {
            adapter.setDatabase(properties.getDatabase());
        }
        adapter.setDatabasePlatform(properties.getDatabasePlatform());
        adapter.setGenerateDdl(properties.isGenerateDdl());
        adapter.setShowSql(properties.isShowSql());
        return adapter;
    }

    @Nonnull
    public static HibernateJpaVendorAdapter hibernateJpaVendorAdapter(@Nonnull JpaProperties properties) {
        return hibernateJpaVendorAdapter(properties, false);
    }

    /**
     * @see org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration#jpaVendorAdapter
     */
    @Nonnull
    public static HibernateJpaVendorAdapter hibernateJpaVendorAdapter(@Nonnull JpaProperties properties, boolean prepareConnection) {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        if (properties.getDatabase() != null) {
            adapter.setDatabase(properties.getDatabase());
        }
        adapter.setDatabasePlatform(properties.getDatabasePlatform());
        adapter.setGenerateDdl(properties.isGenerateDdl());
        adapter.setShowSql(properties.isShowSql());
        adapter.setPrepareConnection(prepareConnection);
        return adapter;
    }

    @Nonnull
    public static JpaTransactionManager jpaTransactionManager(@Nonnull ObjectProvider<TransactionManagerCustomizers> customizers) {
        return jpaTransactionManager(null, customizers);
    }

    @Nonnull
    public static JpaTransactionManager jpaTransactionManager(@Nullable EntityManagerFactory factory, @Nonnull ObjectProvider<TransactionManagerCustomizers> customizers) {
        JpaTransactionManager transactionManager = (factory != null) ? new JpaTransactionManager(factory) : new JpaTransactionManager();
        customizers.ifAvailable(customizer -> customizer.customize(transactionManager));
        return transactionManager;
    }
}
