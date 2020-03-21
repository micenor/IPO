package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int opcion = 0;


        Crono Cronometro = new Crono();

        Cronometro.primer_digito = 00;
        Cronometro.segundo_digito = 05;

        Scanner teclado = new Scanner(System.in);



        System.out.println(Cronometro.primer_digito + ":" + Cronometro.segundo_digito);

        System.out.println("Cronometro de Miguel");

        while (opcion!= 4){
            System.out.println("1: Mostrar hora actual");
            System.out.println("2: Sumar 5 minutos al crono");
            System.out.println("3: Restar 5 minutos al crono");
            System.out.println("4 Empezar");



            opcion = teclado.nextInt();

            switch (opcion){
                case 1: System.out.println("Hora actual: "+Cronometro.primer_digito + ":" + Cronometro.segundo_digito);
                        break;
                case 2: Cronometro.sumarMinutos();
                        System.out.println("Hora actual: "+Cronometro.primer_digito + ":" + Cronometro.segundo_digito);
                        break;
                case 3: Cronometro.restarMinutos();
                        if(Cronometro.segundo_digito>60){
                            Cronometro.segundo_digito -= 60;
                            Cronometro.primer_digito += 1;
                        }
                        System.out.println("Hora actual: "+Cronometro.primer_digito + ":" + Cronometro.segundo_digito);
                        break;
            } //Fin Switch
        } // Fin While

        while (Cronometro.primer_digito + Cronometro.segundo_digito != 0){
            Cronometro.segundo_digito -= 1;
            if (Cronometro.segundo_digito<0){
                Cronometro.segundo_digito = 59;
                Cronometro.primer_digito -= 1;
            }//Fin if
            System.out.println("Hora actual: "+Cronometro.primer_digito + ":" + Cronometro.segundo_digito);
            Thread.sleep(1000);
        }//Fin while
        System.out.println("SE ACABÓ EL TIEMPO");
    }// Fin Main
}
