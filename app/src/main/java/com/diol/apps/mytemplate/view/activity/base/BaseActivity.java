package com.diol.apps.mytemplate.view.activity.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentContainer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.diol.apps.mytemplate.R;
import com.diol.apps.mytemplate.utility.Utils;

import okhttp3.internal.Util;

import static android.widget.RelativeLayout.BELOW;

/**
 * Created by diola on 23/8/2017.
 */

public class BaseActivity extends AppCompatActivity {

    FrameLayout fragmentContainer;
    Toolbar toolbar;
    public boolean visibleToolbar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        bindViews();


    }

    private void bindViews()
    {
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    //Toolbar

    public void showToolbar()
    {
        Utils.doOnceOnGlobalLayoutOfView(toolbar, new Runnable() {
            @Override
            public void run() {
                //Move the toolbar
                moveToolbar((int) (-toolbar.getY()));
                visibleToolbar = true;
            }
        });
        toolbar.requestLayout();

    }

    public void hideToolbar()
    {
        Utils.doOnceOnGlobalLayoutOfView(toolbar, new Runnable() {
            @Override
            public void run() {
                //Move the toolbar
                moveToolbar((int) (-toolbar.getHeight()-toolbar.getY()));
                visibleToolbar = false;
            }
        });
        toolbar.requestLayout();
    }

    private void moveToolbar(final int y)
    {
        final int fragmentContainerTopMargin = ((RelativeLayout.LayoutParams)fragmentContainer.getLayoutParams()).topMargin;

        ObjectAnimator moveToolbar = ObjectAnimator.ofFloat(toolbar,"y",toolbar.getY() + y);
        moveToolbar.setDuration(getResources().getInteger(R.integer.slide_duration));
        moveToolbar.setAutoCancel(true);
        moveToolbar.setInterpolator(new DecelerateInterpolator(2));
        moveToolbar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = animation.getAnimatedFraction();

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fragmentContainer.getLayoutParams();
                params.setMargins(params.leftMargin, (int) (fragmentContainerTopMargin + percent*y),params.rightMargin,params.bottomMargin);
                fragmentContainer.setLayoutParams(params);
            }
        });
        moveToolbar.start();


    }

    //Fragment

    public void loadNewFragment(Fragment newFragment, boolean addToStack, String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,newFragment,tag);

        if(addToStack) transaction.addToBackStack(tag);

        transaction.commit();
    }

}
