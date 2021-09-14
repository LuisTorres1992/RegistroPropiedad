
package clasesrp;

import java.io.Serializable;


public class Documento implements Serializable {

    private long id;
    private long tipoDocumento;
    private String archivo;
    private String observacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Documento() {
    }

    /**
     * 
     * @param id
     * @param observacion
     * @param archivo
     * @param tipoDocumento
     */
    public Documento(long id, long tipoDocumento, String archivo, String observacion) {
        super();
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.archivo = archivo;
        this.observacion = observacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
