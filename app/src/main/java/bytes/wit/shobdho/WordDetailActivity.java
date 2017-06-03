package bytes.wit.shobdho;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import bytes.wit.factory.models.Word;
import bytes.wit.shobdho.databinding.ActivityWordDetailBinding;

/**
 * Created by Md. Sifat-Ul Haque on 6/3/2017.
 */

public class WordDetailActivity extends BaseActivity {

    private ActivityWordDetailBinding mActivityWordDetailBinding;
    public static final String KEY_WORD_DETAIL = "word_detail";
    private Word mWord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityWordDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_word_detail);
        setupToolbar(mActivityWordDetailBinding.wordDetailToolbar.getId());
        extractData();
        mActivityWordDetailBinding.setWord(mWord);
    }

    private void extractData() {
        mWord = (Word) getIntent().getSerializableExtra(KEY_WORD_DETAIL);
    }
}
