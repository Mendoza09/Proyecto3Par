

public class Nodo {
    public int frecuencia;
    public char caracter;
    public Nodo Hizq;
    public Nodo Hidr;

    public Nodo(int frecuencia, char caracter, Nodo Hizq, Nodo Hidr){
        this.frecuencia = frecuencia;
        this.caracter = caracter;
        this.Hizq = Hizq;
        this.Hidr = Hidr;
    }

    public Nodo(){

    }

    public Nodo Add_Nod(Nodo NodoA, Nodo NodoB){
        if (NodoA.frecuencia<NodoB.frecuencia){
            Hizq = NodoA;
            Hidr = NodoB;
        }else{
            Hidr = NodoA;
            Hizq = NodoB;
        }
        frecuencia = NodoA.frecuencia+NodoB.frecuencia;
        return this;
    }
}
