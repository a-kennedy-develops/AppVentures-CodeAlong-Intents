package com.example.alexk.firstintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "EXTRA";
    public static final int REQUEST_CODE = 100;
    Button buttonExplicit;
    Button buttonForResult;
    EditText editName;
    EditText editID;
    TextView textViewUNCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText_name);
        editID = findViewById(R.id.editText_id);
        textViewUNCC = findViewById(R.id.textViewUNCC);


        buttonExplicit = findViewById(R.id.buttonExplicit);
        buttonExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra(EXTRA_KEY, editName.getText().toString());
                Student student = new Student(editName.getText().toString(), Integer.parseInt(editID.getText().toString()));
                intent.putExtra(EXTRA_KEY, student);
                startActivity(intent);
            }
        });

        textViewUNCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.uncc.edu"));
                startActivity(intent);
            }
        });

        buttonForResult = findViewById(R.id.buttonForResult);
        buttonForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        editName.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
             if (resultCode == RESULT_OK) {
                 String mData = data.getStringExtra(EXTRA_KEY);
//                 TextView textView = findViewById(R.id.textView);
//                 textView.setText(mData);

                 Toast.makeText(this, mData, Toast.LENGTH_SHORT).show();

             }
             else {
                 Log.d("TAG", "Result canceled");
             }
            }
    }
}
