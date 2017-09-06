package com.diol.apps.mytemplate.view.activity;

import android.os.Bundle;

import com.diol.apps.mytemplate.view.activity.base.BaseActivity;
import com.diol.apps.mytemplate.view.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    static final String MAIN_FRAGMENT_TAG="MAIN_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToolbar();
        addMainFragment();
    }

    private void addMainFragment()
    {
        MainFragment fragment = MainFragment.newInstance();

        loadNewFragment(fragment,false,MAIN_FRAGMENT_TAG);
    }
}
