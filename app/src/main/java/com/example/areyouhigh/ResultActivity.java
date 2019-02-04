package com.example.areyouhigh;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class ResultActivity extends AppCompatActivity {
    private GifImageView gifImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultTextView = findViewById(R.id.result_text);
        Intent intent = getIntent();
        int score = Integer.parseInt(intent.getStringExtra(MainActivity.SCORE));
        if (score <= 1) {
            resultTextView.setText("You are extremely high. Stay at home today");
        } else if (score <= 3) {
            resultTextView.setText("You are pretty high. Don't drive today");
        } else if (score <= 4) {
            resultTextView.setText("You are high. Drive carefully!!");
        } else if (score <= 6) {
            resultTextView.setText("You are a bit high. Have more");
        } else {
            resultTextView.setText("You are not high at all. Consider buying some weed");
        }


        gifImageView = findViewById(R.id.gif_image_view);
        Random random = new Random();
        String gifID = "gif" + random.nextInt(11);
        int resId = getResources().getIdentifier(gifID, "drawable", getPackageName());
        gifImageView.setImageResource(resId);

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(true)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Exit");
        alertDialog.show();


    }


    public void Reset(View view) {
        Intent mStartActivity = new Intent(ResultActivity.this , MainActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(ResultActivity.this, mPendingIntentId, mStartActivity,
                PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) ResultActivity.this.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() +1, mPendingIntent);
        System.exit(0);
    }
}
