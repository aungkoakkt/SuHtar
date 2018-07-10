package com.example.aungko.suhtar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroSliderActivity extends AppCompatActivity {

    public ViewPager viewPager;
    public LinearLayout dotLayout;
    public TextView[] dotText;
    public int[] layouts;
    public Button Skipbtn;
    public Button Nextbtn;
    public MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isFirstTimeStartApp()){
            startMainActivity();
            finish();
        }

        setContentView(R.layout.activity_intro_slider);

        viewPager = findViewById(R.id.view_pager);
        dotLayout = findViewById(R.id.dotLayout);
        Skipbtn = findViewById(R.id.skip);
        Nextbtn = findViewById(R.id.next);

        Skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });

        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpage = viewPager.getCurrentItem()+1;
                if (currentpage < layouts.length){

                    viewPager.setCurrentItem(currentpage);
                }else {
                    startMainActivity();
                }
            }
        });

        layouts = new int[]{R.layout.slider_1,R.layout.slider_2,R.layout.slider_3,R.layout.slider_4};
        myPagerAdapter = new MyPagerAdapter(layouts, getApplicationContext());
        viewPager.setAdapter(myPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == layouts.length - 1){
                    Nextbtn.setText("Start");
                    Skipbtn.setVisibility(View.GONE);
                }else {
                    Nextbtn.setText("Next");
                    Skipbtn.setVisibility(View.VISIBLE);
                }
                setdot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setdot(0);
    }

    private void startMainActivity() {
        setFirstFirstTimeStartApp(false);
        startActivity(new Intent(IntroSliderActivity.this, MainActivity.class));
        finish();
    }

    public boolean isFirstTimeStartApp(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SuHtar", MODE_PRIVATE);
        return sharedPreferences.getBoolean("SuHtar", true);
    }

    public void setFirstFirstTimeStartApp(boolean att){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SuHtar", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("SuHtar", att);
        editor.apply();
    }

    public void setdot(int page){
        int i;
        dotLayout.removeAllViews();
        dotText = new TextView[layouts.length];
        for(i =0 ; i < dotText.length; i++) {
            dotText[i] = new TextView(this);
            dotText[i].setText(Html.fromHtml("&#8226;"));
            dotText[i].setTextSize(25);
            dotText[i].setTextColor(Color.parseColor("#a9b4bb"));
            dotLayout.addView(dotText[i]);
        }

        if (dotText.length > 0){
            dotText[page].setTextColor(Color.parseColor("#ffffff"));
        }
    }
}
