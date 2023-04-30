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
        for (Artefacto artefacto: funcion(bundle.getString("espacio"))) {
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

    private Artefacto[] funcion(String espacio) {
        Artefacto[] artefactos = new Artefacto[] {};
        switch (espacio) {
            case "COCINA":
                artefactos = new Artefacto[] {
                        new Artefacto("Estufa", R.drawable.estufa, 1500.0, "Utiliza " +
                                "la cocina eléctrica solo si es necesario, consumes menos energía eléctrica cocinando a gas."),
                        new Artefacto("Refrigerador", R.drawable.refrigerador, 150.0, "Abre " +
                                "tu refrigerador solo las veces necesarias. Cerrando bien la puerta vamos ahorrando. No introduzcas alimentos calientes."),
                        new Artefacto("Microondas", R.drawable.microondas, 1200.0, "Utiliza " +
                                "el horno microondas solo para calentar y no para cocinar."),
                        new Artefacto("Licuadora", R.drawable.licuadora, 500.0, "Utiliza " +
                                "la licuadora con una potencia moderada y pica antes los productos que vas licuar. Sobre todo, fíjate que las cuchillas no estén gastadas."),
                        new Artefacto("Arrocera", R.drawable.arrocera, 500.0, "No la dejes " +
                                "conectada todo el día, desenchúfala cuando termine la cocción.")
                };
                break;
            case "LAVANDERÍA":
                artefactos = new Artefacto[] {
                        new Artefacto("Lavadora", R.drawable.lavadora, 500.0, "Solo lava " +
                                "cuando haya suficiente ropa para llenar tu lavadora, así la aprovecharás al máximo. " +
                                "Además, no eches más detergente de lo necesario, porque no mejorará el lavado, solo estarás utilizando más agua y electricidad para el enjuague."),
                        new Artefacto("Secadora de ropa", R.drawable.secadora_ropa, 4000.0, "Aprende " +
                                "a separar la ropa de acuerdo a la textura, el algodón necesitará más calor que la tela sintética. " +
                                "Activa la opción de auto secado para que se apague apenas temine. Mucho mejor, sécalas al aire libre."),
                        new Artefacto("Plancha", R.drawable.plancha, 1200.0, "Plancha primero " +
                                "la ropa gruesa, apaga la plancha y finaliza con la ropa delgada aprovechando el calor residual."),
                        new Artefacto("Aspiradora", R.drawable.aspiradora, 1200.0, "No uses " +
                                "la aspiradora más de lo necesario. Mantén limpios los filtros de la aspiradora y limpia regularmente su depósito. " +
                                "Si no lo haces, el motor se forzará más de lo necesario y consumirá más energía"),
                        new Artefacto("Lustradora", R.drawable.lustradora, 500.0, "Elige " +
                                "un aparato de acuerdo a tus necesidades, controla el tiempo de uso y manténlo limpio " +
                                "para que el aparato no haga esfuerzo y consuma más energía.")
                };
                break;
            case "CUARTO CON BAÑO":
                artefactos = new Artefacto[] {
                        new Artefacto("Ventilador", R.drawable.ventilador, 50.0, "Usa " +
                                "el ventilador en temporadas de extremo calor, además, no lo utilices para secar la ropa o cualquier otro material."),
                        new Artefacto("Computadora", R.drawable.computadora, 245.0, "Apaga" +
                                " la pantalla sino vas a usar la computadora por más de 10 minutos y por completo si es por más de 30 minutos."),
                        new Artefacto("Consola", R.drawable.consola, 350.0, "Solo conecta " +
                                "el equipo cuando lo utilices, evita el consumo en modo stand-by."),
                        new Artefacto("Secadora de pelo", R.drawable.secadora_pelo, 1200.0, "Seca primeramente " +
                                "tu cabello con una toalla, péinalo un poco y luego usa la secadora usando solo el soplador de aire o con el nivel más inferior de calentamiento."),
                        new Artefacto("Terma", R.drawable.terma, 0.0, "No dejes encendida " +
                                "todo el día tu terma, préndela una hora antes de bañarte. Mejor utiliza un temporizador y ¡ahorremos energía!")
                };
                break;
            case "SALA Y OCIO":
                artefactos = new Artefacto[] {
                        new Artefacto("Televisor", R.drawable.televisor, 1800.0, "Utiliza " +
                                "el televisor solo cuando lo veas. Si vas a dormir prográmalo para que se apague automáticamente y mejor desenchúfalo."),
                        new Artefacto("Parlantes", R.drawable.parlantes, 11.0, "Desconecta " +
                                "el equipo cuando no lo estés usando, evitemos el consumo en modo stand-by."),
                        new Artefacto("Laptop", R.drawable.laptop, 45.0, "Enciéndela " +
                                "cuando la vayas a usar y cárgala solo lo necesario. Deschúfala si no la vas a usar."),
                        new Artefacto("Aire acondicionado", R.drawable.aire_acondicionado, 1500.0, "Elige " +
                                "un aparato eficiente, colócalo a una temperatura media. Evita usarlo de noche. " +
                                "Abre las ventanas para que haga corriente y reducirás muchas horas de consumo de energía."),
                        new Artefacto("Blu-Ray", R.drawable.blu_ray, 12.5, "Desconecta " +
                                "el equipo cuando no lo estés usando, evitemos el consumo en modo stand-by.")
                };
                break;
        }
        return artefactos;
    }
}