package bytes.wit.factory.repositories;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.interfaces.WordListRespository;
import bytes.wit.factory.models.Word;
import bytes.wit.services.SectionInsertService;
import bytes.wit.services.WordInsertService;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class WordListRepository extends BaseRepository implements WordListRespository{

    public WordListRepository(Context context) {
        super(context);
    }

    @Override
    public LiveData<List<Word>> getWordForSection(int sectionId) {

        LiveData<List<Word>> mWords = mWordDB.wordDAO().getWords(sectionId);
        if(mWords.getValue() == null || mWords.getValue().isEmpty()){
            mContext.startService(new Intent(mContext, WordInsertService.class));
        }

        return mWords;
    }
}
