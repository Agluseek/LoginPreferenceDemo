package example.com.loginpreferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Give your SharedPreferences file a name and save it to a static variable
    public static final String PREFS_NAME = "LoginActivity";
    public static SharedPreferences settings;
    public static boolean hasLoggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(LoginActivity.PREFS_NAME, 0);
        hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        //define if the user is login it should be in mainactiviy
        if (hasLoggedIn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.login_activity);
    }

    public void Login(View view) {

        //show the successfully toast when login
        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        //for store preference
        SharedPreferences settings = getSharedPreferences(LoginActivity.PREFS_NAME, 0); // 0 - for private mode
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("hasLoggedIn", true);
        editor.apply();

    }

}
