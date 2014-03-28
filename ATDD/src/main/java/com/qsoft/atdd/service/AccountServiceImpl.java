package com.qsoft.atdd.service;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.qsoft.atdd.data.dao.AccountDAO;
import com.qsoft.atdd.ui.model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * User: thanhtd
 * Date: 3/12/14
 * Time: 11:20 AM
 */
@EBean
public class AccountServiceImpl
{
    @Bean
    AccountDAO accountDAO;

    public List<Account> getAllUser() throws SQLException
    {
        return accountDAO.findAll();
    }

    public void create(Account account) throws SQLException
    {
        accountDAO.create(account);
    }

    public void update(Account account) throws SQLException
    {
        accountDAO.update(account);
    }

    public Account findByUsernameAndPassword(String username, String password) throws SQLException
    {
        return accountDAO.findByUsernameAndPassword(username, password);
    }
}
