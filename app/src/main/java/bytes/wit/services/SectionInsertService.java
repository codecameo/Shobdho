package bytes.wit.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import bytes.wit.dpHelper.entities.SectionEntity;
import bytes.wit.factory.models.Section;
import bytes.wit.shobdho.R;

/**
 * Created by Md. Sifat-Ul Haque on 5/31/2017.
 */

public class SectionInsertService extends BaseService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public SectionInsertService() {
        super("SectionInsertService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        super.onHandleIntent(intent);

        InputStream is = getResources().openRawResource(R.raw.sections);
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
        SectionEntity[] sections = mGson.fromJson(jsonString, SectionEntity[].class);
        mWordDB.sectionDAO().insertSections(sections);
    }
}
