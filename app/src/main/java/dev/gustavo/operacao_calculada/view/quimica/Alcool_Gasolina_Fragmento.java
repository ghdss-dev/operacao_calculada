package dev.gustavo.operacao_calculada.view.quimica;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.apoio.quimica_apoio.Util_Gas_Eta;
import dev.gustavo.operacao_calculada.controller.quimica_controller.CombustivelController;
import dev.gustavo.operacao_calculada.model.quimica_model.Combustivel_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Alcool_Gasolina_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Alcool_Gasolina_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Alcool_Gasolina_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Alcool_Gasolina_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Alcool_Gasolina_Fragmento newInstance(String param1, String param2) {
        Alcool_Gasolina_Fragmento fragment = new Alcool_Gasolina_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    CombustivelController controller;

    Combustivel_model combustivelGasolina;
    Combustivel_model combustivelEtanol;

    EditText editar_gasolina;
    EditText editar_etanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;

    String recomendacao;

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
        View rootView = inflater.inflate(R.layout.fragment_alcool_gasolina, container, false);

        editar_gasolina = (EditText) rootView. findViewById(R.id.editar_gasolina);
        editar_etanol = (EditText) rootView.findViewById(R.id.editar_etanol);

        txtResultado = (TextView) rootView.findViewById(R.id.txtResultado);

        btnCalcular = (Button) rootView.findViewById(R.id.btnCalcular);
        btnSalvar = (Button) rootView.findViewById(R.id.btnSalvar);
        btnLimpar = (Button) rootView.findViewById(R.id.btnLimpar);
        btnFinalizar = (Button) rootView.findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editar_gasolina.getText())) {

                    editar_gasolina.setError("Obrigatório");
                    editar_gasolina.requestFocus();
                    isDadosOk = false;
                }

                if(TextUtils.isEmpty(editar_etanol.getText())) {

                    editar_etanol.setError("Obrigatório");
                    editar_etanol.requestFocus();
                    isDadosOk = false;
                }

                if(isDadosOk) {

                    precoGasolina = Double.parseDouble(editar_gasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editar_etanol.getText().toString());

                    recomendacao = Util_Gas_Eta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);

                } else {

                    Toast.makeText(getContext(), "Por Favor, digite os dados obrigatórios....", Toast.LENGTH_SHORT).show();
                    btnSalvar.setEnabled(false);
                }

                return;

            }


        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Desabilitar o botão salvar.
                //TODO: EditText inputType

                controller = new CombustivelController(Alcool_Gasolina_Fragmento.this);

                combustivelEtanol = new Combustivel_model();
                combustivelGasolina = new Combustivel_model();

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelGasolina.setRecomendacao(Util_Gas_Eta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(Util_Gas_Eta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);

                int parada = 0;

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editar_etanol.setText("");
                editar_gasolina.setText("");

                btnSalvar.setEnabled(false);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Gásolina boa é economia", Toast.LENGTH_SHORT).show();

                // Para remover o fragmento atual
                getParentFragmentManager().beginTransaction().remove(Alcool_Gasolina_Fragmento.this).commit();
            }
        });

        //utilGasEta.metodoEstatico();

        Util_Gas_Eta.metodoNaoEstatico();

        //Toast.makeText(GasolinaAlcoolActivity.this, UtilGasEta.mensagem(), Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(), Util_Gas_Eta.calcularMelhorOpcao(5.12, 3.39), Toast.LENGTH_LONG).show();

        return rootView;
    }


    public SharedPreferences getSharedPreferences(String nomePreferences, int modePrivate) {
        return requireContext().getSharedPreferences(nomePreferences, modePrivate);
    }
}