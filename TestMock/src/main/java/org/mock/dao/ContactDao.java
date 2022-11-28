package org.mock.dao;

import model.Contact;

import java.util.List;

public interface ContactDao {
    public String findBYNameById(Integer id);
    public List<String> findNames();

    public Contact findById(Integer id);

    public int getTotalContactName();

}
