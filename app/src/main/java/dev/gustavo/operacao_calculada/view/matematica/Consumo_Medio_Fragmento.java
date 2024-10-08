package dev.gustavo.operacao_calculada.view.matematica;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Consumo_Medio;
import dev.gustavo.operacao_calculada.view.matematica.adapter.ConsumoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Consumo_Medio_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Consumo_Medio_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Util_Consumo_Medio utilConsumoMedio;
    private EditText inputConsumo;
    private TextView textConsumoRegistrado, textMediaGeral, textTotalRegistros;
    private ListView listRegistros;

    public Consumo_Medio_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Consumo_Medio.
     */
    // TODO: Rename and change types and number of parameters
    public static Consumo_Medio_Fragmento newInstance(String param1, String param2) {
        Consumo_Medio_Fragmento fragment = new Consumo_Medio_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        utilConsumoMedio = new Util_Consumo_Medio();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar o layout do fragmento
        View view = inflater.inflate(R.layout.fragment_consumo_medio, container, false);

        // Inicializando os elementos de UI
        inputConsumo = view.findViewById(R.id.input_consumo);
        Button buttonRegistrar = view.findViewById(R.id.button_registrar);
        textConsumoRegistrado = view.findViewById(R.id.text_consumo_registrado);
        textMediaGeral = view.findViewById(R.id.text_media_geral);
        textTotalRegistros = view.findViewById(R.id.text_total_registros);
        listRegistros = view.findViewById(R.id.list_registros);

        buttonRegistrar.setOnClickListener(v -> {

            String consumoText = inputConsumo.getText().toString();

            if(!consumoText.isEmpty()) {

                double consumo = Double.parseDouble(consumoText);
                utilConsumoMedio.addConsumo(consumo);

                // Atualizado UI
                textTotalRegistros.setText(String.valueOf(utilConsumoMedio.getNumeroDeRegistros()));

                // Formata a média para exibir com duas casas decimais
                String mediaFormatada = String.format("%.2f", utilConsumoMedio.calcularMedia());
                textMediaGeral.setText("Consumo Médio Geral: " + mediaFormatada);

                // Atualiza o ListView com os consumos registrados
                ArrayAdapter<Double> adapter = new ConsumoAdapter(getContext(), utilConsumoMedio.getConsumos());
                listRegistros.setAdapter(adapter);
            }
        });

        return  view;
    }
}