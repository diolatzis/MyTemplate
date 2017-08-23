package com.diol.apps.mytemplate.view.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.diol.apps.mytemplate.R;

/**
 * Created by diola on 23/8/2017.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

}
