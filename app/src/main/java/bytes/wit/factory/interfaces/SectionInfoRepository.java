package bytes.wit.factory.interfaces;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.models.Section;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public interface SectionInfoRepository {
    public LiveData<List<Section>> getAllSections();
    public Section getSection(int id);
}
