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


public class diceActivity extends Activity {

    public static final Random r = new Random();
    Button rollDice;
    ImageView dice1;
    ImageView dice2;
    SoundPool mySound;
    int diceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);
        rollDice = (Button)findViewById(R.id.roll);
        dice1 = (ImageView)findViewById(R.id.imageView1);
        dice2 =(ImageView)findViewById(R.id.imageView2);

        mySound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        diceId = mySound.load(this,R.raw.dicesound,1);

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mySound.play(diceId,1,1,1,0,1);
                int val1= randomDiceVal();
                int val2 = randomDiceVal();

                int res1=getResources().getIdentifier("d"+ val1,"drawable","sg.edu.rp.c346.fate");
                int res2=getResources().getIdentifier("d"+ val2,"drawable","sg.edu.rp.c346.fate");

                dice1.setImageResource(res1);
                dice2.setImageResource(res2);

                RotateAnimation rotate= new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(1000);
                dice1.startAnimation(rotate);
                dice2.startAnimation(rotate);
            }


        });


    }

    public static int randomDiceVal(){
        return r.nextInt(6)+1;


    }


}
