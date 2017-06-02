package bytes.wit.services;

import android.content.Intent;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import bytes.wit.dpHelper.entities.SectionEntity;
import bytes.wit.dpHelper.entities.WordEntity;
import bytes.wit.shobdho.R;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class WordInsertService extends BaseService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public WordInsertService() {
        super("WordInsertService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        super.onHandleIntent(intent);

        InputStream is = getResources().openRawResource(R.raw.words);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        WordEntity[] words = mGson.fromJson(jsonString, WordEntity[].class);
        mWordDB.wordDAO().insertAllWord(words);
    }
}
