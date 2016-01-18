package com.example.admin.task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.amlcurran.showcaseview.ShowcaseView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Boolean isFabOpen = false;
    private FloatingActionButton mainFab,circleImage,MaterialeditText, Showcase;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        /*setSupportActionBar(toolbar);*/
        // Action Bar showcaseview created on  1/18/2016
        new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(new ToolActionBar(toolbar, R.id.menu_item1))
                .setStyle(R.style.CustomShowcaseTheme2)
                .setContentText("Here's how to highlight items on a toolbar")
                .build()
                .show();

        mainFab = (FloatingActionButton)findViewById(R.id.fab);
        Showcase= (FloatingActionButton) findViewById(R.id.fab0);
        circleImage = (FloatingActionButton)findViewById(R.id.fab1);
        MaterialeditText = (FloatingActionButton)findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        mainFab.setOnClickListener(this);
        circleImage.setOnClickListener(this);
        MaterialeditText.setOnClickListener(this);
        Showcase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.fab0:
                Fragment croutonfragment= new CroutonCustomLayout();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,croutonfragment).commit();
                Log.d("croutonText", "onClick: ");
                break;
            case R.id.fab1:
                Fragment fragment= new CircleImage();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,fragment).commit();
                Log.d("CircleImage", "Fab 1");
                break;

            case R.id.fab2:
                Fragment fragment1= new MaterialEdittext();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,fragment1).commit();
                Log.d("material_edittext", "Fab 2");
                break;
            default:
                break;
        }
    }
    public void animateFAB()
    {

        if (isFabOpen) {
            mainFab.startAnimation(rotate_backward);
            Showcase.startAnimation(fab_close);
            circleImage.startAnimation(fab_close);
            MaterialeditText.startAnimation(fab_close);
            Showcase.setClickable(false);
            circleImage.setClickable(false);
            MaterialeditText.setClickable(false);
            isFabOpen = false;
            Log.d("Ramasamy", "close");
        } else {
            mainFab.startAnimation(rotate_forward);
            Showcase.startAnimation(fab_open);
            circleImage.startAnimation(fab_open);
            MaterialeditText.startAnimation(fab_open);
            circleImage.setClickable(true);
            Showcase.setClickable(true);
            MaterialeditText.setClickable(true);
            isFabOpen = true;
            Log.d("Ramasamy", "open");
        }
    }
        /*public void onCustomNotice(View v)
        {
        View customView = getLayoutInflater().inflate(R.layout.custom_crouton_layout, null);
        Crouton.show(this, customView);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
