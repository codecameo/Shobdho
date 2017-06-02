package bytes.wit.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import bytes.wit.factory.WordFactory;
import bytes.wit.factory.models.Section;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */
public class SectionViewModel extends AndroidViewModel {

    private LiveData<List<Section>> mLiveSections;
    private Application mApplication;

    public SectionViewModel(Application application) {
        super(application);
        mApplication = application;
    }

    public LiveData<List<Section>> getLiveSections() {
        if (mLiveSections == null) {
            mLiveSections = loadSection();
        }
        return mLiveSections;
    }

    private LiveData<List<Section>> loadSection() {
        return WordFactory.getWordFactoryInstance().getSectionProvider(mApplication).getAllSections();
    }
}
