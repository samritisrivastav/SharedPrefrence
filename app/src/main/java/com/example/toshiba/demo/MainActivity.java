package com.example.toshiba.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity
{
    CheckBox check_box ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_box=(CheckBox)findViewById(R.id.checkbox_id);
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
        String savedvalue= sp.getString("remember","");

        if(savedvalue.equals("yes"));
        {
            Intent i=new Intent(MainActivity.this,Home_Activity.class);
            startActivity(i);
            finish();

        }

    }

    public void Login(View view)
    {
        Boolean box_value= check_box.isChecked();

        if(box_value)
        {
            SharedPreferences.Editor sp =getSharedPreferences("user",MODE_PRIVATE).edit();
             sp.putString("remember","yes");
            sp.commit();

            Intent i= new Intent(MainActivity.this,Home_Activity.class);
            startActivity(i);

        }
    }


}
