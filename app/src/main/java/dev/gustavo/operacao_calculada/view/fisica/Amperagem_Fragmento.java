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
import dev.gustavo.operacao_calculada.apoio.fisica_apoio.Util_Amperes;
import dev.gustavo.operacao_calculada.model.fisica_model.Amperes_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Amperagem_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Amperagem_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etVoltagem, etResistencia;
    private TextView tvResultado;
    private Button btnCalcular;

    public Amperagem_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Amperagem_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Amperagem_Fragmento newInstance(String param1, String param2) {
        Amperagem_Fragmento fragment = new Amperagem_Fragmento();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_amperagem, container, false);

        etVoltagem = view.findViewById(R.id.et_voltagem);
        etResistencia = view.findViewById(R.id.et_resistencia);
        tvResultado = view.findViewById(R.id.tv_resultado);
        btnCalcular = view.findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularAmperagem();
            }
        });

        return view;
    }

    private void calcularAmperagem() {

        String voltagemStr = etVoltagem.getText().toString();
        String resistenciaStr = etResistencia.getText().toString();

        if (!voltagemStr.isEmpty() && !resistenciaStr.isEmpty()) {

            double voltagem = Double.parseDouble(voltagemStr);
            double resistencia = Double.parseDouble(resistenciaStr);

            if (Util_Amperes.validarValores(voltagem, resistencia)) {

                Amperes_model amperesModel = new Amperes_model(voltagem, resistencia);
                double resultadoAmperagem = amperesModel.getAmperagem();

                tvResultado.setText("Resultado: " + Util_Amperes.formatarResultado(resultadoAmperagem));

            } else {

                tvResultado.setText("Valores de voltagem e resistência devem ser maiores que zero.");
            }

        } else {

            tvResultado.setText("Por favor, insira ambos os valores");
        }
    }
}