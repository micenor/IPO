package com.company;

public class Crono {
    int primer_digito, segundo_digito;

    public int getPrimer_digito() {
        return primer_digito;
    }

    public void setPrimer_digito(int primer_digito) {
        this.primer_digito = primer_digito;
    }

    public int getSegundo_digito() {
        return segundo_digito;
    }

    public void setSegundo_digito(int segundo_digito) {
        this.segundo_digito = segundo_digito;
    }

    public void sumarMinutos (){
        this.primer_digito += 5;
    }

    public void restarMinutos (){
        this.primer_digito -= 5;
    }
}
