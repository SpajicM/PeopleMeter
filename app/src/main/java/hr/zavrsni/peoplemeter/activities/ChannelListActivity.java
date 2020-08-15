package hr.zavrsni.peoplemeter.activities;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.adapters.ChannelListAdapter;
import hr.zavrsni.peoplemeter.adapters.IChannelListAdapter;
import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.services.ChannelService;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;

public class ChannelListActivity extends AppCompatActivity implements IChannelListAdapter {

    final List<Channel> channelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);


        final ChannelListAdapter channelListAdapter = new ChannelListAdapter(this, this);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(channelListAdapter);

        channelListAdapter.setChannels(channelList);

        ChannelService channelService = new ChannelService(this);
        channelService.getChannelsToday(new VolleyResponseListener<List<Channel>>() {
            @Override
            public void onResponse(List<Channel> response) {
                channelList.addAll(response);
                channelListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onChannelClicked(int position) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra(ScheduleActivity.KEY_BUNDLE_CHANNEL, channelList.get(position));
        startActivity(intent);

    }
}
