
package clasesrp;

import java.io.Serializable;


public class Solicitud implements Serializable {

    private long id;
    private long año;
    private String nombreEntidad;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Solicitud() {
    }

    /**
     * 
     * @param anio
     * @param id
     * @param nombreEntidad
     */
    public Solicitud(long id, long anio, String nombreEntidad) {
        super();
        this.id = id;
        this.año = anio;
        this.nombreEntidad = nombreEntidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAño() {
        return año;
    }

    public void setAño(long anio) {
        this.año = anio;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

}
