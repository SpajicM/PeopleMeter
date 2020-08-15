package hr.zavrsni.peoplemeter.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONObject;

import hr.zavrsni.peoplemeter.models.Feedback;
import hr.zavrsni.peoplemeter.utils.GsonSingleton;
import hr.zavrsni.peoplemeter.utils.Urls;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;
import hr.zavrsni.peoplemeter.utils.volley.VolleyUtils;

public class ProgramService {

    private VolleyUtils volley;

    public ProgramService(Context context) {
        volley = new VolleyUtils(context);
    }

    public void postFeedback(int programId, Feedback feedback, final VolleyResponseListener<Feedback> listener) {
        volley.requestObject(Request.Method.POST, Urls.PROGRAM_URL + programId + "/feedbacks", feedback,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Feedback feedbackResponse = GsonSingleton.getInstance().getGson().fromJson(response.toString(), Feedback.class);
                        listener.onResponse(feedbackResponse);
                    }
                });
    }
}
