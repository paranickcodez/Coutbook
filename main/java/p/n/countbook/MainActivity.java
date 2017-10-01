package p.n.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *
 */

public class MainActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     */

    public void startApp(View view) {
        /** Called when the user taps the Count Ah-ha-ha */
        Intent intent = new Intent(this, CounterListActivity.class);
        startActivity(intent);
    }

}
