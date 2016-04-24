package suericze.coordinatoreps;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import suericze.coordinatoreps.tablayout.TablayoutActivity;

/**
 * Created by Eric on 2016/4/23.
 * 这是CoordinatorLayout相关控件的结合demo
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String GITHUB_INFO_ADDRESS = "https://github.com/smallcheric/CoordinatorEps";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();

        initEpsItem();
    }

    private void initEpsItem() {
        findViewById(R.id.coordinator_floating_snack).setOnClickListener(this);
        findViewById(R.id.tv_tablayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coordinator_floating_snack:
                CoordinatorLayoutFloatingActivity.start(this);
                break;
            case R.id.tv_tablayout:
                TablayoutActivity.start(this);
                break;
        }
    }

    private void initToolBar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mToolbar.inflateMenu(R.menu.menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_INFO_ADDRESS));
                startActivity(intent);
                return true;
            }
        });
    }
}
