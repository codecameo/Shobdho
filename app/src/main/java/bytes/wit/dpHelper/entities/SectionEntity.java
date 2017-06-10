package bytes.wit.dpHelper.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import bytes.wit.dpHelper.Constants;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */
@Entity(tableName = "section")
public class SectionEntity {

    @PrimaryKey
    @SerializedName("section_id")
    @ColumnInfo(name="section_id")
    public int sectionId;

    @SerializedName("section_name")
    @ColumnInfo(name="section_name")
    public String sectionName;

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

}
