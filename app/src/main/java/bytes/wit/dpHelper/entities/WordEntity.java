package bytes.wit.dpHelper.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.dpHelper.Constants;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

@Entity(tableName = Constants.WORD_TABLE_NAME, foreignKeys = {
                    @ForeignKey(entity = SectionEntity.class,
                    parentColumns = "section_id",
                    childColumns = "section_id")},
        indices = {@Index("id")})
public class WordEntity {

    @PrimaryKey
    private int id;
    private String word;
    private String meaning;
    private String sentence;
    private int section_id;
    private String part_of_speech;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }
}
