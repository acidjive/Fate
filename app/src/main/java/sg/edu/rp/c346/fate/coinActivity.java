package sg.edu.rp.c346.fate;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by 16022578 on 11/11/2017.
 */

public class coinActivity extends Activity {
    Button btn_flip;
    ImageView coin_view;
    Random r;
    SoundPool mySound;
    int coinId;
    int coinSide; // 0=head, 1=tail
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coin_activity);

        mySound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        coinId = mySound.load(this,R.raw.coindrop,1);

        btn_flip =(Button)findViewById(R.id.flipBtn);
        coin_view =(ImageView)findViewById(R.id.coinView);
        r= new Random();

        btn_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mySound.play(coinId,1,1,1,0,1);

                coinSide = r.nextInt(2);


                if (coinSide == 0){
                    coin_view.setImageResource(R.drawable.heads);
                    Toast.makeText(coinActivity.this,"Heads!",Toast.LENGTH_SHORT).show();
                }else if(coinSide == 1){
                    coin_view.setImageResource(R.drawable.tails);
                    Toast.makeText(coinActivity.this,"Tails!",Toast.LENGTH_SHORT).show();
                }
                RotateAnimation rotate= new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(1000);
                coin_view.startAnimation(rotate);
            }
        });
    }

}
