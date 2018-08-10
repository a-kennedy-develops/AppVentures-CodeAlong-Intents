package com.example.alexk.firstintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.alexk.firstintents.MainActivity.EXTRA_KEY;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textName = findViewById(R.id.textViewSecondName);
        TextView textID = findViewById(R.id.textViewSecondID);



        if (getIntent() != null && getIntent().getExtras() != null) {
//            String passedData = getIntent().getStringExtra(EXTRA_KEY);
//            textView.setText(passedData);
            Student student = (Student) getIntent().getSerializableExtra(MainActivity.EXTRA_KEY);
            textName.setText(student.getName());
            textID.setText(String.valueOf(student.getiD()));
        }


        Button buttonFinish = findViewById(R.id.buttonExplicitDone);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
