package cyanide.cnenigma;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Encrypt_page extends AppCompatActivity implements View.OnClickListener {
    EditText input;
    Button next, back;

    boolean en=false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_page);
        input = (EditText) findViewById(R.id.txt_encrypt);
        next = (Button) findViewById(R.id.btn_next);
        back = (Button) findViewById(R.id.btn_back);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        en=getIntent().getBooleanExtra("intent",false);
        if (en==true){
            input.setHint("Enter Text to Encrypt");

        } else {
            input.setHint("Enter Text to Decrypt. Note: App may crash if entered text is not genuine Enigma encrypted data");
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        boolean isError =false;
        if (id == R.id.btn_back) {
            Intent intent = new Intent(this, DashBoard.class);
            startActivity(intent);
            finish();
        } else if (id==R.id.btn_next){
            if (input.getText().toString().equalsIgnoreCase("")){
                if (en==true) {
                    input.setError("Please enter text to encrypt");
                } else {
                    input.setError("Please enter text to decrypt");
                }
                isError=true;
                Toast.makeText(this, "No text entered", Toast.LENGTH_SHORT).show();
            } else {
                isError=false;
            }
            if (isError==false){
                EncryptData data = new EncryptData();
                data.text_input=input.getText().toString();
                data.tech="";
                data.result="";
                data.intent=en;
                Intent intent = new Intent(this,MethodSelect.class);
                intent.putExtra("data",data);
                startActivityForResult(intent,124);
            }
        }
    }
}