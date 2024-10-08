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
import dev.gustavo.operacao_calculada.model.fisica_model.Temperaturas_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Conversor_Temperaturas_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Conversor_Temperaturas_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Conversor_Temperaturas_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Conversor_Temperaturas_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Conversor_Temperaturas_Fragmento newInstance(String param1, String param2) {
        Conversor_Temperaturas_Fragmento fragment = new Conversor_Temperaturas_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private Button ktoc, ktof, ctok, ctof,  ftoc, ftok;
    private TextView resultado;
    private EditText edit_numero;

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
        View rootView = inflater.inflate(R.layout.fragment_conversor_temperaturas, container, false);

        ktoc = (Button) rootView.findViewById(R.id.ktoc);
        ktof = (Button) rootView.findViewById(R.id.ktof);

        ctok = (Button) rootView.findViewById(R.id.ctok);
        ctof = (Button) rootView.findViewById(R.id.ctof);

        ftoc = (Button) rootView.findViewById(R.id.ftoc);
        ftok = (Button) rootView.findViewById(R.id.ftok);

        resultado = (TextView) rootView.findViewById(R.id.resultado);
        edit_numero = (EditText) rootView.findViewById(R.id.edit_numero);

        ktoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f ", temperaturasModel.getKelvinToCelsius())));
                }
            }
        });

        ktof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f ", temperaturasModel.getKelvinToFahrenheit())));
                }
            }
        });

        ctok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f ", temperaturasModel.getCelsiusToKelvin())));
                }
            }
        });

        ctof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f ", temperaturasModel.getCelsiusToFahrenheit())));
                }
            }
        });

        ftoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f ", temperaturasModel.getFahrenheitToCelsius())));
                }
            }
        });

        ftok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidInput()) {

                    double temp = Double.parseDouble(edit_numero.getText().toString());

                    Temperaturas_model temperaturasModel = new Temperaturas_model(temp);

                    resultado.setText(String.valueOf(String.format("%.2f", temperaturasModel.getFahrenheitToKelvin())));
                }
            }
        });

        return rootView;
    }

    private boolean isValidInput() {
        String input = edit_numero.getText().toString().trim();
        if (input.isEmpty()) {
            edit_numero.setError("Digite um valor");
            return false;
        }
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            edit_numero.setError("Digite um número válido");
            return false;
        }
    }
}