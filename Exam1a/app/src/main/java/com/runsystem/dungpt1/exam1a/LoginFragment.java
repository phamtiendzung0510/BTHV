package com.runsystem.dungpt1.exam1a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dungpt1 on 04-Aug-17.
 */

public class LoginFragment extends Fragment {

    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";

    private final String DefaultUnameValue = "";
    private String UnameValue;

    private final String DefaultPasswordValue = "";
    private String PasswordValue;

    Button btnConnect;
    EditText etUserName, etPassword;
    public static String TOKEN = "";

    public LoginFragment(){
    }

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.login_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnConnect = (Button) getActivity().findViewById(R.id.btnConnect);

        etUserName = (EditText) getActivity().findViewById(R.id.edtUserName);
        etPassword = (EditText) getActivity().findViewById(R.id.edtPassword);

        btnConnect.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String strName = etUserName.getText().toString();
                String strPass = etPassword.getText().toString();
                requestLogin(strName, strPass);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        savePreferences();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadPreferences();
    }

    private void requestLogin(final String user, final String pass){

        String url = "http://33.version-test.com/app/service/login";

        StringRequest loginRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        DebugLog.i(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String message = jsonObject.getString("message");
                            if (message.equals("ok")){
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,MenuFragment.newInstance()).commit();
                            } else {
                                Toast.makeText(getActivity(), "User name or password wrong, please check again", Toast.LENGTH_SHORT).show();
                            }
//                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            TOKEN = jsonObject.getString("token");
                            DebugLog.i("TOKEN: " + TOKEN);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        DebugLog.i(error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("fullname", user);
                params.put("password", pass);
                return params;
            }
        };
        NetworkUtil.getsInstance(getActivity().getApplicationContext()).addToRequestQueue(loginRequest);
    }

    private void savePreferences() {
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // Edit and commit
        UnameValue = String.valueOf(etUserName.getText());
        PasswordValue = String.valueOf(etPassword.getText());
        System.out.println("onPause save name: " + UnameValue);
        System.out.println("onPause save password: " + PasswordValue);
        editor.putString(PREF_UNAME, String.valueOf(UnameValue));
        editor.putString(PREF_PASSWORD, String.valueOf(PasswordValue));
        editor.commit();
    }

    private void loadPreferences() {

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        etUserName.setText(UnameValue);
        etPassword.setText(PasswordValue);
        System.out.println("onResume load name: " + UnameValue);
        System.out.println("onResume load password: " + PasswordValue);
    }

}
