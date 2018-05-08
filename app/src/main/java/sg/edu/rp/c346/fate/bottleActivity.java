package sg.edu.rp.c346.fate;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by 16022578 on 11/11/2017.
 */

public class bottleActivity extends Activity {

    ImageView bottle;
    Button spin;
    Random r;
    int angle;
    boolean restart = false;
    SoundPool mySound;
    int bottleId;
    int bottle2Id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottle_activity);

        bottle = (ImageView)findViewById(R.id.bottle_view);
        spin = (Button)findViewById(R.id.spinBtl);
        r = new Random();
        mySound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        bottleId = mySound.load(this,R.raw.spinsound,1);
        bottle2Id = mySound.load(this,R.raw.bottle2,1);







        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (restart){
                    int temp = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(temp,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    mySound.play(bottle2Id,1,1,1,0,1);


                    restart = false;
                    spin.setText("SPIN");

                }else{
                    angle = r.nextInt(3600)+360;
                    RotateAnimation rotate = new RotateAnimation(0,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    mySound.play(bottleId,1,1,1,0,1);

                    restart = true;
                    spin.setText("SPIN AGAIN");

                }


            }
        });
    }
}
