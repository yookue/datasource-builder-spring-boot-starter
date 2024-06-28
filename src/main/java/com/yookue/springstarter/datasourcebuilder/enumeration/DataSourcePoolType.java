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

package com.yookue.springstarter.datasourcebuilder.enumeration;


import com.yookue.commonplexus.javaseutil.support.ValueEnum;
import com.yookue.springstarter.datasourcebuilder.constant.DataSourcePoolConst;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Enumerations for supported datasource pools
 *
 * @author David Hsing
 */
@AllArgsConstructor
@SuppressWarnings("unused")
public enum DataSourcePoolType implements ValueEnum<String> {
    C3P0(DataSourcePoolConst.C3P0),
    DBCP2(DataSourcePoolConst.DBCP2),
    DRUID(DataSourcePoolConst.DRUID),
    HIKARI(DataSourcePoolConst.HIKARI),
    ORACLE_UCP(DataSourcePoolConst.ORACLE_UCP),
    ORACLE_UCP_XA(DataSourcePoolConst.ORACLE_UCP_XA),
    VIBUR(DataSourcePoolConst.VIBUR),
    TOMCAT(DataSourcePoolConst.TOMCAT);

    @Getter
    private final String value;
}