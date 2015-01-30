package com.example.user.dangerousdogs;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends Activity {

    public final String LOG_TAG = this.getClass().getSimpleName();
    public int current = 0;
    private Button btnNext,btnBack;
    ArrayList<Fragment> mFragments = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment mDogoFragment = new DogoFragment();
        Fragment mRootWeilerFragment = new RootWeilerFragment();
        Fragment mFilaFragment = new FilaFragment();

        mFragments.add(mDogoFragment);
        mFragments.add(mFilaFragment);
        mFragments.add(mRootWeilerFragment);

        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).add(R.id.container, mFragments.get(0)).commit();
        btnBack = (Button)findViewById(R.id.angry_btn1);
        btnNext = (Button)findViewById(R.id.angry_btn2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current == 0) {
                    current = 2;
                    getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter,R.anim.exit).replace(R.id.container, mFragments.get(current)).commit();
                }
                else {
                    current--;
                    getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).replace(R.id.container, mFragments.get(current)).commit();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(current == 2) {
                    current = 0;
                    getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).replace(R.id.container, mFragments.get(current)).commit();
                }
                else {
                    current++;
                    getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).replace(R.id.container, mFragments.get(current)).commit();
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
