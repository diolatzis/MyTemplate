package com.diol.apps.mytemplate.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.diol.apps.mytemplate.R;
import com.diol.apps.mytemplate.view.activity.base.BaseActivity;

/**
 * Created by stavros.diolatzis on 8/3/2017.
 */

public class MainFragment extends Fragment {

    private Button btnMain;

    public static MainFragment newInstance() {return new MainFragment();}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
        setViews();
    }

    private void bindViews(View v)
    {
        btnMain = (Button) v.findViewById(R.id.button);
    }

    private void setViews()
    {
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((BaseActivity)getActivity()).visibleToolbar) ((BaseActivity)getActivity()).hideToolbar();
                else ((BaseActivity)getActivity()).showToolbar();
            }
        });
    }
}
