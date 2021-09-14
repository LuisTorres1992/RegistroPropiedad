
package clasesrp;

import java.io.Serializable;


public class Pago implements Serializable {


    private String numeroReferencia;
    private long tipoPago;
    private long entidadBancaria;
    private String fecha;
    private Double valor;
    private String NumeroDocumento;
    private Documento Documento;

    public Pago(String numeroReferencia, long tipoPago,long entidadBancaria,String fecha, Double valor, String numeroDocumento, Documento documento){
        this.numeroReferencia = numeroReferencia;
        this.tipoPago = tipoPago;
        this.entidadBancaria = entidadBancaria;
        this.fecha = fecha;
        this.valor = valor;
        this.NumeroDocumento = numeroDocumento;
        this.Documento = documento;
    }
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public long getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(long tipoPago) {
        this.tipoPago = tipoPago;
    }

    public long getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(long entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public Documento getDocumento() {
        return Documento;
    }

    public void setDocumento(Documento Documento) {
        this.Documento = Documento;
    }
}
