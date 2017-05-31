package bytes.wit.factory.repositories;

import android.content.Context;

import bytes.wit.dpHelper.database.WordDB;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class BaseRepository {

    protected WordDB mWordDB;
    protected Context mContext;

    public BaseRepository(Context context){
        mWordDB = WordDB.getDatabase(context);
        mContext = context;
    }

}
