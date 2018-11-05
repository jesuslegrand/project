package com.example.jesuslegrand.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionFragment extends Fragment implements Response.Listener<JSONObject>,
        Response.ErrorListener {

    RequestQueue requestQueue;
    JsonRequest jsonRequest;

    EditText cajaUser, cajaPwd;
    Button btnConsultar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_session, container, false);

        View vista = inflater.inflate(R.layout.fragment_session, container, false);

        cajaUser = (EditText) vista.findViewById(R.id.txtUser);
        cajaPwd = (EditText) vista.findViewById(R.id.txtPwd);
        btnConsultar = (Button) vista.findViewById(R.id.btnSesion);

        requestQueue = Volley.newRequestQueue(getContext());

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        return vista;
    }



    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(getContext(),"Usuario incorrecto. Por favor verifique sus datos. "
                + error.toString()+cajaUser.getText().toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {

        User usuario = new User();
        Toast.makeText(getContext(),"Usuario correcto." + cajaUser.getText().toString(),
                Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {

            jsonObject = jsonArray.getJSONObject(0);
            usuario.setUser(jsonObject.optString("user"));
            usuario.setPwd(jsonObject.optString( "pwd"));
            usuario.setNames(jsonObject.getString("names"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void iniciarSesion(){

        String url = "https://antiacosapp.000webhostapp.com/session.php?user="+cajaUser.getText().toString()
                +"&pwd="+cajaPwd.getText().toString();

        //String url = "http://192.168.1.68/login/session.php?user="+cajaUser.getText().toString()
        // +"&pwd="+cajaPwd.getText().toString();

        jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, this,
                this);
        requestQueue.add(jsonRequest);

    }
}
