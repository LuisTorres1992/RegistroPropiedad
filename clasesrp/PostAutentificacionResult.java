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
public class PostAutentificacionResult  extends BaseResult implements Serializable {

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public PostAutentificacionResult(Object data, Object key) {
        this.data = data;
        this.key = key;
    }

    public PostAutentificacionResult(Object data, Object key, String dateTime, long result, long indexPage, long lastPage) {
        super(dateTime, result, indexPage, lastPage);
        this.data = data;
        this.key = key;
    }
    private Object data;
    private Object key;
    
}
