package p.n.countbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by N on 9/23/2017.
 */

public class MasterCounterListControl extends AppCompatActivity{
    protected static final String FILENAME = "file.sav";
    protected ArrayList<Counter> Counters = new ArrayList<Counter>();

    /**
     *
     * @return
     */

    protected ArrayList<Counter> loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Counter>>() {}.getType();
            return gson.fromJson(in, listType);
            //https://github.com/google/gson/blob/master/UserGuide.md#TOC-Collections-Examples

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return new ArrayList<Counter>();
        } catch ( IOException e) {
            //TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param Counters
     */

    protected void saveInFile(ArrayList<Counter> Counters) {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);

            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(Counters, writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}