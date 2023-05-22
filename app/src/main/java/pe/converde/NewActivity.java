package pe.converde;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Bundle bundle = getIntent().getExtras();

        ScrollView sclView = findViewById(R.id.sclView);
        TextView txtEspacio = findViewById(R.id.txtEspacio);
        ImageView imgEspacio = findViewById(R.id.imgEspacio);

        sclView.setBackgroundResource(bundle.getInt("color"));
        String espacio = txtEspacio.getText().toString() + bundle.getString("espacio");
        txtEspacio.setText(espacio);
        imgEspacio.setImageResource(bundle.getInt("drawable"));


        List<String> nom_artefactos = new ArrayList<>();
        List<Integer> imagenes = new ArrayList<>();
        List<Double> potencias = new ArrayList<>();
        List<String> recomendaciones = new ArrayList<>();
        ArtefactoDao artefactoDao = new ArtefactoDao();
        for (Artefacto artefacto: artefactoDao.getArtefactos(bundle.getString("espacio"))) {
            nom_artefactos.add(artefacto.getNom_artefacto());
            imagenes.add(artefacto.getImagen());
            potencias.add(artefacto.getPotencia());
            recomendaciones.add(artefacto.getRecomendacion());
        }

        Spinner spnArtefactos = findViewById(R.id.spnArtefactos);
        ArrayAdapter<String> adapterArtefactos = new ArrayAdapter<>(this, R.layout.spinner_item, nom_artefactos);
        spnArtefactos.setAdapter(adapterArtefactos);

        ImageView imgFoto = findViewById(R.id.imgFoto);
        imgFoto.setImageResource(imagenes.get(0));
        TextView txtDetalle = findViewById(R.id.txtDetalle);
        txtDetalle.setText(recomendaciones.get(0));


        spnArtefactos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgFoto.setImageResource(imagenes.get(i));
                txtDetalle.setText(recomendaciones.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}