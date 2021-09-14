
package clasesrp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Providencia implements Serializable{

    private String numeroOficio;
    private String numeroJuicio;
    private String lugar;
    private String fecha;
    private String autoridad;
    private String informacionAdicional;
    private long tipoProvidencia;
    private List<Documento> documentos = new ArrayList<Documento>();
    private List<Interviniente> intervinientes = new ArrayList<Interviniente>();
    private boolean bienes;
    private boolean gravamen;
    private boolean copia;
    private boolean historia;
    private String observacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Providencia() {
    }

    /**
     * 
     * @param numeroJuicio
     * @param informacionAdicional
     * @param copia
     * @param fecha
     * @param documentos
     * @param autoridad
     * @param historia
     * @param observacion
     * @param tipoProvidencia
     * @param intervinientes
     * @param lugar
     * @param numeroOficio
     * @param bienes
     * @param gravamen
     */
    public Providencia(String numeroOficio, String numeroJuicio, String lugar, String fecha, String autoridad, String informacionAdicional, long tipoProvidencia, List<Documento> documentos, List<Interviniente> intervinientes, boolean bienes, boolean gravamen, boolean copia, boolean historia, String observacion) {
        super();
        this.numeroOficio = numeroOficio;
        this.numeroJuicio = numeroJuicio;
        this.lugar = lugar;
        this.fecha = fecha;
        this.autoridad = autoridad;
        this.informacionAdicional = informacionAdicional;
        this.tipoProvidencia = tipoProvidencia;
        this.documentos = documentos;
        this.intervinientes = intervinientes;
        this.bienes = bienes;
        this.gravamen = gravamen;
        this.copia = copia;
        this.historia = historia;
        this.observacion = observacion;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public String getNumeroJuicio() {
        return numeroJuicio;
    }

    public void setNumeroJuicio(String numeroJuicio) {
        this.numeroJuicio = numeroJuicio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public long getTipoProvidencia() {
        return tipoProvidencia;
    }

    public void setTipoProvidencia(long tipoProvidencia) {
        this.tipoProvidencia = tipoProvidencia;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Interviniente> getIntervinientes() {
        return intervinientes;
    }

    public void setIntervinientes(List<Interviniente> intervinientes) {
        this.intervinientes = intervinientes;
    }

    public boolean isBienes() {
        return bienes;
    }

    public void setBienes(boolean bienes) {
        this.bienes = bienes;
    }

    public boolean isGravamen() {
        return gravamen;
    }

    public void setGravamen(boolean gravamen) {
        this.gravamen = gravamen;
    }

    public boolean isCopia() {
        return copia;
    }

    public void setCopia(boolean copia) {
        this.copia = copia;
    }

    public boolean isHistoria() {
        return historia;
    }

    public void setHistoria(boolean historia) {
        this.historia = historia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
