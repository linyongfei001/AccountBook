package com.muzi.dao;

import com.muzi.entity.Category;

import java.util.List;

public interface CategoryDAO {
     int getTotal();

     void add(Category category);

     void update(Category category);

    void delete(int id);

    Category get(int id);

    List<Category> list();

    List<Category> list(int start, int count);

}
