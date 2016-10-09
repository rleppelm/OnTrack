package capstone.ontrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(android.view.View view) {

        android.content.Intent intent = new android.content.Intent(this, AccountActivity.class);
        startActivity(intent);
        // Do something in response to button
    }
}
