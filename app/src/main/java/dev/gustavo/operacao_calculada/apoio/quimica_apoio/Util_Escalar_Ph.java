package dev.gustavo.operacao_calculada.apoio.quimica_apoio;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.model.quimica_model.Escalar_Ph_model;

public class Util_Escalar_Ph {

    public static Escalar_Ph_model getEscalarPhModel(String numero) {

        switch (numero) {

            case "0":

                return new Escalar_Ph_model("Ácido de bateria \n Substância ÁCIDA", R.drawable.t1, R.drawable.s0);

            case "1":

                return new Escalar_Ph_model("Ácido de estomacal \n Substância ÁCIDA", R.drawable.t1, R.drawable.s2);

            case "2":

                return new Escalar_Ph_model("Limão \n Substância ÁCIDA", R.drawable.t2, R.drawable.s2);

            case "3":

                return new Escalar_Ph_model("Suco de Laranja \n Substância ÁCIDA", R.drawable.t3, R.drawable.s3);

            case "4":

                return new Escalar_Ph_model("Tomate \n Substância ÁCIDA", R.drawable.t4, R.drawable.s4);

            case "5":

                return new Escalar_Ph_model("Cáfe \n Substância ÁCIDA", R.drawable.t5, R.drawable.s5);

            case "6":

                return new Escalar_Ph_model("Urina \n Substância ÁCIDA", R.drawable.t6, R.drawable.s6);

            case "7":

                return new Escalar_Ph_model("Água \n Substância NEUTRA", R.drawable.t7, R.drawable.s7);

            case "8":

                return new Escalar_Ph_model("Água do mar \n Substância NEUTRA", R.drawable.t8, R.drawable.s8);

            case "9":

                return new Escalar_Ph_model("Bicarbonato de sódio \n Substância ALCALINA", R.drawable.t9, R.drawable.s9);

            case "10":

                return new Escalar_Ph_model("Pastilha antiácido estomacal \n Substância ALCALINA", R.drawable.t10, R.drawable.s10);

            case "11":

                return new Escalar_Ph_model("Solução de amônia \n Substância ALCALINA", R.drawable.t11, R.drawable.s11);

            case "12":

                return new Escalar_Ph_model("Água com sabão \n Substância ALCALINA", R.drawable.t12, R.drawable.s12);

            case "13":

                return new Escalar_Ph_model("Água sanitária \n Substância ALCALINA", R.drawable.t13, R.drawable.s13);

            case "14":

                return new Escalar_Ph_model("Limpador de ralo \n Substância ALCALINA", R.drawable.t14, R.drawable.s14);

            default:
                return  new Escalar_Ph_model("Valor inválido", 0, 0);

        }
    }
}
