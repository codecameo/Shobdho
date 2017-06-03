package bytes.wit.diffutills;

import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.models.Word;

/**
 * Created by Md. Sifat-Ul Haque on 6/3/2017.
 */

public class WordListDiffUtil extends DiffUtil.Callback{

    private List<Word> mOldWords, mNewWords;

    public WordListDiffUtil(List<Word> oldWords, List<Word> newWords) {
        mOldWords = oldWords;
        mNewWords = newWords;
    }

    @Override
    public int getOldListSize() {
        return mOldWords.size();
    }

    @Override
    public int getNewListSize() {
        return mNewWords.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldWords.get(oldItemPosition).getId() == mNewWords.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldWords.get(oldItemPosition).getWord().equals(mNewWords.get(newItemPosition).getWord());
    }
}
