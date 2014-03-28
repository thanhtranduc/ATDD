package com.qsoft.atdd.ui.model;

import android.content.ContentValues;
import android.provider.BaseColumns;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.qsoft.atdd.provider.AppContract;
import com.tojc.ormlite.android.annotation.AdditionalAnnotation;

/**
 * User: thanhtd
 * Date: 3/5/14
 * Time: 9:15 AM
 */
@AdditionalAnnotation.Contract
@DatabaseTable(tableName = "account")
@AdditionalAnnotation.DefaultContentUri(authority = AppContract.AUTHORITY, path = "account")
@AdditionalAnnotation.DefaultContentMimeTypeVnd(name = AppContract.MIME_TYPE_VND, type = "account")
public class Account
{
    @DatabaseField(columnName = BaseColumns._ID, generatedId = true)
    @AdditionalAnnotation.DefaultSortOrder
    Long id;
    @DatabaseField
    Long username;
    @DatabaseField
    Long password;

    public Account()
    {
    }

    public ContentValues getContentValues()
    {
        ContentValues values = new ContentValues();
        values.put(AccountContract.USERNAME, username);
        values.put(AccountContract.PASSWORD, password);
        return values;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getPassword()
    {
        return password;
    }

    public void setPassword(Long password)
    {
        this.password = password;
    }

    public Long getUsername()
    {
        return username;
    }

    public void setUsername(Long username)
    {
        this.username = username;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Account))
        {
            return false;
        }

        Account account = (Account) o;

        if (username != null ? !username.equals(account.username) : account.username != null)
        {
            return false;
        }
        if (password != null ? !password.equals(account.password) : account.password != null)
        {
            return false;
        }
        return true;
    }
}
