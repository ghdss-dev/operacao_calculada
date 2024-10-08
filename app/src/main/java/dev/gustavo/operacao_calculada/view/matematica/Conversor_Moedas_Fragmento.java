package dev.gustavo.operacao_calculada.view.matematica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Moedas;
import dev.gustavo.operacao_calculada.model.matematica_model.Moedas_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Conversor_Moedas_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Conversor_Moedas_Fragmento extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Conversor_Moedas_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Conversor_moedas.
     */
    // TODO: Rename and change types and number of parameters
    public static Conversor_Moedas_Fragmento newInstance(String param1, String param2) {
        Conversor_Moedas_Fragmento fragment = new Conversor_Moedas_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private ViewHolder mViewHolder = new ViewHolder();

    private Util_Moedas utilMoedas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Moedas_model moedas = new Moedas_model(4.0, 5.0);

        utilMoedas = new Util_Moedas(moedas);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_conversor_moedas, container, false);

        this.mViewHolder.editar_valor = rootView.findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = rootView.findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = rootView.findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = rootView.findViewById(R.id.btnCalcular_Moedas);
        this.mViewHolder.btnFinalizar = rootView.findViewById(R.id.btnFinalizar);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.mViewHolder.btnFinalizar.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnCalcular_Moedas) {

            String value = this.mViewHolder.editar_valor.getText().toString();

            if ("".equals(value)) {

                Toast.makeText(getContext(), getString(R.string.informe_valor), Toast.LENGTH_SHORT).show();

            } else {

                Double real = Double.valueOf(value);
                double valorDolar = utilMoedas.converterRealParaDolar(real);
                double valorEuro = utilMoedas.converterRealParaEuro(real);
                this.mViewHolder.textDolar.setText(String.format("%.2f", valorDolar));
                this.mViewHolder.textEuro.setText(String.format("%.2f", valorEuro));
            }
        }

        if (v.getId() == R.id.btnFinalizar) {

            Toast.makeText(getContext(), "Conversão efetuada com sucesso", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
    }

    private static class ViewHolder {
        android.widget.EditText editar_valor;
        android.widget.TextView textDolar;
        android.widget.TextView textEuro;
        android.widget.Button buttonCalculate;
        android.widget.Button btnFinalizar;
    }
}
