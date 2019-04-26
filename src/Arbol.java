

public class Arbol extends Nodo{

    private Nodo Raiz;

    public Arbol(){
        Raiz = null;

    }

    public Arbol(Nodo NodoA , Nodo NodoB){
        Raiz = super.Add_Nod(NodoA, NodoB);
    }

    public void Insert_Nodo(int frecuencia, char caracter){
        Raiz.frecuencia = frecuencia;
        Raiz.caracter= caracter;
        Raiz.Hizq = null;
        Raiz.Hidr = null;
    }

    public void Insert_Nodo(int frecuncia, char caracter, Nodo Hizq, Nodo Hidr){
        Raiz.frecuencia = frecuencia;
        Raiz.caracter = caracter;
        this.Raiz.Hizq = Hizq;
        this.Raiz.Hidr = Hidr;
    }

    public void Insert_Nodo(Nodo Nodo){
        this.Raiz.frecuencia = frecuencia;
        this.Raiz.caracter= caracter;
        this.Raiz.Hizq = null;
        this.Raiz.Hidr = null;
    }

    public void Insert_Nodo(Nodo NodoA, Nodo NodoB){
        Raiz = super.Add_Nod(NodoA, NodoB);
    }
}
