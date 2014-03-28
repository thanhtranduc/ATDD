package com.qsoft.atdd.ui.model;

import android.content.ContentValues;
import android.provider.BaseColumns;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.qsoft.atdd.data.provider.AppContract;
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
    String displayName;
    @DatabaseField
    String userName;
    @DatabaseField
    String password;

    public Account()
    {
    }

    public Account(String displayName, String userName, String password)
    {
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
    }

    public ContentValues getContentValues()
    {
        ContentValues values = new ContentValues();
        values.put(AccountContract.DISPLAYNAME, displayName);
        values.put(AccountContract.USERNAME, userName);
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

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

        if (displayName != null ? !displayName.equals(account.displayName) : account.displayName != null)
        {
            return false;
        }
        if (userName != null ? !userName.equals(account.userName) : account.userName != null)
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
