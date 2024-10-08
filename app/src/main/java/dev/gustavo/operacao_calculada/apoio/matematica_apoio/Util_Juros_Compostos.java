package dev.gustavo.operacao_calculada.apoio.matematica_apoio;

public class Util_Juros_Compostos {

  public static double CalculoTotal(double valor_inicial, double taxas_juros, double tempo_rendimento) {

      double am = taxas_juros / 100;

      double total = valor_inicial * Math.pow(1 + am, tempo_rendimento);

      return total;
  }

}
