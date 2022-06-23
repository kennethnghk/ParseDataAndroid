package im.tobe.parsedataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            // display the contents
            Log.d("Main", "onCreate: "+response.substring(0, 300));
        }, error -> {
            Log.d("Main", "Failed to get");
        });

        queue.add(stringRequest);
    }
}