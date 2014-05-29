/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumnos
 */
public class Nodo
{
    public int frequency;
    public char c;
    public Nodo left;
    public Nodo right;
    
    public Nodo(int frequency, char c, Nodo left, Nodo right)
    {
        this.frequency = frequency;
        this.c = c;
        this.left = left;
        this.right = right;
    }
    
    public Nodo()
    {
        //does Nothing
    }
    
    public Nodo addNode(Nodo nodo1, Nodo nodo2)
    {
        if(nodo1.frequency < nodo2.frequency)
        {
            left = nodo1;
            right = nodo2;
        }
        else
        {
            right = nodo1;
            left = nodo2;
        }
        frequency = nodo1.frequency + nodo2.frequency;
        
        return this;
    }
    
}
