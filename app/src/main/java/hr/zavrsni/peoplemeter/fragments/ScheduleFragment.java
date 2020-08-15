package hr.zavrsni.peoplemeter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import hr.zavrsni.peoplemeter.activities.CommentActivity;
import hr.zavrsni.peoplemeter.activities.ScheduleActivity;
import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.models.Schedule;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends ListFragment {

    private ArrayAdapter adapter;
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public ScheduleFragment() {
        // Required empty public constructor
    }

    private void loadData() {
        if(getActivity() != null) {
         Channel channel = (Channel) getActivity().getIntent().getSerializableExtra(ScheduleActivity.KEY_BUNDLE_CHANNEL);
            if (channel != null) {
                schedules.clear();
                schedules.addAll(channel.getSchedules());
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1, schedules);
        setListAdapter(adapter);
        loadData();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        Schedule schedule = schedules.get(pos);

        Intent intent = new Intent(getActivity(), CommentActivity.class);
        intent.putExtra(CommentActivity.KEY_BUNDLE_SCHEDULE, schedule);
        startActivity(intent);

    }
}
