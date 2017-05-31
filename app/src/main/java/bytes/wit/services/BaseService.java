package bytes.wit.services;

import android.app.IntentService;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import bytes.wit.dpHelper.Constants;
import bytes.wit.dpHelper.database.WordDB;

/**
 * Created by Md. Sifat-Ul Haque on 5/31/2017.
 */

public class BaseService extends IntentService {

    protected Gson mGson;
    protected WordDB mWordDB;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BaseService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        mGson = new Gson();
        mWordDB = WordDB.getDatabase(getApplicationContext());
    }
}
