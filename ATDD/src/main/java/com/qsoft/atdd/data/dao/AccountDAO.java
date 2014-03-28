package com.qsoft.atdd.data.dao;

import android.content.ContentResolver;
import android.content.Context;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.qsoft.atdd.common.helper.HolderSingletonFactory;
import com.qsoft.atdd.ui.model.Account;
import com.qsoft.atdd.ui.model.AccountContract;

import java.sql.SQLException;
import java.util.List;

/**
 * User: thanhtd
 * Date: 3/12/14
 * Time: 11:21 AM
 */
@EBean
public class AccountDAO
{
    @RootContext
    Context context;
    ContentResolver contentResolver;

    @Bean
    HolderSingletonFactory singletonDatabaseHelp;

    public AccountDAO(Context context)
    {
        this.context = context;
        contentResolver = context.getContentResolver();
    }

    public List<Account> findAll() throws SQLException
    {
        Dao<Account, Long> accountDao = singletonDatabaseHelp.getGenericDatabaseHelper().getAccountDao();
        QueryBuilder<Account, Long> queryBuilder = accountDao.queryBuilder();
        PreparedQuery<Account> preparedQueryAccount = queryBuilder.prepare();
        return accountDao.query(preparedQueryAccount);
    }

    public void create(Account account) throws SQLException
    {
        Dao<Account, Long> accountDao = singletonDatabaseHelp.getGenericDatabaseHelper().getAccountDao();
        accountDao.createIfNotExists(account);
    }

    public void update(Account account) throws SQLException
    {
        Dao<Account, Long> accountDao = singletonDatabaseHelp.getGenericDatabaseHelper().getAccountDao();
        accountDao.update(account);
    }

    public Account findByUsernameAndPassword(String username, String password) throws SQLException
    {
        Dao<Account, Long> accountDao = singletonDatabaseHelp.getGenericDatabaseHelper().getAccountDao();
        QueryBuilder<Account, Long> queryBuilder = accountDao.queryBuilder();
        queryBuilder.where()
                .eq(AccountContract.USERNAME, username)
                .and()
                .eq(AccountContract.PASSWORD, password);
        queryBuilder.limit(1l);
        PreparedQuery<Account> preparedQueryAccount = queryBuilder.prepare();
        return accountDao.queryForFirst(preparedQueryAccount);
    }
}
