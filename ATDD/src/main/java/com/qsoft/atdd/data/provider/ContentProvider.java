package com.qsoft.atdd.data.provider;

import com.qsoft.atdd.common.helper.GenericDatabaseHelper;
import com.qsoft.atdd.ui.model.Account;
import com.qsoft.atdd.ui.model.AccountContract;
import com.qsoft.atdd.ui.model.Order;
import com.qsoft.atdd.ui.model.OrderContract;
import com.tojc.ormlite.android.OrmLiteSimpleContentProvider;
import com.tojc.ormlite.android.framework.MatcherController;
import com.tojc.ormlite.android.framework.MimeTypeVnd;

/**
 * User: thanhtd
 * Date: 3/5/14
 * Time: 9:32 AM
 */
public class ContentProvider extends OrmLiteSimpleContentProvider<GenericDatabaseHelper>
{

    @Override
    protected Class<GenericDatabaseHelper> getHelperClass()
    {
        return GenericDatabaseHelper.class;
    }

    @Override
    public boolean onCreate()
    {
        setMatcherController(new MatcherController()
                .add(Account.class, MimeTypeVnd.SubType.DIRECTORY, "", AccountContract.CONTENT_URI_PATTERN_MANY)
                .add(Account.class, MimeTypeVnd.SubType.ITEM, "#", AccountContract.CONTENT_URI_PATTERN_ONE)

                .add(Order.class, MimeTypeVnd.SubType.DIRECTORY, "", OrderContract.CONTENT_URI_PATTERN_MANY)
                .add(Order.class, MimeTypeVnd.SubType.ITEM, "#", OrderContract.CONTENT_URI_PATTERN_ONE)
        );
        return true;
    }
}
