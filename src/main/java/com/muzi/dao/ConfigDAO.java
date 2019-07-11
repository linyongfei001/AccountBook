package com.muzi.dao;

import com.muzi.entity.Config;
import com.muzi.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ConfigDAO {
    int getTotal() ;

    void add(Config config) ;

    void update(Config config);

    void delete(int id);

    Config get(int id) ;

    List<Config> list();

    List<Config> list(int start, int count);

    Config getByKey(String key);
}
