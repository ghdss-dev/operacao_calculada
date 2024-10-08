package dev.gustavo.operacao_calculada.controller.quimica_controller;

import android.content.Context;
import android.content.SharedPreferences;

import dev.gustavo.operacao_calculada.model.quimica_model.Combustivel_model;
import dev.gustavo.operacao_calculada.view.quimica.Alcool_Gasolina_Fragmento;


public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(Alcool_Gasolina_Fragmento activity) {

        preferences = activity.getSharedPreferences(NOME_PREFERENCES, Context.MODE_PRIVATE);

        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel_model combustivel) {

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        //dadosPreferences.apply();
        dadosPreferences.commit();
    }
}
