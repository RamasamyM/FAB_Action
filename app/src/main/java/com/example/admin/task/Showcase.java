package com.example.admin.task;

/**
 * Created by Admin on 1/12/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;


public class Showcase extends Activity {



    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcase);
    /*    button = (Button)findViewById(R.id.showcasebutton);*/
        new ShowcaseView.Builder(this).setTarget(new ActionViewTarget(this, ActionViewTarget.Type.HOME )).setContentText("this is show case text ").hideOnTouchOutside().build();

    }
}
