/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.ArrayList;

/**
 *
 * @author josue
 */
public final class Afin 
{

    public static boolean MCD(int Alfa)
    {
        int residuo=1,cociente=1,dividendo=Alfa,divisor=256;
        
        while(residuo!=0)
        {
            cociente=dividendo/divisor;
            residuo=dividendo%divisor;
            dividendo=divisor;
            divisor=residuo;
        }
        return dividendo==1;
    }
    
    public static int[] euclides_Extend(int Alfa)
    {
       ArrayList<Integer> r = new ArrayList<>();
       ArrayList<Integer> c = new ArrayList<>();
       ArrayList<Integer> u = new ArrayList<>();
       ArrayList<Integer> v = new ArrayList<>();
       
       r.add(Alfa); r.add(256);
       c.add(0); c.add(0);
       u.add(1); u.add(0);
       v.add(0); v.add(1);
       
       int residuo=1,dividendo=Alfa,divisor=256;
       
       while(residuo!=0)
       {
           r.add(dividendo%divisor);
           c.add(dividendo/divisor);
           dividendo=divisor;
           divisor=r.get(r.size()-1);
           residuo=r.get(r.size()-1);
       }
       
       int posC=2;
       
       for(int i=0;i<r.size()-2;i++)
       {
           u.add(u.get(i)-c.get(posC)*u.get(i+1));
           v.add(v.get(i)-c.get(posC)*v.get(i+1));
           posC++;
       }
       
       /*
       System.out.println(r.size());
       System.out.println(c.size());
       System.out.println(u.size());
       System.out.println(v.size());
       
       for(int i=0;i<r.size();i++)
       {
           System.out.println("[ "+r.get(i)+" | "+c.get(i)+" | "+u.get(i)+" | "+v.get(i)+" ]");
       }
       */
       int[] res=new int[2];
       res[0]=u.get(u.size()-2); res[1]=v.get(u.size()-2);
       System.out.println(r.get(r.size()-2)+" = "+Alfa+" ( "+u.get(u.size()-2)+") + "+(256)+" ( "+v.get(v.size()-2)+" )");
       return res;
    }
    
    
    public static String Encrypt_t(String text,int Alpha,int Beta)
    {
        StringBuilder nuevo= new StringBuilder();
        char[] aux=text.toCharArray();
        
        for(int i=0;i<aux.length;i++)
        {
            int a=(int)aux[i]*Alpha;
            int b=a+Beta;
            aux[i]=(char)(b%256);
            System.out.println((int)aux[i] + " ---->  "+(int)aux[i]);
            nuevo.append(aux[i]);
        }
        return nuevo.toString();
    }
    
    public static String Decrypt_t(String text,int Alpha,int Beta)
    {
        StringBuilder nuevo=new StringBuilder();
        char[] aux=text.toCharArray();
        
        int[] inverso=euclides_Extend(Alpha);
        
        if(inverso[0]>0)
        {
            for(int i=0;i<aux.length;i++)
            {
                int a=(int)aux[i]-Beta;
                int b=a*inverso[0];
                aux[i]=(char)(b%256);
                nuevo.append(aux[i]);
            }
        }
        else
        {
            for(int i=0;i<aux.length;i++)
            {
                int a=(int)aux[i]-Beta;
                int b=a*(inverso[0]+256);
                aux[i]=(char)(b%256);
                nuevo.append(aux[i]);
            }
        }
        
        
        return nuevo.toString();
    }
    
    
    


}
