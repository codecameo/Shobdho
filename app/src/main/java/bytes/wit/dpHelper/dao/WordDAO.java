package bytes.wit.dpHelper.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import bytes.wit.dpHelper.Constants;
import bytes.wit.dpHelper.entities.WordEntity;
import bytes.wit.factory.models.Word;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */
@Dao
public interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllWord(WordEntity... words);

    @Query("SELECT * FROM "+ Constants.WORD_TABLE_NAME+" WHERE section_id = :sectionId")
    LiveData<List<Word>> getWords(int sectionId);

}
