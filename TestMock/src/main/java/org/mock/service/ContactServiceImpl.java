package org.mock.service;

import exceptions.NoDataFoundException;
import model.Contact;
import org.mock.dao.ContactDao;

import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService{

    private ContactDao iContactDao;


    //setter contactDao to inject
    public void setiContactDao(ContactDao iContactDao) {
        this.iContactDao = iContactDao;
    }

    public ContactDao getiContactDao() {
        return iContactDao;
    }

    @Override
    public String getNameById(Integer id) {
       String name=iContactDao.findBYNameById(id);
       String foramatName=name.toUpperCase();
        return foramatName;
    }

    @Override
    public List<String> getAllContactName(){
        List<String> names = iContactDao.findNames().stream().filter(p -> p.length()>3).collect(Collectors.toList());
        if(!names.isEmpty()){
            return names;
        }
        return null;
    }

    @Override
    public int getTotalContactName(){
        List<String> names = iContactDao.findNames();
        return names.size();
    }


    @Override
    public Contact getContactById(Integer id) {
        return null;
    }
    /*

    @Override
    public Contact getContactById(Integer id){
       Contact contact =  iContactDao.findById(id);
       if(contact==null){
           throw new NoDataFoundException();
       }
        return contact;
    }

     */
}
