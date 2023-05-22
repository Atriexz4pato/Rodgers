package com.example.rodgers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rodgers.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        TextView username =(TextView)  findViewById(R.id.username);
        TextView password= (TextView)  findViewById(R.id.password);
        TextView btn=findViewById(R.id.sign_up);

        MaterialButton loginbtn= (MaterialButton)  findViewById(R.id.loginbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if(username.getText().toString().equals("Kush")&& password.getText().toString().equals("patrikii")){
                    //correct username and password
                    Toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,activityPurchase.class));


                }else{
                    //Incorrect credentials
                    Toast.makeText(MainActivity.this, "Invalid Login!! ",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}