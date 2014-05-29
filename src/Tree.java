/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumnos
 */
public class Tree extends Nodo
{
    private Nodo root;
    
    public Tree()
    {
        root = null;
    }
    
    public Tree(Nodo nodo1, Nodo nodo2)
    {
        root = super.addNode(nodo1, nodo2);
    }
    
    public void insertNode(int freq, char c)
    {
        root.frequency =  freq;
        root.c = c;
        root.left = null;
        root.right = null;
    }
    
    public void insertNode(int freq, char c, Nodo left, Nodo right)
    {
        root.frequency =  freq;
        root.c = c;
        this.root.left = left;
        this.root.right = right;
    }
    
    public void insertNode(Nodo node)
    {
        this.root.frequency = node.frequency;
        this.root.c = node.c;
        this.root.left = node.left;
        this.root.right = node.right;
    }
    
    public void insertNode(Nodo nodo1, Nodo nodo2)
    {
        root = super.addNode(nodo1, nodo2);   
    }
}
