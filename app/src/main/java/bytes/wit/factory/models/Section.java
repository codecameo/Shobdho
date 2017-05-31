package bytes.wit.factory.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class Section {

    @SerializedName("section_id")
    @ColumnInfo(name="section_id")
    public int mSectionId;

    @SerializedName("section_name")
    @ColumnInfo(name="section_name")
    public String mSectionName;

    public int getSectionId() {
        return mSectionId;
    }

    public void setSectionId(int mSectionId) {
        this.mSectionId = mSectionId;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public void setSectionName(String mSectionName) {
        this.mSectionName = mSectionName;
    }
}
