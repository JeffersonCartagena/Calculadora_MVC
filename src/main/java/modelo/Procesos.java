/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author Pato
 */
public class Procesos {
    private double n1;
    private double n2;

    public Procesos(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }
    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
    @Override
     public String toString(){
         return "Procesos (" + "n1=" +n1+ "n2="+n2+")" ;
     }
    public double Suma(){
        return n1+n2;
    }
    public double Resta(){
        return n1-n2;
    }
     public double Multiplicar(){
        return n1*n2;
    }
      public double Dividir(){
         if(n2 !=0){
             return n1/n2;
         }
        return 0;   
    }
}