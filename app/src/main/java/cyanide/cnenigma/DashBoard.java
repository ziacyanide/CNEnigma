package cyanide.cnenigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity implements View.OnClickListener{
Intent intent;
    Button encrypt,decrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        //intent = new Intent(this,Encrypt_main.class);
        //startActivity(intent);

        encrypt = (Button) findViewById(R.id.btn_encrypt);
        decrypt = findViewById(R.id.btn_decrypt);

        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
    switch (view.getId())
    {
        case R.id.btn_encrypt :
        intent = new Intent(this,Encrypt_page.class);
        intent.putExtra("intent",true);
        startActivityForResult(intent,122);
            break;
        case R.id.btn_decrypt :
            intent = new Intent(this,Encrypt_page.class);
            intent.putExtra("intent",false);
            startActivityForResult(intent,122);

            break;

    }
    }
}
