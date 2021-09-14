
package clasesrp;

import java.io.Serializable;


public class Interviniente implements Serializable{

    private String identificacion;
    private String nombres;
    private long tipoIdentificacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Interviniente() {
    }

    /**
     * 
     * @param identificacion
     * @param tipoIdentificacion
     * @param nombres
     */
    public Interviniente(String identificacion, String nombres, long tipoIdentificacion) {
        super();
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public long getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(long tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

}
