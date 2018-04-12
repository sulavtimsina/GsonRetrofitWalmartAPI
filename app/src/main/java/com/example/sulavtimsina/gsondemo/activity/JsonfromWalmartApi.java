package com.example.sulavtimsina.gsondemo.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sulavtimsina.gsondemo.R;
import com.example.sulavtimsina.gsondemo.model.Product;
import com.example.sulavtimsina.gsondemo.utils.ApiClient;
import com.example.sulavtimsina.gsondemo.utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class JsonfromWalmartApi extends AppCompatActivity {

    TextView tvOutput;
    EditText tvInput;
    Button btnSubmit;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonfrom_localhost_api);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);
        btnSubmit = findViewById(R.id.btnSubmit);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        buttonClick();


    }

    private void buttonClick() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemId = Integer.parseInt(tvInput.getText().toString());
                // The second argument of getProduct is the API_KEY which I have stored in a resource
                // file in res/values folder. You can just paste your API keY here.
                Call<Product> call = apiInterface.getProduct(itemId,getString(R.string.apiKey), "json" );

                call.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(@NonNull Call<Product> call, Response<Product> response) {
                        int itemId = response.body().getItemId();
                        String upc = response.body().getUpc();
                        tvOutput.setText("Item id: "+itemId+" UPC: "+upc);
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        tvOutput.setText(t.toString());
                    }
                });
            }
        });

    }
}
