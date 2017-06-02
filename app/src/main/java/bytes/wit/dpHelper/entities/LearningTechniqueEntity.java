package bytes.wit.dpHelper.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

@Entity
public class LearningTechniqueEntity {

    @PrimaryKey
    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
