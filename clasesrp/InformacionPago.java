/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

/**
 *
 * @author Juancho
 */
public class InformacionPago {
     public long id;
        public int proformaId;
        public String tipo;
        public String codigo;
        public String numero;
        public double baseImponible;
        public double retencionIva;
        public double retencionRenta;
        public double cobro;

    public InformacionPago() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getProformaId() {
        return proformaId;
    }

    public void setProformaId(int proformaId) {
        this.proformaId = proformaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public double getRetencionIva() {
        return retencionIva;
    }

    public void setRetencionIva(double retencionIva) {
        this.retencionIva = retencionIva;
    }

    public double getRetencionRenta() {
        return retencionRenta;
    }

    public void setRetencionRenta(double retencionRenta) {
        this.retencionRenta = retencionRenta;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }
        
        
}
