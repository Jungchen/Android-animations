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

import com.androidanimations.app.fragments.Anim_Gif;
import com.androidanimations.app.fragments.Anim_Gif2;
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

                Log.e("POSICION: ", String.valueOf(position));
                Fragment frag = null;

                switch (position){
                    case 0:
                        frag = new Anim_Gif();
                        break;
                    case 1:
                        frag = new Anim_Gif2();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
                menu.toggle();
            }
        });
    }
}
