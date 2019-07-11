package com.muzi.service;

import com.muzi.dao.RecordDAO;
import com.muzi.dao.impl.RecordDAOImpl;
import com.muzi.entity.Record;
import com.muzi.gui.page.SpendPage;
import com.muzi.util.DateUtil;
import java.util.List;

/**
 * SpendService消费一览业务类的getSpendPage()方法，返回SpendPage 用于界面显示。
 *
 * getSpendPage()方法中的代码说明都在注释中
 */
public class SpendService {

    public SpendPage getSpendPage() {
        RecordDAOImpl dao = new RecordDAOImpl();
        // 本月数据
        List<Record> thisMonthRecords = dao.listThisMonth();
        // 今日数据
        List<Record> toDayRecords = dao.listToday();
        // 本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        // 预算
        int monthBudget = new ConfigService().getIntBudget();

        // 统计本月消费
        for (Record record : thisMonthRecords) {
            monthSpend += record.getSpend();
        }

        // 统计今日消费
        for (Record record : toDayRecords) {
            todaySpend += record.getSpend();
        }
        // 计算日均消费
        avgSpendPerDay = monthSpend / thisMonthTotalDay;
        // 计算本月剩余
        monthAvailable = monthBudget - monthSpend;

        // 距离月末
        monthLeftDay = DateUtil.thisMonthLeftDay();

        // 计算日均可用
        dayAvgAvailable = monthAvailable / monthLeftDay;

        // 计算使用比例
        usagePercentage = monthSpend * 100 / monthBudget;

        // 根据这些信息，生成SpendPage对象

        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
                usagePercentage);
    }
}