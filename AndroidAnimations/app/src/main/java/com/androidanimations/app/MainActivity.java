package com.androidanimations.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidanimations.app.fragments.*;
import com.androidanimations.app.fragments.Main_Fragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity {

    private SlidingMenu menu;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setShadowWidth(15);
        menu.setFadeDegree(0.35f);
        menu.setBehindOffset(100);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        menu.setMenu(R.layout.activity_menu);

        ListView listView = (ListView) menu.findViewById(R.id.options_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.list_options));
        listView.setAdapter(adapter);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new Main_Fragment()).commit();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment frag = null;

                switch (position){
                    case 0:
                        frag = new Animacion_1();
                        break;
                    case 1:
                        frag = new Animacion_2();
                        break;
                    case 2:
                        frag = new Animacion_3();
                        break;
                    case 3:
                        frag = new Animacion_4();
                        break;
                    case 4:
                        frag = new Animacion_5();
                        break;
                    case 5:
                        frag = new Animacion_6();
                        break;
                    case 6:
                        frag = new Animacion_7();
                        break;
                    case 7:
                        frag = new Animacion_8();
                        break;
                    case 8:
                        frag = new Animacion_9();
                        break;
                    case 9:
                        frag = new Animacion_10();
                        break;
                    case 10:
                        frag = new Animacion_11();
                        break;
                    case 11:
                        frag = new Animacion_12();
                        break;
                    case 12:
                        frag = new Animacion_13();
                        break;
                    case 13:
                        frag = new Animacion_14();
                        break;
                    case 14:
                        frag = new Animacion_15();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
                menu.toggle();
            }
        });
    }
}
