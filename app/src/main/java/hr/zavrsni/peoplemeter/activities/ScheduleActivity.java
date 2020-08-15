package hr.zavrsni.peoplemeter.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.fragments.ScheduleFragment;


public class ScheduleActivity extends AppCompatActivity {

    public static final String KEY_BUNDLE_CHANNEL = "CHANNEL";

    ScheduleFragment scheduleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        scheduleFragment = (ScheduleFragment) getSupportFragmentManager().findFragmentById(R.id.schedule_list_fragment);
    }
}
