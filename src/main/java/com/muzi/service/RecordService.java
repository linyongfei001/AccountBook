package com.muzi.service;
 
import com.muzi.dao.RecordDAO;
import com.muzi.dao.impl.RecordDAOImpl;
import com.muzi.entity.Category;
import com.muzi.entity.Record;

import java.util.Date;

public class RecordService {
    RecordDAOImpl recordDao = new RecordDAOImpl();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        recordDao.add(r);
    }
}