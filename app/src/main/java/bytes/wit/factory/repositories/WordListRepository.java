package bytes.wit.factory.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.interfaces.WordListRespository;
import bytes.wit.factory.models.Section;
import bytes.wit.factory.models.Word;
import bytes.wit.services.SectionInsertService;
import bytes.wit.services.WordInsertService;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class WordListRepository extends BaseRepository implements WordListRespository{

    private MediatorLiveData<List<Word>> mWordsLive = new MediatorLiveData<>();

    public WordListRepository(Context context) {
        super(context);
    }

    @Override
    public LiveData<List<Word>> getWordForSection(int sectionId) {
        final LiveData<List<Word>> words = mWordDB.wordDAO().getWords(sectionId);

        mWordsLive.addSource(words, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> wordList) {
                if(wordList == null || wordList.isEmpty()) {
                    mContext.startService(new Intent(mContext, WordInsertService.class));
                }else{
                    mWordsLive.removeSource(words);
                    mWordsLive.setValue(wordList);
                }
            }
        });
        return mWordsLive;
    }
}
