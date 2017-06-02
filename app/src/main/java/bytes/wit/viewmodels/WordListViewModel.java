package bytes.wit.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.WordFactory;
import bytes.wit.factory.models.Word;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class WordListViewModel extends AndroidViewModel {

    private LiveData<List<Word>> mLiveWords;
    private Application mApplication;

    public WordListViewModel(Application application) {
        super(application);
        mApplication = application;
    }

    public LiveData<List<Word>> getWords(int sectionId){

        if(mLiveWords==null){
            mLiveWords = loadWords(sectionId);
        }
        return mLiveWords;
    }

    private LiveData<List<Word>> loadWords(int sectionId) {
        return WordFactory.getWordFactoryInstance().getWordListProvider(mApplication).getWordForSection(sectionId);
    }
}
