package p.n.countbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static p.n.countbook.R.id.parent;

/**
 *
 *
 */

public class CounterListActivity extends MasterCounterListControl{
    public static final String EXTRA_MESSAGE = "com.int.countbook.MESSAGE";
    public static final String CNTR_STREAM = "com.int.countbook.STREAM";
    private ListView CounterlistView;
    private TextView CounterCountView;
    private ArrayAdapter<Counter> adapter;

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);
        CounterlistView = (ListView) findViewById(R.id.CounterlistView);
        CounterCountView = (TextView) findViewById(R.id.Counters);

        /**https://stackoverflow.com/questions/8126175/android-how-to-add-an-item-click-method-to-an-arrayadapter?rq=1*/
        CounterlistView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                viewCounter(view, position);
            }
        });

    }

    /**
     *
     * @param view
     */

    public void newCounter(View view) {
        Intent intenty = new Intent(this, NewCounterActivity.class);
        intenty.putExtra(CNTR_STREAM, Counters);
        startActivity(intenty);
    }

    /**
     *
     * @param view
     * @param itemkey
     */

    public void viewCounter(View view, int itemkey) {
        //Counter counter1 = new Counter("Hello", 44, "goodbye");
        //Counters.add(counter1);
        //saveInFile();
        //adapter.notifyDataSetChanged();
        String key = (itemkey + "").trim();
        if (key.length() > 0 ) {
            Intent intent = new Intent(this, ViewCounterActivity.class);
            intent.putExtra(EXTRA_MESSAGE, key);
            intent.putExtra(CNTR_STREAM, Counters);
            startActivity(intent);
        }
    }

    /**
     *
     */

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Counters = loadFromFile();
        adapter = new ArrayAdapter<Counter>(this, R.layout.listformat, Counters); //new stuff
        CounterlistView.setAdapter(adapter);// new stuff
        String CountCount = Counters.size() + " Counters";
        CounterCountView.setText(CountCount);
    }
}
