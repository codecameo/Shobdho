package bytes.wit.factory.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class Word implements Serializable{

    private int id;
    private String word;
    private String meaning;
    private String sentence;
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

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }
}
