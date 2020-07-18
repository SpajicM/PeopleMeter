package hr.zavrsni.peoplemeter.services;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.utils.Urls;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;
import hr.zavrsni.peoplemeter.utils.volley.VolleyUtils;


public class ChannelService {

    private VolleyUtils volley;

    public ChannelService(Context context) {
        volley = new VolleyUtils(context);
    }

    public void getChannelById(int id, final VolleyResponseListener<Channel> listener) {
        volley.requestObject(Request.Method.GET, Urls.CHANNEL_URL + id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Channel channel = new Gson().fromJson(response.toString(), Channel.class);
                        listener.onResponse(channel);
                    }
                });
    }

    public void getAllChannels(final VolleyResponseListener<List<Channel>> listener) {
        volley.requestArray(Request.Method.GET, Urls.CHANNEL_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        List<Channel> channels = Arrays.asList(new Gson().fromJson(response.toString(), Channel[].class));
                        listener.onResponse(channels);
                    }
                });
    }
}
