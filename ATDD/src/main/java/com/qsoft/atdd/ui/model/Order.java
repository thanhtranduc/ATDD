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
@DatabaseTable(tableName = "order")
@AdditionalAnnotation.DefaultContentUri(authority = AppContract.AUTHORITY, path = "order")
@AdditionalAnnotation.DefaultContentMimeTypeVnd(name = AppContract.MIME_TYPE_VND, type = "order")
public class Order
{
    @DatabaseField(columnName = BaseColumns._ID, generatedId = true)
    @AdditionalAnnotation.DefaultSortOrder
    Long id;
    @DatabaseField
    Long userId;
    @DatabaseField
    Long invoiceNumber;
    @DatabaseField
    Long amount;
    @DatabaseField
    String description;

    public Order()
    {
    }

    public ContentValues getContentValues()
    {
        ContentValues values = new ContentValues();
        values.put(OrderContract.USERID, userId);
        values.put(OrderContract.INVOICENUMBER, invoiceNumber);
        values.put(OrderContract.AMOUNT, amount);
        values.put(OrderContract.DESCRIPTION, description);
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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getInvoiceNumber()
    {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Order))
        {
            return false;
        }

        Order order = (Order) o;

        if (userId != null ? !userId.equals(order.userId) : order.userId != null)
        {
            return false;
        }
        if (invoiceNumber != null ? !invoiceNumber.equals(order.invoiceNumber) : order.invoiceNumber != null)
        {
            return false;
        }
        if (amount != null ? !amount.equals(order.amount) : order.amount != null)
        {
            return false;
        }
        if (description != null ? !description.equals(order.description) : order.description != null)
        {
            return false;
        }
        return true;
    }
}
