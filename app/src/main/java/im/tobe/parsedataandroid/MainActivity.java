package im.tobe.parsedataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        getString(queue);
    }

    private void getString(RequestQueue queue) {
        String url = "https://jsonplaceholder.typicode.com/comments";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            // display the contents
            Log.d("Main", "onCreate: "+response.toString());
        }, error -> {
            Log.d("Main", "Failed to get: "+error.getLocalizedMessage());
        });

        queue.add(jsonArrayRequest);
    }
}