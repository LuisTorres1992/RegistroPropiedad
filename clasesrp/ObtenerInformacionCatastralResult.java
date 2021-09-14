/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JC
 */
public class ObtenerInformacionCatastralResult extends BaseResult implements Serializable{

    private ArrayList<InformacionCatastral> data ;

    public ArrayList<InformacionCatastral> getData() {
        return data;
    }

    public void setData(ArrayList<InformacionCatastral> data) {
        this.data = data;
    }

    public ObtenerInformacionCatastralResult() {
    }
    
    
 
    }
    
