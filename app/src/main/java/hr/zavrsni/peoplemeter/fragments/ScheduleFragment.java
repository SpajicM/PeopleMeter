package hr.zavrsni.peoplemeter.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.activities.CommentActivity;
import hr.zavrsni.peoplemeter.activities.ScheduleActivity;
import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.models.ChosenSchedule;
import hr.zavrsni.peoplemeter.models.Schedule;
import hr.zavrsni.peoplemeter.services.ReminderService;
import hr.zavrsni.peoplemeter.services.WatchListService;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;

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
        final Schedule schedule = schedules.get(pos);
        final ChosenSchedule chosenSchedule = new ChosenSchedule(schedule.getId());

        final String[] options = {"Add to watchlist", "Set reminder", "Post feedback"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        AddToWatchList(chosenSchedule);
                        break;
                    case 1:
                        SetReminder(chosenSchedule);
                        break;
                    case 2:
                        PostFeedback(schedule);
                        break;
                }
            }
        });
        builder.show();

    }

    private void AddToWatchList(ChosenSchedule chosenSchedule) {
        new WatchListService(getActivity()).addToWatchlist(chosenSchedule, new VolleyResponseListener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("true")) {
                    Toast.makeText(getActivity(), getString(R.string.added_to_watchlist), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void SetReminder(ChosenSchedule chosenSchedule) {
        new ReminderService(getActivity()).setReminder(chosenSchedule, new VolleyResponseListener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("true")) {
                    Toast.makeText(getActivity(), getString(R.string.added_to_watchlist), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void PostFeedback(Schedule schedule) {
        Intent intent = new Intent(getActivity(), CommentActivity.class);
        intent.putExtra(CommentActivity.KEY_BUNDLE_SCHEDULE, schedule);
        startActivity(intent);
    }
}
