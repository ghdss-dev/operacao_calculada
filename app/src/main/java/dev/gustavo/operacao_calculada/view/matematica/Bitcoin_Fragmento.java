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
import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Bitcoin;
import dev.gustavo.operacao_calculada.model.matematica_model.Bitcoin_model;


public class Bitcoin_Fragmento extends Fragment {

    private TextView txtCotacao;
    private EditText txtValor;
    private Button btnCalcular;
    private TextView txtValorBitcoin;

    private final double cotacaoAtual = 200000.00;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bitcoin, container, false);

        // Vincular elementos da interface
        txtCotacao = view.findViewById(R.id.txt_cotacao);
        txtValor = view.findViewById(R.id.txt_valor);
        btnCalcular = view.findViewById(R.id.btn_calcular);
        txtValorBitcoin = view.findViewById(R.id.txt_valor_bitcoin);

        // Configurar a cotação atual
        txtCotacao.setText(String.format("R$ %.2f", cotacaoAtual));

        // Configurar ação do botão Calcular
        btnCalcular.setOnClickListener(v -> {

            String valorReaisStr = txtValor.getText().toString();

            if (Util_Bitcoin.isValorValido(valorReaisStr)) {

                double valorReais = Double.parseDouble(valorReaisStr.replace(",", "."));

                // Criar modelo e calcular bitcoin
                Bitcoin_model bitcoinModel = new Bitcoin_model(cotacaoAtual, valorReais);
                double quantidadeBitcoin = bitcoinModel.calcularBitcoin();

                // Exibir resultado
                String resultadoFormatado = Util_Bitcoin.formatarValor(quantidadeBitcoin);
                txtValorBitcoin.setText(resultadoFormatado);

            } else {

                txtValorBitcoin.setText("valor inválido");
            }

        });
        
        return view;
    }
}