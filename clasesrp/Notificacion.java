
package clasesrp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notificacion implements Serializable {

    private long numeroCaso;
    private Solicitud solicitud;
    private String fecha;
    private List<Providencia> providencias = new ArrayList<Providencia>();
    private String observacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Notificacion() {
    }

    /**
     * 
     * @param observacion
     * @param providencias
     * @param fecha
     * @param numeroCaso
     * @param solicitud
     */
    public Notificacion(long numeroCaso, Solicitud solicitud, String fecha, List<Providencia> providencias, String observacion) {
        super();
        this.numeroCaso = numeroCaso;
        this.solicitud = solicitud;
        this.fecha = fecha;
        this.providencias = providencias;
        this.observacion = observacion;
    }

    public long getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(long numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Providencia> getProvidencias() {
        return providencias;
    }

    public void setProvidencias(List<Providencia> providencias) {
        this.providencias = providencias;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
