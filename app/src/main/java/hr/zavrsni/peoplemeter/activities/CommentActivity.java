package hr.zavrsni.peoplemeter.activities;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.Feedback;
import hr.zavrsni.peoplemeter.models.Schedule;
import hr.zavrsni.peoplemeter.utils.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CommentActivity extends AppCompatActivity {

    public static final String KEY_BUNDLE_SCHEDULE = "SCHEDULE";

    private Schedule schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            schedule = (Schedule)getIntent().getSerializableExtra(KEY_BUNDLE_SCHEDULE); //Obtaining data
        }

        Button submitButton = findViewById(R.id.button_submit_comment);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommentActivity.this, ChannelListActivity.class);
                // submit feedback
                Feedback feedback = new Feedback("naslov", "opis", Auth.getUser(), schedule.getProgram());
                startActivity(intent);
            }
        });
    }
}
