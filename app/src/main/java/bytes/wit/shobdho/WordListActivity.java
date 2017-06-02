package bytes.wit.shobdho;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import bytes.wit.adapters.SectionAdapter;
import bytes.wit.adapters.WordListAdapter;
import bytes.wit.factory.models.Word;
import bytes.wit.shobdho.databinding.ActivityWordListBinding;
import bytes.wit.viewmodels.SectionViewModel;
import bytes.wit.viewmodels.WordListViewModel;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */

public class WordListActivity extends LifecycleActivity {

    private ActivityWordListBinding mWordListBinding;
    private WordListAdapter mWordAdapter;
    private WordListViewModel model;
    public static final String KEY_SECTION_ID = "section_id";
    private int mSectionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWordListBinding = DataBindingUtil.setContentView(this,R.layout.activity_word_list);
        initVariables();
        initViewModel();
        setupSectionList();
    }

    private void setupSectionList() {
        mWordListBinding.rvWordList.setLayoutManager(new LinearLayoutManager(this));
        mWordListBinding.rvWordList.setAdapter(mWordAdapter);
    }

    private void initViewModel() {
        model = ViewModelProviders.of(this).get(WordListViewModel.class);
        model.getWords(mSectionId).observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                mWordAdapter.setItems(words);
            }
        });
    }

    private void initVariables() {
        mWordAdapter = new WordListAdapter();
        mSectionId = getIntent().getIntExtra(KEY_SECTION_ID,0);
    }
}
