# Datasource Builder Spring Boot Starter

Spring Boot application integrates `DataSource` quickly.

## Quickstart

- Import dependencies

```xml
      <dependency>
          <groupId>com.yookue.springstarter</groupId>
          <artifactId>datasource-builder-spring-boot-starter</artifactId>
          <version>LATEST</version>
      </dependency>
```

> By default, this starter will auto take effect, you can turn it off by `spring.datasource-builder.enabled = false`

- Configure your beans with a `DataSourceBuilder` bean by constructor or `@Autowired`/`@Resource` annotation, then you can create beans with it as following:

| Method Return                | Method Name            |
|------------------------------|------------------------|
| DataSourceProperties         | dataSourceProperties   |
| DataSource                   | dataSource             |
| DataSource                   | xaDataSource           |
| DataSourceTransactionManager | jdbcTransactionManager |
| JpaTransactionManager        | jpaTransactionManager  |

- This starter supports the most popular data source pools in the word, including
  - c3p0
  - dbcp2
  - druid
  - hikari
  - oracle ucp
  - tomcat
  - vibur

## Document

- Github: https://github.com/yookue/datasource-builder-spring-boot-starter

## Requirement

- jdk 1.8+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to Yookue](https://yookue.com/public/donate) to support the development.

## Website

- Yookue: https://yookue.com
