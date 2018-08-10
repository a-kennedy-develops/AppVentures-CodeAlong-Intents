package com.example.alexk.firstintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        final Intent intentToSend = new Intent();
        final EditText editTextToSend = findViewById(R.id.editTextForResult);

        Button buttonSend = findViewById(R.id.buttonPassForResult);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToSend.putExtra(MainActivity.EXTRA_KEY, editTextToSend.getText().toString());
                setResult(RESULT_OK, intentToSend);
                finish();
            }
        });
    }
}
