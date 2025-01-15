package models.exchange;

import models.records.RPair;

public class ConversorDeMoeda {
    private String base;
    private String alvo;
    private String taxa;
    private String valorConvertido;

    public ConversorDeMoeda(RPair moeda) {
        base = moeda.base_code();
        alvo = moeda.target_code();
        taxa = moeda.conversion_rate();
        valorConvertido = moeda.conversion_result();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public String getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(String valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

}
