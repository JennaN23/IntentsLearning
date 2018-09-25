package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button buttonSendMsg;
    private Button buttonShare;
    private EditText editTextMsg;

    public static final String EXTRA_SENT_MSG = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();
        buttonSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMsg.getText().toString();
                Intent intentSendMsg = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                intentSendMsg.putExtra(EXTRA_SENT_MSG, message);
                startActivity(intentSendMsg);
            }
        });

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(EXTRA_SENT_MSG, editTextMsg.getText().toString());
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        buttonSendMsg = findViewById(R.id.button_sendmessage_send);
        buttonShare = findViewById(R.id.button_sendmessage_share);
        editTextMsg = findViewById(R.id.edittext_sendmessage_msg);
    }
}
