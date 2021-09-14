/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author Luis Torres F
 */
public class TokenInfo implements Serializable {

    public TokenInfo() {
    }

    public TokenInfo(String token) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            String jti1 = HashManager.base64ToString(token.split("\\.")[1]);
            TokenInfo tokenInfo = JsonManager.deserialize(jti1, TokenInfo.class);

            this.aud = tokenInfo.getAud();
            this.benefactor = tokenInfo.getBenefactor();
            this.entidad = tokenInfo.getEntidad();
            this.exp = tokenInfo.getExp();
            this.iat = tokenInfo.getIat();
            this.iss = tokenInfo.getIss();
            this.jti = tokenInfo.getJti();
            this.nbf = tokenInfo.getNbf();
            this.responsable = tokenInfo.getResponsable();
            this.role = tokenInfo.getRole();
            this.sitio = tokenInfo.getSitio();
            this.unique_name = tokenInfo.getUnique_name();
        } catch (Exception e) {

        }
    }

    public String getJtiSecure() {
        if (!getJti().isEmpty()) {
            try {
                return HashManager.toBase64(getJti(), true, true);
            } catch (Exception e) {
            }
        }
        return getJti();
    }

    public Date getExpiracionFecha() {
        Date expiracion = new Date(getExp());
        return expiracion;
    }

    public String getUnique_name() {
        return unique_name;
    }

    public void setUnique_name(String unique_name) {
        this.unique_name = unique_name;
    }

    public String getBenefactor() {
        return benefactor;
    }

    public void setBenefactor(String benefactor) {
        this.benefactor = benefactor;
    }

    public ArrayList<String> getRole() {
        return role;
    }

    public void setRole(ArrayList<String> role) {
        this.role = role;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public int getNbf() {
        return nbf;
    }

    public void setNbf(int nbf) {
        this.nbf = nbf;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAud() {
        return aud;
    }

    //{"unique_name":"jcsalazar","Benefactor":"GADME","role":["userentity","adminentity","user"],"Sitio":"https:/www.rdpce.gob.ec","Entidad":"RDPCE","Responsable":"DEPARTAMENTO DE TECNOLOGIAS DE LA INFORMACION","jti":"ES3XpNeoezixsW-j35Igcg,,","nbf":1631567741,"exp":1632172541,"iat":1631567741,"iss":"Issuer","aud":"Audience"}
    public void setAud(String aud) {
        this.aud = aud;
    }
    private String unique_name;
    @JsonProperty("Benefactor")
    private String benefactor;
    private ArrayList<String> role;
    @JsonProperty("Sitio")
    private String sitio;
    @JsonProperty("Entidad")
    private String entidad;
    @JsonProperty("Responsable")
    private String responsable;
    private String jti;
    private int nbf;
    private long exp;
    private int iat;
    private String iss;
    private String aud;
}
