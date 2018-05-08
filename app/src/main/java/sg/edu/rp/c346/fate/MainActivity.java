package sg.edu.rp.c346.fate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button coin;
    Button bottle_spinner;
    Button dice;
    Button magicBall;
    ImageView title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coin=(Button)findViewById(R.id.coinFlip);
        bottle_spinner =(Button)findViewById(R.id.bottleSpn);
        dice = (Button)findViewById(R.id.dice);
        title = (ImageView)findViewById(R.id.imageView);

        title.setImageResource(R.drawable.icon);
        magicBall = (Button)findViewById(R.id.Ball);


        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neo= new Intent(MainActivity.this,coinActivity.class);
                startActivity(neo);
            }
        });

        bottle_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neo= new Intent(MainActivity.this,bottleActivity.class);
                startActivity(neo);
            }
        });

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neo =new Intent(MainActivity.this,diceActivity.class);
                startActivity(neo);
            }
        }

        );

        magicBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neo =new Intent(MainActivity.this,ballActivity.class);
                startActivity(neo);
            }
        });






    }






}
