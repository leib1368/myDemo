package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/10/13 19:56
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DataSourceTransactionManager transactionManager;

    public void update(User user) {
         userDAO.update(user);
    }

    @Transactional
    public void transaction1() {
        transaction2(); // transaction2 事务无效
    }

    @Transactional
    public void transaction2() {
        System.out.println("1");
    }

    @Transactional(timeout = -1,readOnly = false)
    public void test() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        transactionManager.getTransaction(definition);

        //boolean save = update(user);
        if(true) {
            transactionManager.commit(status);
        } else {
            transactionManager.rollback(status);
        }
    }
    public void update2(User user) {
        userDAO.update(user);
    }

    public User finById(int id) {
        return userDAO.finById(id);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }
}
