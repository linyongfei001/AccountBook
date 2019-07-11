package com.muzi.service;

import com.muzi.dao.impl.ConfigDAOImpl;
import com.muzi.entity.Config;

/**
 * ConfigService 设置业务类，这个类是监听器直接调用的类，然后再通过ConfigService去调用ConfigDAO。
 *
 * 为什么需要一个业务类呢？ DAO是直接和数据库打交道的，在和数据库打交道之前，
 * 还需要对数据进行预处理，这些就可以放在业务类里进行。
 */
public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";
 
    static ConfigDAOImpl dao= new ConfigDAOImpl();
    static{
        init();
    }

    /**
     * 1. 初始化 init()
     * 因为设置信息里有两个数据，一个是预算，一个是Mysql路径。
     * 这两个信息，无论如何都应该是存在数据库中的。 所以会调用init把他们俩初始化。
     */
    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    /**
     * init(String key, String value) 方法
     * 首先根据key去查找，如果不存在，就使用value的值插入一条数据。
     * @param key
     * @param value
     */
    private static void init(String key, String value) {
         
        Config config= dao.getByKey(key);
        if(config==null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }
 
    public String get(String key) {
        Config config= dao.getByKey(key);
        return config.getValue();
    }
     
    public void update(String key, String value){
        Config config= dao.getByKey(key);
        config.setValue(value);
        dao.update(config);     
    }
     
    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
     
}