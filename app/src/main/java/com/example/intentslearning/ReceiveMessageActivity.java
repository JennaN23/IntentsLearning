package com.example.intentslearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    private TextView textViewDisplayMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        wireWidgets();
    }

    private void wireWidgets() {
        textViewDisplayMsg = findViewById(R.id.textview_receivemessage_displaymsg);
        textViewDisplayMsg.setText(getIntent().getStringExtra(SendMessageActivity.EXTRA_SENT_MSG));
    }
}
