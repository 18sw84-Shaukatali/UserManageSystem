package com.sha66.madprproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLDataException;

public class MainActivity extends AppCompatActivity {
    EditText PName,Email;
    TextView textView;
    SqlMain data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PName=(EditText) findViewById(R.id.PName);
        Email=(EditText) findViewById(R.id.Email);
        textView=(TextView) findViewById(R.id.textView);
    data = new SqlMain(this,"",null,1);
    }

    public void btn_click(View view) {
        switch (view.getId()){
            case R.id.button:
                try {
                    data.add_user(PName.getText().toString(), Email.getText().toString());
                }catch (SQLiteException e) {
                    Toast.makeText(MainActivity.this,"AlreadyExists", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                data.remove_user(PName.getText().toString());
                break;
            case R.id.button3:
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Enter New name");
                final EditText new_name= new EditText(this);
                dialog.setView((new_name));
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.Update_user(PName.getText().toString(),new_name.getText().toString());
                    }
                });
dialog.show();
                break;
            case R.id.button4:
                data.listAllUsers(textView);
                break;
        }
    }
}