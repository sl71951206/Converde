package pe.converde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        Button btnCalculadora = findViewById(R.id.btnCalculadora);
        Button btnInfo = findViewById(R.id.btnInfo);

        btnCalculadora.setOnClickListener(view -> {
            Intent intent = new Intent(BackActivity.this, CalcActivity.class);
            startActivity(intent);
        });
        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(BackActivity.this, InfoActivity.class);
            startActivity(intent);
        });
    }
}