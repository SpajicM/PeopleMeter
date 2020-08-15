package hr.zavrsni.peoplemeter.services;
import android.content.Context;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import hr.zavrsni.peoplemeter.models.ActivationUserModel;
import hr.zavrsni.peoplemeter.models.Channel;
import hr.zavrsni.peoplemeter.models.User;
import hr.zavrsni.peoplemeter.utils.Urls;
import hr.zavrsni.peoplemeter.utils.volley.VolleyResponseListener;
import hr.zavrsni.peoplemeter.utils.volley.VolleyUtils;


public class UserService {

    private VolleyUtils volley;

    public UserService(Context context) {
        volley = new VolleyUtils(context);
    }

    public void register(User user, final VolleyResponseListener<String> listener) {
        volley.requestObject(Request.Method.POST, Urls.REGISTER_URL, user,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onResponse(response.toString());
                    }
                });
    }

    public void enterCode(ActivationUserModel activationUserModel, final VolleyResponseListener<User> listener) {
        volley.requestObject(Request.Method.POST, Urls.ACTIVATION_URL, activationUserModel,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User user = new Gson().fromJson(response.toString(), User.class);
                        listener.onResponse(user);
                    }
                });
    }
}
