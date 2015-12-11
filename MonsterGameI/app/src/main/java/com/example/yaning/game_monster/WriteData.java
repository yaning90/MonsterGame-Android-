package com.example.yaning.game_monster;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {

    public static void generateCsvFile(String sFileName, String id,String age, String leftOrRight, String reactTime,
                                       String leftMonsterTime, String rightMonsterTime, String rightOrWrong, String date, String gameType)
    {
        try
        {
            File root = Environment.getExternalStorageDirectory();
            File gpxfile = new File(root, sFileName);
            if(gpxfile.exists()) {
                FileWriter writer = new FileWriter(gpxfile, true);
                writer.append(id);
                writer.append(',');
                writer.append(age);
                writer.append(',');
                writer.append(leftOrRight);
                writer.append(',');
                writer.append(reactTime);
                writer.append(',');
                writer.append(leftMonsterTime);
                writer.append(',');
                writer.append(rightMonsterTime);
                writer.append(',');
                writer.append(rightOrWrong);
                writer.append(',');
                writer.append(date);
                writer.append(',');
                writer.append(gameType);
                writer.append('\n');


                //generate whatever data you want
                writer.flush();
                writer.close();
            }
            else{
                FileWriter writer = new FileWriter(gpxfile, true);
                writer.append("name");
                writer.append(',');
                writer.append("age");
                writer.append(',');
                writer.append("right answer to choose(R or L)");
                writer.append(',');
                writer.append("react time");
                writer.append(',');
                writer.append("left monster property");
                writer.append(',');
                writer.append("right monster property");
                writer.append(',');
                writer.append("right(1) or wrong(0)");
                writer.append(',');
                writer.append("date");
                writer.append(',');
                writer.append("game Type");
                writer.append('\n');
                writer.append(id);
                writer.append(',');
                writer.append(age);
                writer.append(',');
                writer.append(leftOrRight);
                writer.append(',');
                writer.append(reactTime);
                writer.append(',');
                writer.append(leftMonsterTime);
                writer.append(',');
                writer.append(rightMonsterTime);
                writer.append(',');
                writer.append(rightOrWrong);
                writer.append(',');
                writer.append(date);
                writer.append(',');
                writer.append(gameType);
                writer.append('\n');


                //generate whatever data you want
                writer.flush();
                writer.close();

            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void writeUserName(String sFileName,String username){
        try
        {
            File root = Environment.getExternalStorageDirectory();
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(username);

            //generate whatever data you want
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String readUserName(String filename)
    {
        String username = null;

        File f = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator + filename);
        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            username = br.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return username;
    }
}
