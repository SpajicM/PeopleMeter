package hr.zavrsni.peoplemeter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hr.zavrsni.peoplemeter.R;
import hr.zavrsni.peoplemeter.models.Channel;


public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Channel> mChannels;

    private IChannelListAdapter listener;

    public ChannelListAdapter(Context context, IChannelListAdapter listener) {
        mLayoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(mLayoutInflater
                .inflate(R.layout.recycler_channel_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // images from db, channel logo?
        final String imageUrl = "https://www.clipartkey.com/mpngs/m/75-752419_in-the-mean-time-watch-a-little-television.png";
        final String name = mChannels.get(position).getName();
        viewHolder.setData(imageUrl, name);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onChannelClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    public void setChannels(List<Channel> mChannels) {
        this.mChannels = mChannels;
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // Views
        private ImageView mImageView;
        private TextView mNameTextView;

        private ViewHolder(View itemView) {
            super(itemView);

            // Get references to image and name.
            mImageView = itemView.findViewById(R.id.channel_image);
            mNameTextView = itemView.findViewById(R.id.name);
        }

        private void setData(String imageUrl, String name) {
            mNameTextView.setText(name);
            Picasso.get().load(imageUrl).into(mImageView);
        }
    }
}