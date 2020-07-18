package hr.zavrsni.peoplemeter.activities;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Button submitButton = findViewById(R.id.button_submit_comment);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommentActivity.this, ChannelListActivity.class);
                startActivity(intent);
            }
        });
    }
}
