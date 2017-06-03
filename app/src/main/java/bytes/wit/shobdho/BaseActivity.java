package bytes.wit.shobdho;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Md. Sifat-Ul Haque on 6/3/2017.
 */

public class BaseActivity extends AppCompatActivity implements LifecycleRegistryOwner{

    /* Primary toolbar*/
    protected Toolbar toolbar;
    protected ActionBar actionBar;
    protected LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);;

    /**
     * Set toolbar into actionbar.
     */
    protected void setupToolbar(int id) {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(id);
            toolbar.setTitleTextColor(Color.WHITE);
        }

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return mLifecycleRegistry;
    }
}
