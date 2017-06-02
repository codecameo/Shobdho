package bytes.wit.factory.interfaces;

import android.arch.lifecycle.LiveData;

import java.util.List;

import bytes.wit.factory.models.Word;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public interface WordListRespository {
    LiveData<List<Word>> getWordForSection(int sectionId);
}
