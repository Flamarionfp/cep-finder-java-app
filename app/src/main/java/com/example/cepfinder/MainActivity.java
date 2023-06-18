package com.example.cepfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cepfinder.dtos.GetAddressByCepDTO;
import com.example.cepfinder.entities.Address;
import com.example.cepfinder.providers.ViaCepGetAddressByCep;
import com.example.cepfinder.services.GetAddressByCep;
import com.example.cepfinder.utils.FormatAddress;

public class MainActivity extends AppCompatActivity {
    private EditText editPostalCode;
    private TextView textAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPostalCode = findViewById(R.id.editPostalCode);
        textAddress = findViewById(R.id.textAddress);
    }

    private void updateAddressUI(Address address){
        String formattedAddress = FormatAddress.toString(address);

        textAddress.setText(formattedAddress);
    }

    public void handleSearchAddress(View view) {
        String postalCode = editPostalCode.getText().toString();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GetAddressByCepDTO viaCepGetAddressByCep = new ViaCepGetAddressByCep();
                    GetAddressByCep getAddressByCep = new GetAddressByCep(viaCepGetAddressByCep);

                    final Address address = getAddressByCep.execute(postalCode);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateAddressUI(address);
                        }
                    });
                } catch (final Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });

        thread.start();
    }
}