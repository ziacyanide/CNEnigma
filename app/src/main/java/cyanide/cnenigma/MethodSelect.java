package cyanide.cnenigma;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MethodSelect extends AppCompatActivity implements View.OnClickListener {
Button encrypt,back;
EditText attrib;
boolean en=false;
RadioGroup r_gp;
boolean cshift,cshift_adv,reverse,fullreverse,binary;
boolean bireverse,csentence,haphazard,anyMethod;
String text, tech, result;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_select);
        EncryptData rec_data = (EncryptData) getIntent().getSerializableExtra("data");
        text=rec_data.text_input;
        en=rec_data.intent;
        encrypt = findViewById(R.id.btn_encrypt);
        TextView lbl = findViewById(R.id.lbl_methods);

        if (en){
            lbl.setText("Encryption methods");
            encrypt.setText("Encrypt");

        } else{
            lbl.setText("Decryption Methods");
            encrypt.setText("Decrypt");
        }


        back=findViewById(R.id.btn_back);
        attrib=findViewById(R.id.txt_attrib);
//        s_attrib = findViewById(R.id.checkBox);
        r_gp=findViewById(R.id.rGp_method);
       encrypt.setOnClickListener(this);
       back.setOnClickListener(this);
       allFalse();
       attrib.setVisibility(View.INVISIBLE);
       r_gp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if (i==R.id.r_btn_cshift){
                   allFalse();
                   cshift=true;
                   anyMethod=true;
                   tech="Ceaser Shift";
//                   s_attrib.setText("Advance?");
                   attrib.setInputType(InputType.TYPE_CLASS_NUMBER);

                   attrib.setHint("Input jump length");
                   attrib.setVisibility(View.VISIBLE);
//                   s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Ceaser Shift selected", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.r_btn_sshift){
                   allFalse();
                   csentence=true;
                   anyMethod=true;
                   tech="Sentence Shift";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Sentence Shift selected", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.r_btn_halfrev){
                   allFalse();
                   reverse=true;
                   anyMethod=true;
                   tech="Half Reverse";
                   //attrib.setVisibility(View.VISIBLE);
//                   s_attrib.setText("Pairs?");
//                   s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Half Reverse selected", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.r_btn_fullReverse){
                   allFalse();
                   fullreverse=true;
                   anyMethod=true;
                   tech="Full Reverse";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Full Reverse selected", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.r_btn_haphazard){
                   allFalse();
                   haphazard=true;
                   anyMethod=true;
                   tech="Haphazard";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Haphazard selected", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.r_btn_binary){
                   allFalse();
                   binary=true;
                   anyMethod=true;
                   tech="Binary";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Binary selected", Toast.LENGTH_SHORT).show();
               }else if (i==R.id.r_btn_cshift_adv){
                   allFalse();
                   cshift_adv=true;
                   anyMethod=true;
                   tech="Advance Shift";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Advance Shift selected", Toast.LENGTH_SHORT).show();
               }else if (i==R.id.r_btn_pairrev){
                   allFalse();
                   bireverse=true;
                   anyMethod=true;
                   tech="Pair Reverse";
                   //attrib.setVisibility(View.VISIBLE);
                   //s_attrib.setVisibility(View.VISIBLE);
                   Toast.makeText(MethodSelect.this, "Pair Reverse selected", Toast.LENGTH_SHORT).show();
               }

           }
       });

       /*s_attrib.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton switch1, boolean b) {
               if (cshift){
                   if (switch1.isChecked()==true){
                       cshift=false;
                       cshift_adv=true;
                       anyMethod=true;
                       tech="Ceaser Shift Advance";
                       Toast.makeText(MethodSelect.this, "Ceaser Shift Advance selected", Toast.LENGTH_SHORT).show();
                   }
                   if (switch1.isChecked()==false){
                       cshift=true;
                       cshift_adv=false;
                       anyMethod=true;
                       tech="Ceaser Shift";
                       Toast.makeText(MethodSelect.this, "Ceaser Shift selected", Toast.LENGTH_SHORT).show();
                   }
               }if (reverse){
                   if (switch1.isChecked()==true){
                       reverse=false;
                       bireverse=true;
                       anyMethod=true;
                       tech="Half Reverse Pairs";
                       Toast.makeText(MethodSelect.this, "Reverse in pairs selected", Toast.LENGTH_SHORT).show();
                   }
                   if (switch1.isChecked()==false){
                       bireverse=false;
                       reverse=true;
                       anyMethod=true;
                       tech="Half Reverse";
                       Toast.makeText(MethodSelect.this, "Half Reverse selected", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });*/


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        boolean isError =false;
//        if (id==R.id.s_attrib){
//            if (cshift){
//                if (s_attrib.isChecked()==true){
//                    cshift=false;
//                    cshift_adv=true;
//                    anyMethod=true;
//                    tech="Ceaser Shift Advance";
//                    Toast.makeText(MethodSelect.this, "Ceaser Shift Advance selected", Toast.LENGTH_SHORT).show();
//                }
//                if (!s_attrib.isChecked()==true){
//                    cshift=true;
//                    cshift_adv=false;
//                    anyMethod=true;
//                    tech="Ceaser Shift";
//                    Toast.makeText(MethodSelect.this, "Ceaser Shift selected", Toast.LENGTH_SHORT).show();
//                }
//            }if (reverse){
//                if (s_attrib.isChecked()==true){
//                    reverse=false;
//                    bireverse=true;
//                    anyMethod=true;
//                    tech="Half Reverse Pairs";
//                    Toast.makeText(MethodSelect.this, "Reverse in pairs selected", Toast.LENGTH_SHORT).show();
//                }
//                if (!s_attrib.isChecked()==true){
//                    bireverse=false;
//                    reverse=true;
//                    anyMethod=true;
//                    tech="Half Reverse";
//                    Toast.makeText(MethodSelect.this, "Half Reverse selected", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }

        if (id == R.id.btn_back) {
            Intent intent = new Intent(this, Encrypt_page.class);
            startActivity(intent);
        }

        if (id==R.id.btn_encrypt){
            if (text.equalsIgnoreCase("")) {
                isError = true;
                Toast.makeText(this, "Need data to encrypt", Toast.LENGTH_SHORT).show();
            }
            if ((cshift) && (attrib.getText().toString().equalsIgnoreCase(""))) {
                isError=true;
                attrib.setError("This field is necessary");
                Toast.makeText(this, "Need jump length", Toast.LENGTH_SHORT).show();
            }


            if (!isError){

                if (en){
                    Encryption encryption = new Encryption();
                    if (cshift) result = encryption.cShift(text, Integer.parseInt(attrib.getText().toString()));
                    if (cshift_adv) result = encryption.cShiftAdv(text);
                    if (reverse) result = encryption.reverse(text);
                    if (fullreverse) result = encryption.fullReverse(text);
                    if (binary) result = encryption.binary(text);
                    if (bireverse) result = encryption.biReverse(text);
                    if (csentence) result = encryption.cShiftSentence(text);
                    if (haphazard) result = encryption.haphazard(text);
                } else {
                    Decryption dec = new Decryption();
                    if (cshift) result = dec.deCShift(text, Integer.parseInt(attrib.getText().toString()));
                    if (cshift_adv) result = dec.deCShiftAdv(text);
                    if (reverse) result = dec.deReverse(text);
                    if (fullreverse) result = dec.deFullReverse(text);
                    if (binary) result = dec.deBinary(text);
                    if (bireverse) result = dec.deBiReverse(text);
                    if (csentence) result = dec.deCShiftSentence(text);
                    if (haphazard) result = dec.deHaphazard(text);
                }
                EncryptData data = new EncryptData();
                data.text_input=text;
                data.tech=tech;
                data.result=result;
                data.intent=en;

                Intent intent = new Intent(this,Activity_result.class);
                intent.putExtra("data",data);
                startActivityForResult(intent,123);
            }
        }
    }
    private void allFalse(){
        cshift=false;
        cshift_adv = false;
        reverse= false;
        fullreverse=false;
        binary=false;
        bireverse = false;
        csentence= false;
        haphazard = false;
        anyMethod=false;
        tech="";

        attrib.setVisibility(View.INVISIBLE);
//        s_attrib.setVisibility(View.INVISIBLE);
    }

}
