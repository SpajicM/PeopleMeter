package hr.zavrsni.peoplemeter.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;

import hr.zavrsni.peoplemeter.models.ChosenSchedule;
import hr.zavrsni.peoplemeter.utils.Urls;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;
import hr.zavrsni.peoplemeter.utils.volley.VolleyUtils;

public class WatchListService {

    private VolleyUtils volley;

    public WatchListService(Context context) {
        volley = new VolleyUtils(context);
    }

    public void addToWatchlist(ChosenSchedule chosenSchedule, final VolleyResponseListener<String> listener) {
        volley.requestString(Request.Method.POST, Urls.WATCHLIST_URL, chosenSchedule,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                });
    }
}
