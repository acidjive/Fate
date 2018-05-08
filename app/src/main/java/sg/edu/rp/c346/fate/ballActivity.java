package sg.edu.rp.c346.fate;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by 16022578 on 13/11/2017.
 */

public class ballActivity extends Activity {

    ImageView magicBall;
    Button askBtn;
    Random r;
    SoundPool mySound;
    int magicId;
    int ballSide; // 0=head, 1=tail

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ball_activity);

        magicBall=(ImageView)findViewById(R.id.ballView);
        askBtn = (Button)findViewById(R.id.btnAsk);

        mySound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        magicId = mySound.load(this,R.raw.magic,1);
        r= new Random();



        askBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySound.play(magicId,1,1,1,0,1);



                ballSide = r.nextInt(7);

                if (ballSide == 0){
                    magicBall.setImageResource(R.drawable.yes1);


                }else if(ballSide == 1){
                    magicBall.setImageResource(R.drawable.yes2);

                }else if(ballSide == 2) {
                    magicBall.setImageResource(R.drawable.maybe1);

                }else if(ballSide == 3) {
                    magicBall.setImageResource(R.drawable.maybe2);

                }else if(ballSide == 4) {
                    magicBall.setImageResource(R.drawable.no1);

                }else if(ballSide == 5) {
                    magicBall.setImageResource(R.drawable.no2);

                }else if(ballSide == 6) {
                    magicBall.setImageResource(R.drawable.yes2);

                }
                RotateAnimation rotate= new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(700);
                magicBall.startAnimation(rotate);



            }
        });

    }
}
