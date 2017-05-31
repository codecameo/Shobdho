package bytes.wit.dpHelper.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.dpHelper.entities.SectionEntity;
import bytes.wit.factory.models.Section;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */
@Dao
public interface SectionDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSections(SectionEntity... sections);

    /*@Query("SELECT * FROM section")
    LiveData<ArrayList<SectionEntity>> getAllSections();*/

    @Query("SELECT * FROM section")
    LiveData<List<Section>> getAllSections();
}
