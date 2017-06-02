package bytes.wit.dpHelper.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import bytes.wit.dpHelper.Constants;
import bytes.wit.dpHelper.dao.SectionDAO;
import bytes.wit.dpHelper.dao.WordDAO;
import bytes.wit.dpHelper.entities.LearningTechniqueEntity;
import bytes.wit.dpHelper.entities.SectionEntity;
import bytes.wit.dpHelper.entities.WordEntity;
import bytes.wit.dpHelper.entities.WordLearningTechniqueIndex;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */
@Database(entities = {  SectionEntity.class,
                        WordEntity.class,
                        WordLearningTechniqueIndex.class,
                        LearningTechniqueEntity.class},
            version = 1, exportSchema = false)
public abstract class WordDB extends RoomDatabase{
    private static WordDB INSTANCE;

    public abstract SectionDAO sectionDAO();
    public abstract WordDAO wordDAO();



    public static WordDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDB.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDB.class, Constants.DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
}
