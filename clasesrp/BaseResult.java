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
public class BaseResult implements Serializable {

    private String dateTime;
    private long result;
    private long indexPage;
    private long lastPage;
    private String trackId;

    /**
     * No args constructor for use in serialization
     *
     */
    public BaseResult() {
    }

    /**
     *
     * @param result
     * @param lastPage
     * @param dateTime
     * @param indexPage
     */
    public BaseResult(String dateTime, long result, long indexPage, long lastPage) {
        super();
        this.dateTime = dateTime;
        this.result = result;
        this.indexPage = indexPage;
        this.lastPage = lastPage;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public long getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(long indexPage) {
        this.indexPage = indexPage;
    }

    public long getLastPage() {
        return lastPage;
    }

    public void setLastPage(long lastPage) {
        this.lastPage = lastPage;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
}
