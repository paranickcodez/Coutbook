package p.n.countbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 *
 */

public class NewCounterActivity extends MasterCounterListControl {
    public static final String CNTR_STREAM = "com.int.countbook.STREAM";

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_counter);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Counters = (ArrayList<Counter>) intent.getSerializableExtra(CounterListActivity.CNTR_STREAM);
    }

    /**
     *
     * @param view
     */

    public void startApp(View view) {

        EditText nameET = (EditText) findViewById(R.id.Name);
        EditText countET = (EditText) findViewById(R.id.Count);
        EditText commentET = (EditText) findViewById(R.id.Comment);
        String name = nameET.getText().toString().trim();
        //https://stackoverflow.com/questions/15037465/converting-edittext-to-int-android
        String count = countET.getText().toString().trim();
        String comment = commentET.getText().toString().trim();

        if ((count.length() > 0 ) && (name.length() > 0 )){
            //loadFromFile();
            Intent intent = new Intent(this, CounterListActivity.class);

            Counter counter = new Counter(name, Integer.parseInt(count), comment);
            Counters.add(counter);

            saveInFile(Counters);
            startActivity(intent);
        }else{}
    }

}
