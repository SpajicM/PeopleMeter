package hr.zavrsni.peoplemeter.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import hr.zavrsni.peoplemeter.models.ChosenSchedule;
import hr.zavrsni.peoplemeter.utils.GsonSingleton;
import hr.zavrsni.peoplemeter.utils.Urls;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;
import hr.zavrsni.peoplemeter.utils.volley.VolleyUtils;

public class ReminderService {

    private VolleyUtils volley;

    public ReminderService(Context context) {
        volley = new VolleyUtils(context);
    }

    public void setReminder(ChosenSchedule chosenSchedule, final VolleyResponseListener<String> listener) {
        volley.requestString(Request.Method.POST, Urls.REMINDER_URL, chosenSchedule,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            listener.onResponse(response);
                    }
                });
    }
}
