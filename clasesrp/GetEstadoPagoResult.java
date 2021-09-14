/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;



import java.io.Serializable;

/**
 *
 * @author evill
 */
public class GetEstadoPagoResult extends BaseResult implements Serializable {

    private Pago pago;
    private long estado;
    private String observacion;

    public GetEstadoPagoResult(Pago pago, long estado, String observacion) {
        this.pago = pago;
        this.estado = estado;
        this.observacion = observacion;
    }

    public GetEstadoPagoResult(Pago pago, long estado, String observacion, String dateTime, long result, long indexPage, long lastPage) {
        super(dateTime, result, indexPage, lastPage);
        this.pago = pago;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
