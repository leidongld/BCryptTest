package com.example.leidong.bcrypttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hashed = BCrypt.hashpw(editText.getText().toString(), BCrypt.gensalt());
                textView.setText(hashed);
                if(BCrypt.checkpw("1234567", hashed)){
                    Toast.makeText(MainActivity.this, "Mache", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Not Mache", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * 获取控件
     */
    private void initView() {
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }
}
