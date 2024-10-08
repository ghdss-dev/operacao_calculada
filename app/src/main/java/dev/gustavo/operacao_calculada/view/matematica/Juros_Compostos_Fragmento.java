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
import dev.gustavo.operacao_calculada.model.matematica_model.Juros_Compostos_model;

import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Juros_Compostos_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Juros_Compostos_Fragmento extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewHolder mViewHolder;

    public Juros_Compostos_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Juros_Compostos_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Juros_Compostos_Fragmento newInstance(String param1, String param2) {
        Juros_Compostos_Fragmento fragment = new Juros_Compostos_Fragmento();
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
        View rootView = inflater.inflate(R.layout.fragment_juros_compostos, container, false);

        mViewHolder = new ViewHolder();

        this.mViewHolder.edit_valor_capital = rootView.findViewById(R.id.edit_valor_capital);
        this.mViewHolder.edit_taxa_juros = rootView.findViewById(R.id.edit_taxa_juros);
        this.mViewHolder.edit_tempo_rendimento = rootView.findViewById(R.id.edit_tempo_rendimento);

        this.mViewHolder.text_juros_compostos = rootView.findViewById(R.id.text_juros_compostos);

        this.mViewHolder.btnCalcular_juros_compostos = rootView.findViewById(R.id.btnCalcular_juros_compostos);

        this.mViewHolder.btnCalcular_juros_compostos.setOnClickListener(this);

        // Retornar a visualização inflada
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular_juros_compostos) {
            Log.d("JurosCompostos", "Botão de cálculo clicado");

            String temp_valor_inicial = this.mViewHolder.edit_valor_capital.getText().toString();
            String temp_taxas_juros = this.mViewHolder.edit_taxa_juros.getText().toString();
            String temp_rendimento = this.mViewHolder.edit_tempo_rendimento.getText().toString();

            Log.d("JurosCompostos", "Valores lidos: " + temp_valor_inicial + ", " + temp_taxas_juros + ", " + temp_rendimento);

            if (temp_valor_inicial.isEmpty() || temp_taxas_juros.isEmpty() || temp_rendimento.isEmpty()) {
                Log.d("JurosCompostos", "Campos vazios detectados");
                if (temp_valor_inicial.isEmpty()) {
                    Toast.makeText(getContext(), getString(R.string.informe_valor_capital), Toast.LENGTH_SHORT).show();
                }
                if (temp_taxas_juros.isEmpty()) {
                    Toast.makeText(getContext(), getString(R.string.informe_taxas_juros), Toast.LENGTH_SHORT).show();
                }
                if (temp_rendimento.isEmpty()) {
                    Toast.makeText(getContext(), getString(R.string.informe_tempo_rendimento), Toast.LENGTH_SHORT).show();
                }
            } else {
                Log.d("JurosCompostos", "Calculando juros compostos");
                double valor_inicial = Double.parseDouble(temp_valor_inicial);
                double taxa_juros = Double.parseDouble(temp_taxas_juros);
                int tempo_rendimento = Integer.parseInt(temp_rendimento);

                Juros_Compostos_model jurosCompostosModel = new Juros_Compostos_model(valor_inicial, taxa_juros, tempo_rendimento);

                this.mViewHolder.text_juros_compostos.setText(String.format("O Total é: R$ %.2f ", jurosCompostosModel.getCalculoGeralJurosCompostos()));
            }
        }
    }
    private void clearValues() {

        this.mViewHolder.edit_valor_capital.setText("");
        this.mViewHolder.edit_taxa_juros.setText("");
        this.mViewHolder.edit_tempo_rendimento.setText("");
    }

    private static class ViewHolder {
        EditText edit_valor_capital, edit_taxa_juros, edit_tempo_rendimento;
        TextView text_juros_compostos;
        Button btnCalcular_juros_compostos;
    }
}