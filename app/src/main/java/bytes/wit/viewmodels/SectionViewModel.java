package bytes.wit.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.WordFactory;
import bytes.wit.factory.models.Section;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */
public class SectionViewModel extends AndroidViewModel {

    private LiveData<List<Section>> sections;
    private Application mApplication;

    public SectionViewModel(Application application) {
        super(application);
        mApplication = application;
    }

    public LiveData<List<Section>> getSections() {
        if (sections == null) {
            sections = loadSection();
        }
        return sections;
    }

    private LiveData<List<Section>> loadSection() {
        return WordFactory.getWordFactoryInstance().getSectionProvider(mApplication).getAllSections();
    }
}
