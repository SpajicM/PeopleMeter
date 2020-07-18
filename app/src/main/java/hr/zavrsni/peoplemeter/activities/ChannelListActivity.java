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

public class ChannelListActivity extends AppCompatActivity implements IChannelListAdapter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);


        final ChannelListAdapter channelListAdapter = new ChannelListAdapter(this, this);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(channelListAdapter);

        List<Channel> channelList = new ArrayList<>();

        // temporary, call service here
        Channel HRT1 = new Channel(0, "HRT 1", "");
        Channel HRT2 = new Channel(1, "HRT 2", "");
        Channel RTL = new Channel(2, "RTL", "");
        Channel Nova = new Channel(3, "Nova", "");


        channelList.add(HRT1);
        channelList.add(HRT2);
        channelList.add(RTL);
        channelList.add(Nova);

        channelListAdapter.setChannels(channelList);
    }

    @Override
    public void onChannelClicked(int position) {
        // TODO: pass id or position with intent
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);

    }
}
