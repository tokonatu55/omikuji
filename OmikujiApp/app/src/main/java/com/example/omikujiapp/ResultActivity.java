package com.example.omikujiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    public static final String KEY_RESULT_ID = "result_id";
    private TextView resultTextView;
    private ImageView resultImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int resultId = getIntent().getIntExtra(KEY_RESULT_ID, -1);
        resultTextView = findViewById(R.id.result);
        resultImageView = findViewById(R.id.image);


        String resultStr = "";
        int resultimage = -1;
        switch (resultId) {
            case 0:
                resultStr = "大吉";
                resultimage = R.drawable.great_blessing;
                break;
            case 1:
                resultStr = "中吉";
                resultimage = R.drawable.middle_blessing;
                break;
            case 2:
                resultStr = "小吉";
                resultimage = R.drawable.small_blessing;
                break;
            case 3:
                resultStr = "吉";
                resultimage = R.drawable.blessing;
                break;
            case 4:
                resultStr = "末吉";
                resultimage = R.drawable.uncertain_luck;
                break;
            case 5:
                resultStr = "凶";
                resultimage = R.drawable.curse;
                break;
            case 6:
                resultStr = "大凶";
                resultimage = R.drawable.great_curse;
                break;
            default:
                break;
        }
        if (resultTextView != null) {
            resultTextView.setText(resultStr);
        }
        if (resultImageView != null && resultimage != -1) {
            resultImageView.setImageResource(resultimage);
        }

    }
}