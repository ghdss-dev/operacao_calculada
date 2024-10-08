package dev.gustavo.operacao_calculada.view.matematica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Operacao_Tabuada;
import dev.gustavo.operacao_calculada.model.matematica_model.Operacao_Tabuada_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tabuada_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tabuada_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tabuada_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tabuada.
     */
    // TODO: Rename and change types and number of parameters
    public static Tabuada_Fragmento newInstance(String param1, String param2) {
        Tabuada_Fragmento fragment = new Tabuada_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button btnTabuada;
    EditText valorTabuada;
    TextView resultadoTabuada;

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
        View rootView = inflater.inflate(R.layout.fragment_tabuada, container, false);

        btnTabuada = rootView.findViewById(R.id.btnTabuada);
        valorTabuada = rootView.findViewById(R.id.valorTabuada);
        resultadoTabuada = rootView.findViewById(R.id.resultadoTabuada);

        btnTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int tabuada = Integer.parseInt(valorTabuada.getText().toString());

                    if (!Util_Operacao_Tabuada.validarEntrada(tabuada)) {
                        valorTabuada.setError("Digite valor entre 0 e 50");
                        valorTabuada.requestFocus();
                    } else {
                        String resultado = Operacao_Tabuada_model.calcularTabuada(tabuada);
                        resultadoTabuada.setText(resultado);
                    }
                } catch (Exception e) {
                    valorTabuada.setError("Não Deixe em Branco !");
                    valorTabuada.requestFocus();
                }
            }
        });

        return rootView;
    }
}