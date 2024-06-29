package com.example.studentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddStudent extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    AppCompatButton b1;

    String apiUrl="https://courseapplogix.onrender.com/addstudents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);

        e1=(EditText) findViewById(R.id.fname);
        e2=(EditText) findViewById(R.id.lname);
        e3=(EditText) findViewById(R.id.clg);
        e4=(EditText) findViewById(R.id.dob);
        e5=(EditText) findViewById(R.id.course);
        e6=(EditText) findViewById(R.id.mob);
        e7=(EditText) findViewById(R.id.email);
        e8=(EditText) findViewById(R.id.addre);
        b1=(AppCompatButton) findViewById(R.id.submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getfirstname=e1.getText().toString();
                String getlastname=e2.getText().toString();
                String getcollege=e3.getText().toString();
                String getdob=e4.getText().toString();
                String getcourse=e5.getText().toString();
                String getmobile=e6.getText().toString();
                String getemail=e7.getText().toString();
                String getaddresse=e8.getText().toString();

                JSONObject student=new JSONObject();

                try {
                    student.put("firstname",getfirstname);
                    student.put("lastname",getlastname);
                    student.put("college",getcollege);
                    student.put("dob",getdob);
                    student.put("course",getcourse);
                    student.put("mobile",getmobile);
                    student.put("email",getemail);
                    student.put("address",getaddresse);
                }
                catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                            }
                        },
                new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_LONG).show();
                            }
                        }


                );
                RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);



            }
        }
        );



    }
}