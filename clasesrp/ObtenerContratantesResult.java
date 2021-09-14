/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;


import java.util.ArrayList;

/**
 *
 * @author Juancho
 */
public class ObtenerContratantesResult extends BaseResult{
        public ArrayList<Contratante> contratantes ;
        public InformacionFacturacion informacionFacturacion;
        public InformacionInscripcion informacionInscripcion;
        public InformacionDinardap informacionDinardap;
        public ArrayList<InformacionCatastral> indicesAsociados;

        public ArrayList<InformacionPago> informacionPago;

    public ObtenerContratantesResult() {
    }

    public ArrayList<Contratante> getContratantes() {
        return contratantes;
    }

    public void setContratantes(ArrayList<Contratante> contratantes) {
        this.contratantes = contratantes;
    }

    public InformacionFacturacion getInformacionFacturacion() {
        return informacionFacturacion;
    }

    public void setInformacionFacturacion(InformacionFacturacion informacionFacturacion) {
        this.informacionFacturacion = informacionFacturacion;
    }

    public InformacionInscripcion getInformacionInscripcion() {
        return informacionInscripcion;
    }

    public void setInformacionInscripcion(InformacionInscripcion informacionInscripcion) {
        this.informacionInscripcion = informacionInscripcion;
    }

    public InformacionDinardap getInformacionDinardap() {
        return informacionDinardap;
    }

    public void setInformacionDinardap(InformacionDinardap informacionDinardap) {
        this.informacionDinardap = informacionDinardap;
    }

    public ArrayList<InformacionCatastral> getIndicesAsociados() {
        return indicesAsociados;
    }

    public void setIndicesAsociados(ArrayList<InformacionCatastral> indicesAsociados) {
        this.indicesAsociados = indicesAsociados;
    }

    public ArrayList<InformacionPago> getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(ArrayList<InformacionPago> informacionPago) {
        this.informacionPago = informacionPago;
    }

   
        
        
}
