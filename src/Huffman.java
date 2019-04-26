

public class Huffman {

    private static char Arr_Chars[];
    private static int Tabla[] = new int[0x7f];
    private static Nodo G_Nodo[];
    private static int Tam_Tabla = 0;
    private static Arbol G_Arbol;
    private static int Tam_Nodo = 0;
    public static HuffmanCompresor hT;

    public Huffman(String Valor){
        Tabla_frecuencia(Valor);
        Arr_Nodos();
        Nodo Aux = Crear_Arbol();
        hT = new HuffmanCompresor(Aux,Arr_Chars,Valor);
    }

    public static void Tabla_frecuencia(String Valor){
        Arr_Chars = Valor.toCharArray();
        for (int i = 0; i <Arr_Chars.length ; i++) {
            Tabla[Obtener_Ascii(Arr_Chars[i])] +=1;

        }
    }

    public static int Obtener_Ascii(char substringValue){
        return substringValue&0x7f;
    }

    public static void Arr_Nodos(){
        int contador = 0;
        for (int i = 0; i <Tabla.length ; i++) {
            if (Tabla[i]>0){
                contador++;
            }

        }

        Tam_Tabla = contador;
        contador = 0;
        G_Nodo = new Nodo[Tam_Tabla];
        for (int i = 0; i <127 ; i++) {
            if (Tabla[i] != 0){
                G_Nodo[contador] = new Nodo(Tabla[i],(char)i,null,null);
                contador++;
            }

        }

        Tam_Nodo = G_Nodo.length;
        Ordenar();

    }

    public static  Nodo Crear_Arbol(){
        for (int i = 1; i <Tam_Nodo ; i++) {
            try {
                if (G_Nodo[1].frecuencia >= G_Nodo[0].frecuencia){

                    G_Arbol = new Arbol(G_Nodo[0], G_Nodo[i]);
                    G_Nodo [0] = G_Arbol;
                    Mover_Items(i, Tam_Nodo);
                    Tam_Nodo -= 1;
                    Ordenar();
                }else {
                    if (i+1 < Tam_Nodo){
                        G_Arbol = new Arbol(G_Nodo[i], G_Nodo[i+1]);
                        G_Nodo[1] = G_Arbol;
                        Ordenar();
                        Tam_Nodo -= 1;
                        i -= 1;
                    }else {
                        G_Nodo[1] = G_Nodo[i];
                        G_Nodo[0] = new Arbol(G_Nodo[0] , G_Nodo[1]);
                    }

                }
            }
            catch (Exception e){

            }

        }
        return G_Nodo[0];
    }

    private static void Mover_Items(int Indice, int Tamaño){
        try {
            for (int i =Indice ; i <Tamaño ; i++) {
                G_Nodo[i] = G_Nodo[i+1];

            }
        }
        catch (Exception e){

        }

    }

    private static void Ordenar(){
        Nodo temp;
        for (int i = Tam_Nodo-1; i >1 ; i--) {
            for (int j = 0; j <i ; j++) {
                if (G_Nodo[j].frecuencia > G_Nodo[j+1].frecuencia){
                    temp = G_Nodo[j+1];
                    G_Nodo[j+1] = G_Nodo[j];
                    G_Nodo[j] = temp;
                }

                if (G_Nodo[j].frecuencia == G_Nodo[j+1].frecuencia && G_Nodo[j].Hizq != null ){
                    temp = G_Nodo[j+1];
                    G_Nodo[j+1] = G_Nodo[j];
                    G_Nodo[j] = temp;

                }
            }

        }
    }
}
