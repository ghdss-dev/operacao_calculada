package dev.gustavo.operacao_calculada.view.quimica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.model.quimica_model.Ingestao_Diaria;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Beber_Agua#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Beber_Agua extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText editPeso;
    private EditText editIdade;

    private Button btCalcularDiaria;
    private TextView txtResultadoMl;

    private ImageView icRedefinir;


    public Beber_Agua() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculo_Beber_Agua.
     */
    // TODO: Rename and change types and number of parameters
    public static Beber_Agua newInstance(String param1, String param2) {
        Beber_Agua fragment = new Beber_Agua();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculo_beber_agua, container, false);

        editPeso = view.findViewById(R.id.edit_peso);
        editIdade = view.findViewById(R.id.edit_idade);
        btCalcularDiaria = view.findViewById(R.id.bt_calcular_diaria);
        txtResultadoMl = view.findViewById(R.id.txt_resultado_ml);
        icRedefinir = view.findViewById(R.id.ic_redefinir);

        btCalcularDiaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularIngestaoAgua();
            }
        });

        icRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redefinirCampos();
            }
        });

        return view;
    }

    private void redefinirCampos() {
        editPeso.setText("");
        editIdade.setText("");
        txtResultadoMl.setText("");
    }

    private void calcularIngestaoAgua() {

        String pesoStr = editPeso.getText().toString();
        String idadeStr = editIdade.getText().toString();

        if(!pesoStr.isEmpty() && !idadeStr.isEmpty()) {

            double peso = Double.parseDouble(pesoStr);
            int idade = Integer.parseInt(idadeStr);

            Ingestao_Diaria ingestaoDiaria = new Ingestao_Diaria();
            ingestaoDiaria.calcularTotalMl(peso, idade);

            double resultadoMl = ingestaoDiaria.getResultadoMl();
            txtResultadoMl.setText(String.format("%.1f ml", resultadoMl));

        } else {

            txtResultadoMl.setText("Preencha todos os campos !");
        }
    }
}