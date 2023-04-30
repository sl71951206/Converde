package pe.converde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageButton imbCocina = findViewById(R.id.imbCocina);
        ImageButton imbLavanderia = findViewById(R.id.imbLavanderia);
        ImageButton imbCuartoBano = findViewById(R.id.imbCuartoBano);
        ImageButton imbSalaOcio = findViewById(R.id.imbSalaOcio);

        imbCocina.setOnClickListener(funcion(R.color.cocina, "COCINA", R.drawable.cocina));
        imbLavanderia.setOnClickListener(funcion(R.color.lavanderia, "LAVANDERÍA", R.drawable.lavanderia));
        imbCuartoBano.setOnClickListener(funcion(R.color.cuarto_bano, "CUARTO CON BAÑO", R.drawable.cuarto_bano));
        imbSalaOcio.setOnClickListener(funcion(R.color.sala_ocio, "SALA Y OCIO", R.drawable.sala_ocio));
    }

    public View.OnClickListener funcion(int color, String espacio, int drawable) {
        return view -> {
            Intent intent = new Intent(InfoActivity.this, NewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("color", color);
            bundle.putString("espacio", espacio);
            bundle.putInt("drawable", drawable);
            intent.putExtras(bundle);
            startActivity(intent);
        };
    }
}