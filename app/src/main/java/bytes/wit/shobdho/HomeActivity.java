package bytes.wit.shobdho;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import bytes.wit.adapters.SectionAdapter;
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
        initViewModel();
        initVariables();
        setupSectionList();
    }

    private void setupSectionList() {
        mHomeBinding.rvSectionList.setLayoutManager(new LinearLayoutManager(this));
        mHomeBinding.rvSectionList.setAdapter(mSectionAdapter);
    }

    private void initViewModel() {
        model = ViewModelProviders.of(this).get(SectionViewModel.class);
        model.getSections().observe(this, sections -> {
            mSectionAdapter.setItems(sections);
        });
    }

    private void initVariables() {
        mSectionAdapter = new SectionAdapter();
    }
}
