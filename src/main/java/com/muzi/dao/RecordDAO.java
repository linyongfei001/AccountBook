package com.muzi.dao;

import com.muzi.entity.Record;
import com.muzi.util.DBUtil;
import com.muzi.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface RecordDAO {
    int getTotal() ;

    void add(Record record);

    void update(Record record) ;

    void delete(int id) ;

    Record get(int id) ;

    List<Record> list() ;

    List<Record> list(int start, int count) ;

    List<Record> list(int cid) ;

    List<Record> listToday();

    List<Record> list(java.util.Date day) ;

    List<Record> listThisMonth();

    List<Record> list(java.util.Date start, java.util.Date end) ;
}
