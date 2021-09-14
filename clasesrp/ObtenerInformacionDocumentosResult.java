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
public class ObtenerInformacionDocumentosResult extends BaseResult{
     public ArrayList<InformacionDocumento> informacionDocumentos ;
        public String hash;

    public ObtenerInformacionDocumentosResult() {
    }

    public ArrayList<InformacionDocumento> getInformacionDocumentos() {
        return informacionDocumentos;
    }

    public void setInformacionDocumentos(ArrayList<InformacionDocumento> informacionDocumentos) {
        this.informacionDocumentos = informacionDocumentos;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    
        
}
