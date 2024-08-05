package Kruchkov.Task4;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();


        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?");

        config.setUsername("student");

        config.setPassword("student");



        config.setMaximumPoolSize(10);

        config.setAutoCommit(false);

        config.addDataSourceProperty("cachePrepStmts", "true");

        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return config;

    }

    @Bean @DependsOn("hikariConfig")
    public HikariDataSourcePool hikariDataSourcePool(HikariConfig hikariConfig) {
        return new HikariDataSourcePool(hikariConfig);
    }

    /*
    public String tableName() {
        return new String();
    }

     */

    @Bean
    public User user( /*String username*/) {
        return new User();
    }



    @Bean
    public UserDAO userDAO(HikariDataSourcePool hikariDataSourcePool){
        return new UserDAO(hikariDataSourcePool);
    }

    @Bean @DependsOn("userDAO")
    public UserService userService(UserDAO userDAO) {
        return new UserService(userDAO);
    }
}
