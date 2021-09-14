
package clasesrp;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostProformaResult extends BaseResult implements Serializable {

    private String guidPago;
    private List<Contrato> contratos = new ArrayList<Contrato>();
    private double total;
    private String observacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostProformaResult() {
    }

    /**
     * 
     * @param total
     * @param guidPago
     * @param observacion
     * @param contratos
     */
    public PostProformaResult(String guidPago, List<Contrato> contratos, double total, String observacion) {
        super();
        this.guidPago = guidPago;
        this.contratos = contratos;
        this.total = total;
        this.observacion = observacion;
    }

    public String getGuidPago() {
        return guidPago;
    }

    public void setGuidPago(String guidPago) {
        this.guidPago = guidPago;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
