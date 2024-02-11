package modelo;

/**
 *
 * @author Pato
 */

public class Operacion {
    private int idOperacion;
    private double dato1;
    private double dato2;
    private double resultado;
    private String operacion;

    public Operacion(int idOperacion, double dato1, double dato2, double resultado, String operacion) {
        this.idOperacion = idOperacion;
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.resultado = resultado;
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    

    public Operacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }
    


    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public double getDato1() {
        return dato1;
    }

    public void setDato1(double dato1) {
        this.dato1 = dato1;
    }

    public double getDato2() {
        return dato2;
    }

    public void setDato2(double dato2) {
        this.dato2 = dato2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Operacion{" + "idOperacion=" + idOperacion + ", dato1=" + dato1 + ", dato2=" + dato2 + ", resultado=" + resultado + '}';
    }
   
    
}
