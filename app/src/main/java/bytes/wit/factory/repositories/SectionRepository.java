package bytes.wit.factory.repositories;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.interfaces.SectionInfoRepository;
import bytes.wit.factory.models.Section;
import bytes.wit.services.SectionInsertService;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class SectionRepository extends BaseRepository implements SectionInfoRepository {

    private MediatorLiveData<List<Section>> mSectionLive = new MediatorLiveData<>();

    public SectionRepository(Context context) {
        super(context);
    }

    @Override
    public LiveData<List<Section>> getAllSections() {
        final LiveData<List<Section>> sections = mWordDB.sectionDAO().getAllSections();

        mSectionLive.addSource(sections, new Observer<List<Section>>() {
            @Override
            public void onChanged(@Nullable List<Section> sectionList) {
            if(sectionList == null || sectionList.isEmpty()) {
                mContext.startService(new Intent(mContext, SectionInsertService.class));
            }else{
                mSectionLive.removeSource(sections);
                mSectionLive.setValue(sectionList);
            }
            }
        });
        return mSectionLive;
    }

    @Override
    public Section getSection(int id) {
        return null;
    }

}
