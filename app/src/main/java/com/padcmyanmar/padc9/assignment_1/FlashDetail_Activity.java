package com.padcmyanmar.padc9.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FlashDetail_Activity extends AppCompatActivity {

    public String  rate = "";
    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdetail);

        final TextView rate_tv = findViewById(R.id.rate_tv);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int noofstars = ratingBar.getNumStars();
                float getrating = ratingBar.getRating();
                rate_tv.setText(getrating + 5 + "");
                rate = rate_tv.getText().toString();

            }
        });

        ImageView back_iv = findViewById(R.id.back_iv);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("rating", rate);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        TextView back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FlashDetail_Activity.this, UserProfile_Activity.class);
                intent.putExtra("rating", rate);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("rating", rate);
        setResult(RESULT_OK, intent);
        finish();
    }
}
