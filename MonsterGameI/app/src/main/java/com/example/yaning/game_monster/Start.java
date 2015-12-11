package com.example.yaning.game_monster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.yaning.game_monster.WriteData.writeUserName;


public class Start extends ActionBarActivity {

    public static String message;
    public static String age;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final EditText editText = (EditText) findViewById(R.id.enter_name);
        final EditText editage = (EditText) findViewById(R.id.enter_age);

        Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString();
                age = editage.getText().toString();
                UsernameValidater usernameValidater = new UsernameValidater();
                boolean valid = usernameValidater.validate(message);


                if(valid&&age!=null) {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Hello "+message+"!", Toast.LENGTH_SHORT);
                    toast.show();
                    writeUserName("username.txt", message);
                    writeUserName("age.txt", age);
                    Intent start_game = new Intent(v.getContext(), ChooseGame.class);
                    startActivity(start_game);
                }
                else{
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Please Enter a Valid Username and Age!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
    public String getUserName(){
        return message;
    }
}
