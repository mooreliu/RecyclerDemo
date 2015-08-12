package com.example.mooreliu.recyclerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mooreliu.recyclerdemo.R;

public class LoginActivity extends ActionBarActivity {
//    static String id ="111111";
//    static String password = "111111";
    static String id ="";
    static String password = "";
    TextView tv_id;
    TextView tv_password;
    ImageView iv_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        tv_id = (TextView) findViewById(R.id.id);
        tv_password = (TextView) findViewById(R.id.password);
        iv_img = (ImageView)findViewById(R.id.loginimage);
        iv_img.setImageResource(R.mipmap.imglogin);
       // setContentView(R.layout.layout_login);
    }

    public void signIn(View v) {
        Log.e("Login","signIn!");
        String idInput =  tv_id.getText().toString();
        String passwordInput =  tv_password.getText().toString();
//        Log.e("Login",idInput);
//        Log.e("Login",passwordInput);
        if(idInput.equals(id) && passwordInput.equals(password)) {
//            Log.e("Login","equals!!!!");
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,R.string.wrong_password_notification,Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
