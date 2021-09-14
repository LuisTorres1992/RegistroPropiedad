
package clasesrp;

import java.io.Serializable;


public class Contrato implements Serializable {

    private long id;
    private String nombre;
    private double valor;
    private String observacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contrato() {
    }

    /**
     * 
     * @param nombre
     * @param id
     * @param observacion
     * @param valor
     */
    public Contrato(long id, String nombre, double valor, String observacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.observacion = observacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
