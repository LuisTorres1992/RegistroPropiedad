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
public class UsuarioAutenticado implements Serializable {
    
        private long Id ;
        private String Name ;
        private String Username ;
        private String Password;
        private String Token;
        private String DateTimeTokenExpire;

    public UsuarioAutenticado(String Name, String Username, String Password, String Token, String DateTimeTokenExpire) {
        this.Name = Name;
        this.Username = Username;
        this.Password = Password;
        this.Token = Token;
        this.DateTimeTokenExpire = DateTimeTokenExpire;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getDateTimeTokenExpire() {
        return DateTimeTokenExpire;
    }

    public void setDateTimeTokenExpire(String DateTimeTokenExpire) {
        this.DateTimeTokenExpire = DateTimeTokenExpire;
    }
    
}
