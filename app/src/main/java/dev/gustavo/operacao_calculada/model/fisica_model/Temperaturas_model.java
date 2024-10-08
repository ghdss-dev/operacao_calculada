package dev.gustavo.operacao_calculada.model.fisica_model;

import dev.gustavo.operacao_calculada.apoio.fisica_apoio.Util_Temperaturas;

public class Temperaturas_model {

    private double temperatura;

    public Temperaturas_model(double temperatura) {

        this.temperatura = temperatura;
    }

    public double getKelvinToCelsius() {

        return Util_Temperaturas.kelvinToCelsius(temperatura);
    }

    public double getKelvinToFahrenheit() {

        return Util_Temperaturas.kelvinToFahrenheit(temperatura);
    }

    public double getCelsiusToKelvin() {

        return Util_Temperaturas.celsiusTokelvin(temperatura);
    }

    public double getCelsiusToFahrenheit() {

        return Util_Temperaturas.celsiusToFahrenheit(temperatura);
    }

    public double getFahrenheitToCelsius() {

        return Util_Temperaturas.fahrenheitToCelsius(temperatura);
    }

    public double getFahrenheitToKelvin() {

        return Util_Temperaturas.fahrenheitToKelvin(temperatura);
    }
}
