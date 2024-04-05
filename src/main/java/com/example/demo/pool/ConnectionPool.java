package com.example.demo.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    // 8 const
    private static ConnectionPool instance;
    ;
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(8);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(8);


    static {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            //Class.FormName("org.postgresql.Driver()");
            //} catch (ClassNotFoundException) {
        } catch (SQLException e) {
            throw  new ExceptionInInitializerError(e);
        }
    }


    private ConnectionPool() {
        String url = "jdbc:postgresql://localhost:5432/java_task1";
        Properties prop = new Properties();
        prop.put("user", "postgres");
        prop.put("password", "220073dsi");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("serverSsCert", "classpath:server.crt");

        for (int i = 0; i < 8; i++) {

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, prop);
            } catch (SQLException e) {
                throw  new ExceptionInInitializerError(e.getMessage());
            }
            free.add(connection);

        }
    }

    public static ConnectionPool getInstance() {

        instance = new ConnectionPool();

        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = free.take();
            used.put(connection);

        } catch (InterruptedException e) {
            // log
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
            // log
            Thread.currentThread().interrupt();
        }

    }
    //deregisterDriver

    public void destroyPool() {
        for (int i = 0; i < 8 ; i++) {
            try {
                free.take().close();
            } catch (SQLException | InterruptedException e) {
               /// log  e.printStackTrace();
            }
        }
    }

}
