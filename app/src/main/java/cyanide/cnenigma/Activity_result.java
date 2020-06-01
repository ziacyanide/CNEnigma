package cyanide.cnenigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity_result extends AppCompatActivity {
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        EncryptData rec_data = (EncryptData) getIntent().getSerializableExtra("data");

        result= findViewById(R.id.txt_result);
        result.setText(rec_data.result);

    }

    public void home_click(View view) {
        Intent intent = new Intent(this,DashBoard.class);
        //finishActivity(123);
        finishAffinity();

        //finish();
        startActivity(intent);


    }
}
