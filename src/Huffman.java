/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumnos
 */
 

import java.util.Scanner;
public class Huffman {
	
//	private static String value;
	private static char charArray[]; //the string coverted to characters.
	private static int table[] = new int[0x7f]; //holds the frequency of the item
        private static Nodo myNode[]; //the main Priority Queue, the Final Tree generated is stored in spot 0.
	private static int lengthOfTable = 0;//The true length of the table that holds the characters.
        private static Tree myTree; //A variable that holds the Tree
        private static int lengthOfNode = 0;//all increments or decrements are made to this value
        public static HuffmanTransversor hC; //The Class Responsible for Decoding the Huffman Tree
        
        
        public Huffman(String value)
        {
            frequencyTable(value);
            nodeArrange();
            Nodo x = createTree();
            hC = new HuffmanTransversor(x,charArray);
        }
        public static void frequencyTable(String value)
	{
		int i;
                charArray = value.toCharArray();
		for(i = 0; i < charArray.length; i++)
			table[getAscii(charArray[i])] += 1; 
	}
	
	public static int getAscii(char substringValue)
	{
		return substringValue&0x7f;
	}
	
        public static void nodeArrange()    
        {
            int counter = 0;
            int j = 0;
            for(int i = 0; i < table.length; i++)
            {
                if(table[i]>0)
                    counter++;
            }
            
            lengthOfTable =  counter;
            counter = 0;    
            myNode = new Nodo[lengthOfTable];
            
            for(int i = 0; i < 127; i++)
            {
                if(table[i] != 0)
                {
                    myNode[counter]= new Nodo(table[i], (char)i, null, null);
                    counter++;
                }
            }
            lengthOfNode = myNode.length;
            sort();
            
        }
        
        public static Nodo createTree()
        {
           for(int i = 1; i < lengthOfNode; i++)
           {
               try
               {
                   if(myNode[1].frequency >= myNode[0].frequency)
                   {
                       myTree = new Tree(myNode[0],myNode[i]);
                       myNode[0] = myTree;
                       moveItems(i, lengthOfNode);
                       lengthOfNode -= 1; 
                       i -= 1;
                       sort();
                   }
                   else
                   {
                       if(i+1 < lengthOfNode)
                       {
                            myTree = new Tree(myNode[i], myNode[i+1]);
                            myNode[1] = myTree;
                            moveItems(i+1, lengthOfNode);
                            sort();
                            lengthOfNode -= 1;
                            i -= 1;
                       }
                       else
                       {
                           myNode[1] = myNode[i];
                           myNode[0] = new Tree(myNode[0], myNode[1]);
                       }
                   }
               }
               catch(Exception e)
               {
                 //I dare this program to crash...hahaha
               }
           }
            return myNode[0];
        }
        
        private static void moveItems(int index, int length)
        {   try
            {
                for(int i = index; i < length; i++)
                    myNode[i] = myNode[i+1];
                
            }
            catch(Exception e)
            {
                //See...this program is uncrashable...lol
            }
        }
        private static void sort()
        {
            Nodo temp;
            for(int i = lengthOfNode-1; i > 1; i--)
            {
                for(int j = 0; j < i; j++)
                {
                    if(myNode[j].frequency > myNode[j+1].frequency)
                    {
                        temp = myNode[j+1];
                        myNode[j+1] = myNode[j];
                        myNode[j] = temp;
                    }
                    
                    if(myNode[j].frequency == myNode[j+1].frequency && myNode[j].left != null)
                    {
                        temp = myNode[j+1];
                        myNode[j+1] = myNode[j];
                        myNode[j] = temp;
                    }
                }
            }
        }
}
