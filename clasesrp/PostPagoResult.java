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
public class PostPagoResult extends BaseResult implements Serializable {

private long idRespuesta;
private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
private String observacion;

/**
* No args constructor for use in serialization
* 
*/
public PostPagoResult() {
}

/**
* 
* @param observacion
* @param idRespuesta
* @param total
*/
public PostPagoResult(long idRespuesta, String observacion , float total) {
super();
this.idRespuesta = idRespuesta;
this.observacion = observacion;
this.total = total;
}

public long getIdRespuesta() {
return idRespuesta;
}

public void setIdRespuesta(long idRespuesta) {
this.idRespuesta = idRespuesta;
}

public String getObservacion() {
return observacion;
}

public void setObservacion(String observacion) {
this.observacion = observacion;
}
}
