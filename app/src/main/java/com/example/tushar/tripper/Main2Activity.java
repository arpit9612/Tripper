package com.example.tushar.tripper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.BaseAnimationInterface;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;
import java.util.Map;

public  class Main2Activity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        mDemoSlider = (SliderLayout) findViewById( R.id.slider );
        //sin = (MyTextView)findViewById(R.id.sign);
        final HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put( "1", R.drawable.seedqq );
        file_maps.put( "2", R.drawable.socketmarket );
        file_maps.put( "3", R.drawable.tool );
        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView( this );
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image( file_maps.get( name ) )
                    .setScaleType( BaseSliderView.ScaleType.CenterCrop )
                    .setOnSliderClickListener( this );


            textSliderView.bundle( new Bundle() );
            textSliderView.getBundle().putString( "extra", name );

            mDemoSlider.addSlider( textSliderView );
        }
        mDemoSlider.setPresetTransformer( SliderLayout.Transformer.Default );
        mDemoSlider.setPresetIndicator( SliderLayout.PresetIndicators.Center_Bottom );
        mDemoSlider.setCustomAnimation( new ChildAnimationExample() );
        mDemoSlider.setDuration( 4000 );
        mDemoSlider.addOnPageChangeListener( this );
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onSliderClick(BaseSliderView slider) {
        switch (View.generateViewId()) {
            case 1:
                Toast.makeText( Main2Activity.this, "1 selected", Toast.LENGTH_SHORT ).show();
                break;

            case 2:
                Toast.makeText( Main2Activity.this, "2 selected", Toast.LENGTH_SHORT ).show();
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
