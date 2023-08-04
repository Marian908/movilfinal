package com.pena.kelly.istabar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private WebView xampp;
    private WebSettings xamppSetting;
    //private static final String BASE_URL = "http://localhost/wordpress"; // Cambia la dirección según tu servidor local
    private static final String BASE_URL = " http://10.0.2.2/wordpress/wp-json/wc/v3/";
    private Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inicializar WebView y configurar el cliente
        xampp = findViewById(R.id.IstaBar);
        xamppSetting = xampp.getSettings();
        xamppSetting.setJavaScriptEnabled(true);

        // Cargar página web en el WebView
        xampp.loadUrl(BASE_URL);

}
}