package com.muzi.service;
 
import java.util.Collections;
import java.util.List;
import com.muzi.dao.impl.CategoryDAOImpl;
import com.muzi.dao.impl.RecordDAOImpl;
import com.muzi.entity.Category;
import com.muzi.entity.Record;

 
public class CategoryService {
 
    CategoryDAOImpl categoryDaoImpl = new CategoryDAOImpl();
    RecordDAOImpl recordDaoImpl = new RecordDAOImpl();

    /**
     * 查询出所有的Category，然后根据每种分类，再把分类对应的消费记录总数查出来，
     * 并且设置在对应分类实例的recordNumer上。
     * 最后再根据recordNumer进行倒排序，让消费频率高的分类放在前面。
     * @return
     */
    public List<Category> list() {
        List<Category> cs= categoryDaoImpl.list();
        for (Category c : cs) {
            List<Record> rs = recordDaoImpl.list(c.id);
            c.recordNumber=rs.size();
        }
        Collections.sort(cs,(c1,c2)->c2.recordNumber-c1.recordNumber);
         
        return cs;
    }

    /**
     * 增加一种分类
     * @param name
     */
    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDaoImpl.add(c);
    }

    /**
     * 更新分类
     * @param id
     * @param name
     */
    public void update(int id, String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDaoImpl.update(c);
    }

    /**
     * 删除分类
     * @param id
     */
    public void delete(int id) {
        categoryDaoImpl.delete(id);
    }
 
}