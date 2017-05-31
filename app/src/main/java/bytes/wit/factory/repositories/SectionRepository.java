package bytes.wit.factory.repositories;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;

import java.util.List;

import bytes.wit.factory.interfaces.SectionInfoRepository;
import bytes.wit.factory.models.Section;
import bytes.wit.services.SectionInsertService;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class SectionRepository extends BaseRepository implements SectionInfoRepository {

    public SectionRepository(Context context) {
        super(context);
    }

    @Override
    public LiveData<List<Section>> getAllSections() {
        LiveData<List<Section>> sections = mWordDB.sectionDAO().getAllSections();

        // Fetching Section info from json file
        if(sections.getValue() == null || sections.getValue().isEmpty()) {
            mContext.startService(new Intent(mContext, SectionInsertService.class));
        }
        return sections;
    }

    @Override
    public Section getSection(int id) {
        return null;
    }
}
