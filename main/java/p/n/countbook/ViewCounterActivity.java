package p.n.countbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */

public class ViewCounterActivity extends MasterCounterListControl {
    public static final String EXTRA_MESSAGE = "com.int.countbook.MESSAGE";
    public static final String CNTR_STREAM = "com.int.countbook.STREAM";
    private int itemkey;
    private Counter counter;
    private TextView NameView;
    private TextView CountView;
    private TextView InitialView;
    private TextView CommentView;
    private TextView DateView;

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_counter);
        NameView = (TextView) findViewById(R.id.NameView);
        CountView = (TextView) findViewById(R.id.CountView);
        InitialView = (TextView) findViewById(R.id.InitialView);
        CommentView = (TextView) findViewById(R.id.CommentView);
        DateView = (TextView) findViewById(R.id.DateView);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //loadFromFile(); No longer needed--intent
        Counters = (ArrayList<Counter>) intent.getSerializableExtra(CNTR_STREAM);
        itemkey = Integer.parseInt(intent.getStringExtra(EXTRA_MESSAGE));
        counter = Counters.get(itemkey);

        String name = counter.getName() + " Counter" ;
        String count = "Count: " + counter.getCurrent_value();
        String initcount = "Start Count: " + counter.getInitial_value();
        String comment = "";
        if ( counter.getComment().trim().length() > 0 ) {
            comment = "Comment: " + counter.getComment();
        }
        String date = "Last modified: " + counter.getDate();

        //TextView NameView = (TextView) findViewById(R.id.NameView);
        NameView.setText(name);
        //TextView CountView = (TextView) findViewById(R.id.CountView);
        CountView.setText(count);
        //TextView InitialView = (TextView) findViewById(R.id.InitialView);
        InitialView.setText(initcount);
        //TextView CommentView = (TextView) findViewById(R.id.CommentView);
        CommentView.setText(comment);
        //TextView DateView = (TextView) findViewById(R.id.DateView);
        DateView.setText(date);
    }

    /**
     *
     * @param view
     */

    public void editCounter(View view) {
        String key = (itemkey + "").trim();
        if (key.length() > 0 ) {
            Intent intenty = new Intent(this, EditCounterActivity.class);
            intenty.putExtra(CNTR_STREAM, Counters);
            intenty.putExtra(EXTRA_MESSAGE, key);
            startActivity(intenty);
        }
    }

    /**
     *
     * @param view
     */

    public void upCounter(View view) {
        //loadFromFile(); No longer needed--intent
        //Counter counter = Counters.get(itemkey);
        counter.upCount();
        //counter.update();
        saveInFile(Counters);

        String count = "Count: " + counter.getCurrent_value();
        String date = "Last modified: " + counter.getDate();
        CountView.setText(count);
        DateView.setText(date);
    }

    /**
     *
     * @param view
     */

    public void downCounter(View view) {
        //loadFromFile(); No longer needed--intent
        //Counter counter = Counters.get(itemkey);
        counter.downCount();
        //counter.update();
        saveInFile(Counters);

        String count = "Count: " + counter.getCurrent_value();
        String date = "Last modified: " + counter.getDate();
        CountView.setText(count);
        DateView.setText(date);
    }

    /**
     *
     * @param view
     */

    public void resetCounter(View view) {
        //loadFromFile(); No longer needed--intent
        //Counter counter = Counters.get(itemkey);
        counter.resetCurrent_value();
        //counter.update();
        saveInFile(Counters);

        String count = "Count: " + counter.getCurrent_value();
        String date = "Last modified: " + counter.getDate();
        CountView.setText(count);
        DateView.setText(date);
    }

    /**
     *
     * @param view
     */

    public void deleteCounter(View view) {
        Intent intent = new Intent(this, CounterListActivity.class);
        //loadFromFile(); No longer needed--intent
        Counters.remove(counter);
        saveInFile(Counters);
        startActivity(intent);
    }
}
