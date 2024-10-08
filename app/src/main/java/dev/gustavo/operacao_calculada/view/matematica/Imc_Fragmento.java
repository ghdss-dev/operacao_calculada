package dev.gustavo.operacao_calculada.view.matematica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.model.matematica_model.Imc_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Imc_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Imc_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Imc_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Imc_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Imc_Fragmento newInstance(String param1, String param2) {
        Imc_Fragmento fragment = new Imc_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    int peso;
    double altura;
    double imc;
    String mensagem = "";

    // Declaração dos Objetos (Layout)

    EditText editPeso, editAltura;
    TextView txtResultado;
    Button btnCalcular_IMC;

    Button btnFinalizar;

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
        View rootView = inflater.inflate(R.layout.fragment_imc, container, false);

        // Apontando os Objetos do layout
        editPeso = (EditText) rootView.findViewById(R.id.peso);
        editAltura = (EditText) rootView.findViewById(R.id.altura);
        txtResultado = (TextView) rootView.findViewById(R.id.text_resultadoIMC);
        btnCalcular_IMC = (Button) rootView.findViewById(R.id.btnCalcular_IMC);
        //btnFinalizar = (Button) rootView.findViewById(R.id.btnFinalizar);

        btnCalcular_IMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    int peso = Integer.parseInt(editPeso.getText().toString());
                    double altura = Double.parseDouble(editAltura.getText().toString());

                    Imc_model imcModel = new Imc_model(peso, altura);

                    String imcFormatado = String.format("%.2f", imcModel.getImc());

                    // Mostrar o resultado para o usuário
                    txtResultado.setText("IMC: " + imcFormatado + "\n Mensagem: " + imcModel.getMensagem());

                } catch (NumberFormatException e) {

                    Toast.makeText(getContext(), "Digite valores numéricos válidos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}