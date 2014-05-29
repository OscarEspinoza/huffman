import java.util.*;

public class HummanExe
{
    static Huffman huffman;
    private static Scanner input = new Scanner(System.in);
    private static String cadena;
    public static void main(String args[])
	{
		System.out.print("Ingresa la cadena: ");
                cadena = input.nextLine();
                
                huffman = new Huffman(cadena);
                System.out.println("La cadena comprimida es: "+huffman.hC.finalBitPattern);  
                
                
                
	}
}
 