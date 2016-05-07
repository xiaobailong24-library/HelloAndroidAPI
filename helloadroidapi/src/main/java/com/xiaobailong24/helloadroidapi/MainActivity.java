package com.xiaobailong24.helloadroidapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        flexboxLayout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_COLUMN);

        View view = flexboxLayout.getChildAt(0);
        FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) view.getLayoutParams();
        lp.order = -1;
        lp.flexGrow = 2;
        view.setLayoutParams(lp);
    }
}
