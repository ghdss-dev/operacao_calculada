package dev.gustavo.operacao_calculada.view.fisica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.apoio.fisica_apoio.Util_Carga_Maxima_Consumo;

public class Carga_Maxima_Consumo_Fragmento extends Fragment {

    private EditText editPotencia, editCargaMaxima;
    private Button btnCalcular;
    private TextView txtResultado;

    public Carga_Maxima_Consumo_Fragmento() {
        // Required empty public constructor
    }

    public static Carga_Maxima_Consumo_Fragmento newInstance() {

        Carga_Maxima_Consumo_Fragmento fragment = new Carga_Maxima_Consumo_Fragmento();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_carga_maxima_consumo, container, false);

        // Referenciar os elementos do layout
        editPotencia = view.findViewById(R.id.edit_potencia);
        editCargaMaxima = view.findViewById(R.id.edit_carga_maxima);
        btnCalcular = view.findViewById(R.id.btn_calcular);
        txtResultado = view.findViewById(R.id.txt_resultado);

        btnCalcular.setOnClickListener(v -> calcularConsumo());

        return view;
    }

    private void calcularConsumo() {

        try {

            double potencia = Double.parseDouble(editPotencia.getText().toString());
            double cargaMaxima = Double.parseDouble(editCargaMaxima.getText().toString());

            double resultado = Util_Carga_Maxima_Consumo.calcularConsumo(potencia, cargaMaxima);
            txtResultado.setText(String.format("Consumo Médio: %.2f", resultado));

        } catch (NumberFormatException e) {

            txtResultado.setText("Insira valores válidos.");
        }
    }
}