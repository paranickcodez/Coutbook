package p.n.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */

public class EditCounterActivity extends MasterCounterListControl {
    public static final String EXTRA_MESSAGE = "com.int.countbook.MESSAGE";
    public static final String CNTR_STREAM = "com.int.countbook.STREAM";
    protected int itemkey;
    private Counter counter;
    private EditText NameEdit;
    private EditText CountEdit;
    private EditText InitialEdit;
    private EditText CommentEdit;

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);
        NameEdit = (EditText) findViewById(R.id.name);
        CountEdit = (EditText) findViewById(R.id.count);
        InitialEdit = (EditText) findViewById(R.id.initial);
        CommentEdit = (EditText) findViewById(R.id.comment);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //loadFromFile(); No longer needed--intent
        Counters = (ArrayList<Counter>) intent.getSerializableExtra(CounterListActivity.CNTR_STREAM);
        itemkey = Integer.parseInt(intent.getStringExtra(ViewCounterActivity.EXTRA_MESSAGE));
        counter = Counters.get(itemkey);
        //Add EditText settexts, using getters. Then using, with checks, setters with startapp to change name, countx2, comments and then update date.

        String name = counter.getName();
        String count = "" + counter.getCurrent_value();
        String initcount = "" + counter.getInitial_value();
        String comment = counter.getComment();

        //EditText NameEdit = (EditText) findViewById(R.id.name);
        NameEdit.setText(name);
        //EditText CountEdit = (EditText) findViewById(R.id.count);
        CountEdit.setText(count.trim());
        //EditText InitialEdit = (EditText) findViewById(R.id.initial);
        InitialEdit.setText(initcount.trim());
        //EditText CommentEdit = (EditText) findViewById(R.id.comment);
        CommentEdit.setText(comment);
    }

    /**
     *
     * @param view
     */

    public void startApp(View view) {

        String key = (itemkey + "").trim();
        String name = NameEdit.getText().toString().trim();
        //https://stackoverflow.com/questions/15037465/converting-edittext-to-int-android
        String count = CountEdit.getText().toString().trim();
        String initcount = InitialEdit.getText().toString().trim();
        String comment = CommentEdit.getText().toString().trim();

        if ((name.length() > 0 ) && (count.length() > 0 ) && (initcount.length() > 0 ) && (key.length() > 0 )){
            //loadFromFile(); No longer needed--intent
            Intent intent = new Intent(this, ViewCounterActivity.class);
            intent.putExtra(CNTR_STREAM, Counters);
            intent.putExtra(EXTRA_MESSAGE, key);

            counter.setName(name);
            counter.setCurrent_value(Integer.parseInt(count));
            counter.setInitial_value(Integer.parseInt(initcount));
            counter.setComment(comment);
            //counter.update();

            saveInFile(Counters);
            startActivity(intent);
        }
    }
}
