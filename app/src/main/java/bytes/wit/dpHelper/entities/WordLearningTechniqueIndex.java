package bytes.wit.dpHelper.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = WordEntity.class,
                parentColumns = "id",
                childColumns = "word_id"),

        @ForeignKey(entity = LearningTechniqueEntity.class,
                parentColumns = "id",
                childColumns = "technique_id")},
        primaryKeys = {"technique_id", "word_id"})
public class WordLearningTechniqueIndex {
    public int word_id;
    public int technique_id;

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public int getTechnique_id() {
        return technique_id;
    }

    public void setTechnique_id(int technique_id) {
        this.technique_id = technique_id;
    }
}
