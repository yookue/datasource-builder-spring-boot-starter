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

package com.yookue.springstarter.datasourcebuilder.property;


import java.util.Properties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for Oracle UCP
 *
 * @author David Hsing
 * @see oracle.ucp.jdbc.PoolDataSourceImpl
 */
@Getter
@Setter
@ToString
public class OracleUcpDataSourceProperties extends DataSourceProperties {
    private Properties pdbRoles = new Properties();
    private Boolean disableAPI;
    private String roleName;
}
