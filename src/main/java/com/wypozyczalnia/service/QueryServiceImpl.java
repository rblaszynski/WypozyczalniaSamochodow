package com.wypozyczalnia.service;

import com.wypozyczalnia.dao.JDBCDriver;
import org.springframework.stereotype.Service;

@Service("queryService")
public class QueryServiceImpl implements QueryService {

    @Override
    public String generateRaport(String query) {
        JDBCDriver jdbcDriver = new JDBCDriver();
        return jdbcDriver.generateRaport(query);
    }
}
