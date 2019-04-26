import java.util.Scanner;

public class Run {


        static Huffman huffman;
        private static Scanner scanner = new Scanner(System.in);
        private static String Valor;

        public static void main(String args[]){
            System.out.println("Ingrese Una Cadena de Datos");
            Valor = scanner.nextLine();
            System.out.println("Cadena de Datos Ingresados: "+Valor);
            huffman = new Huffman(Valor);
            System.out.println("***Esta es la Represemtacion de Bits de la Cadena Ingresada es: "+huffman.hT.Patron_Bits);

            // System.out.println("Mensaje Compreso: "+huffman.hT.Mensaje_Compreso);
            System.out.println("Tamaño en Bites del Mensaje Compreso: "+huffman.hT.Mensj_Compreso.length);
            System.out.println("Tamaño en Bites del Mensaje Normal: "+Valor.length());
        }
}
