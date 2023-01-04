package com.example.sharedpherefencewithedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText edit_name,edit_fathername,edit_class,edit_address,edit_contact;
Button btn_save,btn_load;
TextView tv_name,tv_fathername,tv_class,tv_address,tv_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name=findViewById(R.id.edit_name);
        edit_fathername=findViewById(R.id.edit_fathername);
        edit_class=findViewById(R.id.edit_class);
        edit_address=findViewById(R.id.edit_address);
        edit_contact=findViewById(R.id.edit_contact);
        btn_save=findViewById(R.id.btnsave);
        btn_load=findViewById(R.id.btnload);
        tv_name=findViewById(R.id.tv_name);
        tv_fathername=findViewById(R.id.tv_fathername);
        tv_class=findViewById(R.id.tv_class);
        tv_address=findViewById(R.id.tv_address);
        tv_contact=findViewById(R.id.tv_contact);



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveText();



            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadData();

            }
        });
    }


    private void LoadData() {
        String text,text2,text3,text4,text5;
        SharedPreferences sharedPreferences=getSharedPreferences("shares",MODE_PRIVATE);
        text=sharedPreferences.getString("key","");
        text2=sharedPreferences.getString("key2","");
         text3=sharedPreferences.getString("key3","");
         text4=sharedPreferences.getString("key4","");
         text5=sharedPreferences.getString("key5","");

        tv_name.setText(text);
        tv_fathername.setText(text2);
        tv_class.setText(text3);
        tv_contact.setText(text4);
        tv_address.setText(text5);

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("key","");

    }

    private void SaveText() {
        String value=edit_name.getText().toString();
        String value2=edit_fathername.getText().toString();
        String value3=edit_class.getText().toString();
        String value4=edit_contact.getText().toString();
        String value5=edit_address.getText().toString();

        SharedPreferences sharedPreferences=getSharedPreferences("shares",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
         editor = editor.putString("key", value);
         editor=editor.putString("key2",value2);
        editor=editor.putString("key3",value3);
        editor=editor.putString("key4",value4);
        editor=editor.putString("key5",value5);

        editor.apply();
        Toast.makeText(this, "Save Data", Toast.LENGTH_SHORT).show();
    }
}