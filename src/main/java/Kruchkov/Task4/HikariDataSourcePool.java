package Kruchkov.Task4;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;


public class HikariDataSourcePool extends HikariDataSource {
    private  HikariConfig config; 

@Autowired
    public HikariDataSourcePool(HikariConfig hikariConfig) {
        super(hikariConfig);
        this.config = hikariConfig;


    }
/*
    public Connection getConnection() throws SQLException {
        return this.getConnection();
    }

 */
}
