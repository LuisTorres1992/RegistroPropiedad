/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author evill
 */
public class PostAutentificacionParam extends BaseParam implements Serializable {

    public Object data;
    public Object key;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public PostAutentificacionParam(long page) {
        super(page);
    }

    public PostAutentificacionParam(Object data, Object key,long page) {
        super(page);
        this.data = data;
        this.key = key;
    }

    public PostAutentificacionParam(Object data) {
        super(1);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
