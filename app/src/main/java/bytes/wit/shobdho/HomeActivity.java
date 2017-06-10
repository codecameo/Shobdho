package bytes.wit.shobdho;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import bytes.wit.adapters.SectionAdapter;
import bytes.wit.factory.models.Section;
import bytes.wit.shobdho.databinding.ActivityHomeBinding;
import bytes.wit.viewmodels.SectionViewModel;

public class HomeActivity extends LifecycleActivity {

    private ActivityHomeBinding mHomeBinding;
    private SectionAdapter mSectionAdapter;
    private SectionViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        initVariables();
        initViewModel();
        setupSectionList();
    }

    private void setupSectionList() {
        mHomeBinding.rvSectionList.setLayoutManager(new LinearLayoutManager(this));
        mHomeBinding.rvSectionList.setAdapter(mSectionAdapter);
    }

    private void initViewModel() {
        model = ViewModelProviders.of(this).get(SectionViewModel.class);

        model.getLiveSections().observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(@Nullable List<Section> sections){
                if(sections != null){
                    mSectionAdapter.setItems(sections);
                }
            }
        });
    }

    private void initVariables() {
        mSectionAdapter = new SectionAdapter(new OnSectionItemClickListener());
    }

    public class OnSectionItemClickListener{
        public void onSectionItemClicked(View view, int sectionId){
            Intent intent = new Intent(HomeActivity.this,WordListActivity.class);
            intent.putExtra(WordListActivity.KEY_SECTION_ID,sectionId);
            startActivity(intent);
        }
    }
}
