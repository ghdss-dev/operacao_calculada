package dev.gustavo.operacao_calculada.view.matematica.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class ConsumoAdapter extends ArrayAdapter<Double> {

    // Construtor
    public ConsumoAdapter(Context context, List<Double> consumos) {
        // Usando o layout padrão simple_list_item_1 para cada item da lista
        super(context, android.R.layout.simple_list_item_1, consumos);
    }
}
