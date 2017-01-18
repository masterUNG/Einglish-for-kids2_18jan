package rtc.warali.jatuporn.einglishforkids;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberActivity extends AppCompatActivity {



    // Explicit
    private TextView textView;
    private int anInt,timesAnInt = 0;
    private String[] titleStrings = new String[]{"ตัวพยัญชนะ", "ตัวเลข"};
    private ImageView imageView;
    private Button backButton, playButton;

    private int[] soundInts = new int[]{R.raw.nb1, R.raw.nb2, R.raw.nb3, R.raw.nb4, R.raw.nb5,
            R.raw.nb6, R.raw.nb7, R.raw.nb8, R.raw.nb9, R.raw.nb10, R.raw.nb11, R.raw.nb12,
            R.raw.nb13, R.raw.nb14, R.raw.nb15, R.raw.nb16, R.raw.nb17,
            R.raw.nb18, R.raw.nb19, R.raw.nb20};

    private int[] imageInts = new int[]{R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4,
            R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8,
            R.drawable.n9, R.drawable.n10, R.drawable.n11, R.drawable.n12,
            R.drawable.n13, R.drawable.n14, R.drawable.n15, R.drawable.n16,
            R.drawable.n17, R.drawable.n18, R.drawable.n19, R.drawable.n20};

    private MediaPlayer mediaPlayer;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView2_nb);
        imageView = (ImageView) findViewById(R.id.imageView3_nb);
        backButton = (Button) findViewById(R.id.button_nb);
        playButton = (Button) findViewById(R.id.button2_nb);


        //Show Text
        anInt = getIntent().getIntExtra("Index", 0);
        textView.setText(titleStrings[anInt]);
        //sound Effect
        soundEffect(timesAnInt);

        //Button Controller
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(NumberActivity.this, NumberTest.class);
                intent.putExtra("Times", timesAnInt);
                timesAnInt += 1;



                startActivity(intent);
            }
        });

    }// Main Method




    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("engV1", "Timess ==> " + timesAnInt);

        changeImage();

        soundEffect(timesAnInt);

    }

    private void changeImage() {

        imageView.setImageResource(imageInts[timesAnInt]);
    }


    private void soundEffect(int index) {
        mediaPlayer = MediaPlayer.create(getBaseContext(), soundInts[index]);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }

}// Main Class
