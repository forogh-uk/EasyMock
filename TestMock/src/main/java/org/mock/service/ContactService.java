package org.mock.service;

import model.Contact;

import java.util.List;

public interface ContactService {
    public String getNameById(Integer id);
    public List<String> getAllContactName();

    public int getTotalContactName();
    public Contact getContactById(Integer id);
}
