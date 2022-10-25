package com.example.tallerareatiinacap;

public class Validar_rut {
    String RUT;

    public Validar_rut(String RUT) {
        this.RUT = RUT;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    //metodo

    public boolean Validacion_Concreta(){

        Boolean lDevuelve = false;
        int Ult= this.RUT.length(); // |1 |8 |2 |1 |6 |5 |7 |1 |- |9 | = 10? = 9
        int Largo = this.RUT.length() -3;
        int Constante = 2;
        int Suma = 0;
        int Digito = 0;

        for (int i= Largo; i >=0; i--){

            Suma= Suma + Integer.parseInt(this.RUT.substring(i,i+1)) * Constante;
            Constante = Constante + 1 ;
            if (Constante == 8){
                Constante =2; }
        }

        String Ultimo = this.RUT.substring(Ult-1).toUpperCase();
        Digito =11 - (Suma % 11);
        if (Digito==10 && Ultimo.equals("k")){
            lDevuelve=true;
        } else
        {
            if(Digito == 11 && Ultimo.equals("0")){
                lDevuelve=true;
            }
            else
            {
                if (Digito == Integer.parseInt(Ultimo)){

                    lDevuelve=true;

                }
            }

        }
        return lDevuelve;
    }

}