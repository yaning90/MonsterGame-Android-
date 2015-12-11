package com.example.yaning.game_monster;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.example.yaning.game_monster.WriteData.generateCsvFile;
import static com.example.yaning.game_monster.WriteData.readUserName;




public class BurpingAnimation extends ActionBarActivity {

    protected MediaPlayer mediaPlayer;

    protected Handler handler = new Handler();
    protected int[] sounds_1000 = {R.raw.set1_1000,R.raw.set2_1000,R.raw.set3_1000,R.raw.set4_1000,R.raw.set5_1000,
              R.raw.set6_1000,R.raw.set7_1000};
    protected int[] sounds_1500 = {R.raw.set1_1500,R.raw.set2_1500,R.raw.set3_1500,R.raw.set4_1500,R.raw.set5_1500,
              R.raw.set6_1500,R.raw.set7_1500};
    protected int[] sounds_3000 = {R.raw.set1_3000,R.raw.set2_3000,R.raw.set3_3000,R.raw.set4_3000,R.raw.set5_3000,
              R.raw.set6_3000,R.raw.set7_3000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final ImageView animation = (ImageView) findViewById(R.id.animation);
        Random trail = new Random();
        // randomly pick one of five animation lists
        int pickedTrial = trail.nextInt(5);
        // randomly pick one of seven sounds track (1000ms)
        final int r_1000 = trail.nextInt(7);
        // randomly pick one of seven sounds track (1500ms)
        final int r_1500 = trail.nextInt(7);
        // randomly pick one of seven sounds track (3000ms)
        final int r_3000 = trail.nextInt(7);
        final String gameType = "Burping";

        final Button bt_left=(Button) findViewById(R.id.leftButton);
        final Button bt_right=(Button) findViewById(R.id.rightButton);

        switch(pickedTrial) {
            case 0:
                animation.setBackgroundResource(R.drawable.animation_list1);

                handler.postDelayed(new Runnable() {
                        public void run(){
                            mediaPlayer = new MediaPlayer().create(getApplicationContext(),sounds_1000[r_1000]);
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.start();
                            //mediaPlayer.release();

                    }
                }, 1000);

                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_1500[r_1000]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                        //mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 3000);

                handler.postDelayed(new Runnable(){
                    public void run(){
                        bt_left.setOnClickListener(new View.OnClickListener() {
                            long lStartTime = new Date().getTime();


                            @Override
                            public void onClick(View v) {
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String date = getDate();
                                String username = getName();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "L",s, "1000", "3000", "0", date, gameType);

                                animation.setBackgroundResource(R.drawable.wronganswer);
                                wrongMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);

                            }
                        });
                        // right
                        bt_right.setOnClickListener(new View.OnClickListener(){
                            long lStartTime = new Date().getTime();
                            @Override
                            public void onClick(View v){
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);

                                String date = getDate();
                                String username = getName();
                                String age = getAge();
                                generateCsvFile("data.csv", username, age, "R", s, "1000", "3000", "1", date, gameType);
                                animation.setBackgroundResource(R.drawable.rightanswer);
                                rightMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                    }
                },4500);



            case 1:
                animation.setBackgroundResource(R.drawable.animation_list2);

                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_1000[r_1000]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                        //mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_3000[r_1000]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                        //mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 3000);

                handler.postDelayed(new Runnable(){

                    public void run(){
                        //right

                        bt_left.setOnClickListener(new View.OnClickListener() {
                            long lStartTime = new Date().getTime();

                            @Override

                            public void onClick(View v) {
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "L",s, "3000", "1000", "1", date, gameType);

                                animation.setBackgroundResource(R.drawable.rightanswer);
                                rightMusic();
                                //leftFireworks();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });

                        bt_right.setOnClickListener(new View.OnClickListener(){
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v){
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "R",s, "3000", "1000", "0", date, gameType);
                                animation.setBackgroundResource(R.drawable.wronganswer);
                                wrongMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                    }
                },6000);

                break;
            case 2:
                animation.setBackgroundResource(R.drawable.animation_list3);
                handler.postDelayed(new Runnable() {
                    public void run() {

                        mediaPlayer = new MediaPlayer().create(getApplicationContext(),sounds_3000[r_3000]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                        //mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_1000[r_3000]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                        //mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 5000);
                handler.postDelayed(new Runnable(){

                    public void run(){
                        //right
                        bt_left.setOnClickListener(new View.OnClickListener() {
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v) {
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();

                                generateCsvFile("data.csv",username,age, "L",s, "3000", "1000", "1", date, gameType);
                                animation.setBackgroundResource(R.drawable.rightanswer);

                                rightMusic();
                                //leftFireworks();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });

                        bt_right.setOnClickListener(new View.OnClickListener(){
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v){
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "R",s, "3000", "1000", "0", date, gameType);

                                animation.setBackgroundResource(R.drawable.wronganswer);
                                wrongMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                    }
                },6000);

                break;
            case 3:
                animation.setBackgroundResource(R.drawable.animation_list4);
                handler.postDelayed(new Runnable() {
                    public void run() {

                        mediaPlayer = new MediaPlayer().create(getApplicationContext(),sounds_1500[r_1500]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                       // mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_3000[r_1500]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                       // mediaPlayer.release();
                       // mediaPlayer = null;
                    }
                }, 3500);
                handler.postDelayed(new Runnable(){

                    public void run(){

                        //right
                        bt_left.setOnClickListener(new View.OnClickListener() {
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v) {
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();

                                String date = getDate();
                                String age = getAge();

                                generateCsvFile("data.csv",username,age, "L",s, "3000", "1500", "1", date, gameType);

                                animation.setBackgroundResource(R.drawable.rightanswer);

                                rightMusic();
                                //leftFireworks();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });

                        bt_right.setOnClickListener(new View.OnClickListener(){
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v){
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();

                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username, age,"R",s, "3000", "1500", "0", date, gameType);

                                animation.setBackgroundResource(R.drawable.wronganswer);


                                wrongMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                    }
                },6500);

                break;
            case 4:
                animation.setBackgroundResource(R.drawable.animation_list5);
                handler.postDelayed(new Runnable() {
                    public void run() {

                        mediaPlayer = new MediaPlayer().create(getApplicationContext(),sounds_1500[r_1500]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                       // mediaPlayer.release();
                       // mediaPlayer = null;
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mediaPlayer = new MediaPlayer().create(getApplicationContext(), sounds_3000[r_1500]);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.start();
                       // mediaPlayer.release();
                        //mediaPlayer = null;
                    }
                }, 3500);

                handler.postDelayed(new Runnable(){

                    public void run(){

                        bt_left.setOnClickListener(new View.OnClickListener() {
                            long lStartTime = new Date().getTime();

                            @Override
                            public void onClick(View v) {
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "L",s, "1500", "3000", "0", date, gameType);
                                animation.setBackgroundResource(R.drawable.wronganswer);
                                wrongMusic();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                        // right
                        bt_right.setOnClickListener(new View.OnClickListener(){
                            long lStartTime = new Date().getTime();
                            @Override
                            public void onClick(View v){
                                long lEndTime = new Date().getTime();
                                long difference = lEndTime - lStartTime;
                                System.out.println("Elapsed milliseconds: " + difference);
                                String s = String.valueOf(difference);
                                String username = getName();
                                String date = getDate();
                                String age = getAge();
                                generateCsvFile("data.csv",username,age, "R",s, "1500", "3000", "1", date, gameType);                                Intent start = new Intent(v.getContext(),MonsterBurping.class);

                                animation.setBackgroundResource(R.drawable.rightanswer);
                                rightMusic();
                                //rightFireworks();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), MonsterBurping.class);
                                        startActivity(intent);
                                    }
                                }, 2000);
                            }
                        });
                    }
                },6500);
                break;
        }


        final AnimationDrawable anim = (AnimationDrawable) animation.getBackground();

        animation.post(new Runnable() {
            public void run() {
                anim.start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_m, menu);
        return true;
    }

    public void wrongMusic() {
        // Play the sound of Wrong
        mediaPlayer = new MediaPlayer().create(getApplicationContext(), R.raw.wrong);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
       // mediaPlayer.release();
       // mediaPlayer = null;
    }
    public void rightMusic() {
        // Play the sound of Wrong
        mediaPlayer = new MediaPlayer().create(getApplicationContext(), R.raw.right);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
       // mediaPlayer.release();
       // mediaPlayer = null;
    }

    /*
    public void leftFireworks(){
        //Play left fireworks
        ImageView image;
        image = (ImageView) findViewById(R.id.leftImage);
        image.setBackgroundResource(R.drawable.sparkle);
        final AnimationDrawable animationList;
        animationList = (AnimationDrawable) image.getBackground();
        animationList.start();

    }
    public void rightFireworks(){
        //Play left fireworks
        ImageView image;
        image = (ImageView) findViewById(R.id.rightImage);
        image.setBackgroundResource(R.drawable.sparkle);
        final AnimationDrawable animationList;
        animationList = (AnimationDrawable) image.getBackground();
        animationList.start();
    }
    */

    public String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }
    public String getName(){
        String username = readUserName("username.txt");
        return username;
    }
    public String getAge(){
        String age = readUserName("age.txt");
        return age;
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
