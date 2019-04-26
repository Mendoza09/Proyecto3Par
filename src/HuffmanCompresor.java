import java.util.BitSet;

public class HuffmanCompresor {
    private Nodo Nodo_Raiz;
    private char caracter;
    private char[] Arr_Chars;
    public String Patron_Bits = " ";
    static byte[] Mensj_Compreso;
    private String[] Arr_Codig = new String[1000];


    public HuffmanCompresor(Nodo G_Nodo, char[] Arr_Chars, String mensaje) {

        String temp;
        this.Arr_Chars = Arr_Chars;
        Nodo_Raiz = G_Nodo;
        for (int i = 0; i < Arr_Chars.length; i++) {
            temp = Busqueda(Nodo_Raiz, " ", Arr_Chars[i]);
            Patron_Bits += temp+ " ";
            Arr_Codig[i] = temp;
            System.out.println("Codigo Huffman: " + Arr_Chars[i] + " " + temp);

        }

        BitSet Arr_Bits = new BitSet();
        int k = 0;
        int j;
        for (int i = 0; i < mensaje.length(); i++) {
            char Caracter = mensaje.charAt(i);
            for (j = 0; j < Arr_Chars.length; j++) {
                if (Arr_Chars[j] == Caracter) {
                    break;
                }

            }
            String Codigo = Arr_Codig[j];
            for (j = 0; j < Codigo.length(); j++) {
                boolean bit = Codigo.charAt(j) == '1';
                Arr_Bits.set(k++, bit);
            }
        }

        Mensj_Compreso = Arr_Bits.toByteArray();
    }
    public String Busqueda(Nodo Nodo_Raiz, String Valor,char G_Caracter)
    {
        String Valor_Binario ="";
        if(Nodo_Raiz != null)
        {
            if(Nodo_Raiz.Hizq != null)
                Valor_Binario = Busqueda(Nodo_Raiz.Hizq, Valor+"0", G_Caracter);
            if(Nodo_Raiz.caracter == G_Caracter)
                return Valor;

            else
            {
                if(Valor_Binario == "")
                {
                    return Busqueda(Nodo_Raiz.Hidr, Valor+"1",G_Caracter);
                }
                else
                {
                    return Valor_Binario;
                }
            }
        }
        else
        {
            return "";
        }
    }
}
