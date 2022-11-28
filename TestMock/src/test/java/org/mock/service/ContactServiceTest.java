package org.mock.service;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mock.dao.ContactDao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ContactServiceTest {



    @Test
    public void testGetNameById(){

        //becuase ContactDao had no implementation for interface, we did create a mock, but we have no implementation because it is dummy
        ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
        //set behaviour for mack daoproxy (implementation)
        //if someone call find by name by id 101 then return forogh
        EasyMock.expect(daoProxy.findBYNameById(101))
                .andReturn("Forogh");

        //reply the behaviour
        EasyMock.replay(daoProxy);
//we want to test the service
        ContactServiceImpl service = new ContactServiceImpl();

        //service talk to mock dao proxy
        service.setiContactDao(daoProxy);

        //we need to inject implementation object
        //we dont have implementation object, we are using mocking
        String name=service.getNameById(101);
        assertNotNull(name);
    }


    @Test
    public void testGetName_01(){
        List<String> names = new ArrayList<>();
        names.add("f");
        names.add("s");
        names.add("sh");


        List<String> names2 = new ArrayList<>();
        names2.add("55");
        names2.add("555");
        names2.add("55555");
        names2.add("99994");

        //creating mock class(object)
        ContactDao deoProxy=EasyMock.createMock(ContactDao.class);
        //set behavior for mock object
        //we have to set this before using it in service
        EasyMock.expect(deoProxy.findNames()).andReturn(names2);


        EasyMock.replay(deoProxy);

        //create a service object
        //which class we want to test
        ContactServiceImpl service = new ContactServiceImpl();

        //injecting proxy obj into target
        service.setiContactDao(deoProxy);

        List<String> contactNames =service.getAllContactName();

        //validation
        assertNotNull(contactNames);





    }



    @Test
    public void testGetName_02(){
        List<String> names = new ArrayList<>();
        names.add("f");
        names.add("s");
        names.add("sh");

        //creating mock class(object)
        ContactDao deoProxy=EasyMock.createMock(ContactDao.class);
        //set behavior for mock object
        //we have to set this before using it in service
        EasyMock.expect(deoProxy.getTotalContactName()).andReturn(2);


        EasyMock.replay(deoProxy);

        //create a service object
        //which class we want to test
        ContactServiceImpl service = new ContactServiceImpl();

        //injecting proxy obj into target
        service.setiContactDao(deoProxy);

        int contactNames =service.getTotalContactName();

        //validation
        assertNotNull(contactNames);





    }




    @Test
    public void  getContactById(){


    }
}
