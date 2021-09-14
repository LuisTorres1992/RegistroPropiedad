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
public class BaseParam implements Serializable {

    private long page;
    
    public String getIp() {
        return ip;
    }

    private String ip;

    public BaseParam( long page) {
        this.page = page;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }
}
