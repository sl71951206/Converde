package pe.converde;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class CalcActivity extends AppCompatActivity {

    private EditText edtPotencia, edtDias, edtHoras, edtMinutos, edtConsumo, edtCantidad, edtPrecio, edtTotal;
    private Spinner spnPotencia;
    private static String envConsumo;
    private static int chipCont;

    private TextInputEditText tiletiqueta;
    private Button btnAgregar,btnLimpiar;
    private ListView listViewEtiquetas;
    private List<String> listaetiqueta=new ArrayList<>();
    private  ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        listViewEtiquetas=findViewById(R.id.listviewEtiquetas);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnLimpiar=findViewById(R.id.btnLimpiar);

        tiletiqueta=findViewById(R.id.tilEtiquetaNombre);

        btnAgregar.setOnClickListener(view -> {

            String nombre="Artefacto: "+tiletiqueta.getText().toString().toUpperCase();
            String cantidad="Cantidad: "+edtCantidad.getText().toString();
            String total="Monto a Pagar: S/"+edtTotal.getText().toString();

            listaetiqueta.add(nombre+"\n"+cantidad+"\n"+total);
            Adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaetiqueta);
            listViewEtiquetas.setAdapter(Adapter);
            edtCantidad.getText().clear();
            edtTotal.getText().clear();

        });

        btnLimpiar.setOnClickListener(view -> {

            listViewEtiquetas.setAdapter(null);
            Adapter.clear();

        });

        edtPotencia = findViewById(R.id.edtPotencia);
        spnPotencia = findViewById(R.id.spnPotencia);
        edtDias = findViewById(R.id.edtDias);
        edtHoras = findViewById(R.id.edtHoras);
        edtMinutos = findViewById(R.id.edtMinutos);
        edtConsumo = findViewById(R.id.edtConsumo);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                funcion();
            }
        };
        edtPotencia.addTextChangedListener(textWatcher);
        spnPotencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                funcion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        edtDias.addTextChangedListener(textWatcher);
        edtHoras.addTextChangedListener(textWatcher);
        edtMinutos.addTextChangedListener(textWatcher);


        edtConsumo = findViewById(R.id.edtConsumo);
        TextWatcher textWatcherA = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String consumo = edtConsumo.getText().toString();
                if (edtConsumo.isEnabled() && !consumo.isEmpty()) {
                    edtPotencia.setEnabled(false);
                    edtDias.setEnabled(false);
                    edtMinutos.setEnabled(false);
                    edtHoras.setEnabled(false);
                    edtPotencia.setHint("—");
                    edtDias.setHint("—");
                    edtMinutos.setHint("—");
                    edtHoras.setHint("—");
                } else if (edtConsumo.isEnabled()) {
                    edtPotencia.setEnabled(true);
                    edtDias.setEnabled(true);
                    edtMinutos.setEnabled(true);
                    edtHoras.setEnabled(true);
                    edtPotencia.setHint("0");
                    edtDias.setHint("0");
                    edtMinutos.setHint("0");
                    edtHoras.setHint("0");
                }
            }
        };
        edtConsumo.addTextChangedListener(textWatcherA);


        edtCantidad = findViewById(R.id.edtCantidad);
        edtPrecio = findViewById(R.id.edtPrecio);
        edtTotal = findViewById(R.id.edtTotal);
        TextWatcher textWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String cantidad = edtCantidad.getText().toString();
                String consumo = edtConsumo.getText().toString();
                String precio = edtPrecio.getText().toString();
                if (!cantidad.isEmpty() && !consumo.isEmpty() && !precio.isEmpty()) {
                    double ca = Double.parseDouble(cantidad);
                    double co = Double.parseDouble(consumo);
                    double p = Double.parseDouble(precio);
                    edtTotal.setText(String.format("%.1f", ca * co * p));
                } else edtTotal.setText("");
            }
        };
        edtCantidad.addTextChangedListener(textWatcher2);
        edtPrecio.addTextChangedListener(textWatcher2);


        Chip chip = findViewById(R.id.chip);
        TextInputLayout tilEtiqueta = findViewById(R.id.tilEtiqueta);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.potencia, R.layout.spinner_item_mini);
        spnPotencia.setAdapter(adapter);
        chipCont = 0;
        chip.setOnClickListener(view -> {
            chipCont++;
            switch (chipCont) {
                case 1:
                    chip.setChipBackgroundColorResource(R.color.cocina);
                    break;
                case 2:
                    chip.setChipBackgroundColorResource(R.color.lavanderia);
                    break;
                case 3:
                    chip.setChipBackgroundColorResource(R.color.cuarto_bano);
                    break;
                case 4:
                    chip.setChipBackgroundColorResource(R.color.sala_ocio);
                    break;
                default:
                    chip.setChipBackgroundColorResource(R.color.e5);
                    break;
            }
            if (chipCont == 5) {
                chipCont = 0;
            }
        });
        tilEtiqueta.setEndIconOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Buscar artefacto");
            builder.setMessage("Lista de artefactos disponibles:");
            builder.setIcon(R.drawable.baseline_emoji_objects_24);
            //builder.setAdapter()
            builder.show();
        });


    }

    public void funcion() {
        String potencia = edtPotencia.getText().toString();
        String dias = edtDias.getText().toString();
        String horas = edtHoras.getText().toString();
        String minutos = edtMinutos.getText().toString();
        if (!potencia.isEmpty() && (!dias.isEmpty()
                || !horas.isEmpty() || !minutos.isEmpty())) {
            double p = 0.0;
            switch (spnPotencia.getSelectedItemPosition()) {
                case 0:
                    p = Double.parseDouble(potencia) / 1000;
                    break;
                case 1:
                    p = Double.parseDouble(potencia);
                    break;
            }
            double t = 0.0;
            if (!dias.isEmpty()) {
                t += (Double.parseDouble(dias) * 24);
            }
            if (!horas.isEmpty()) {
                t += Double.parseDouble(horas);
            }
            if (!minutos.isEmpty()) {
                t += (Double.parseDouble(minutos) / 60);
            }
            edtConsumo.setText(String.format("%.2f", p * t));
        } else if (!potencia.isEmpty() || !dias.isEmpty()
                || !horas.isEmpty() || !minutos.isEmpty()) {
            edtConsumo.setHint("——");
            edtConsumo.setEnabled(false);
            edtConsumo.setText("");
        } else {
            edtConsumo.setHint("0");
            edtConsumo.setEnabled(true);
        }
    }
}