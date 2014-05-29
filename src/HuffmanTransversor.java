/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumnos
 */
public class HuffmanTransversor
{
    private Nodo rootNode;
    private char c;
    private char charArray[];
    private int i=0;
    public String finalBitPattern = "";
    public HuffmanTransversor(Nodo myNode, char [] charArray)
    {
        String temp;
        int i;
        rootNode = myNode;
        this.charArray = charArray;
        for(i = 0; i < charArray.length; i++)
        {
            temp = search(rootNode, "", charArray[i]);
            finalBitPattern += temp+" ";
            System.out.println("My values: "+charArray[i]+" "+temp);
        }
      //  System.out.println("My final Bit Pattern: "+finalBitPattern);
    }
    
    public String search(Nodo rootNode, String value,char myChar)
    {
        String valueL ="";
        if(rootNode != null)
        {
            if(rootNode.left != null)
                valueL = search(rootNode.left, value+"0", myChar);
            if(rootNode.c == myChar)
                return value;

            else
            {
                if(valueL == "")
                {
                    return search(rootNode.right, value+"1",myChar);
                }
                else
                {
                    return valueL;
                }
            }
        }
        else
        {
            return "";
        }
    }
        
}
