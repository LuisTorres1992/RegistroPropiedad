/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

/**
 *
 * @author evill
 */
public enum HashAlgorithm {

    /**
     * Valor para el algoritmo SHA512.
     */
    SHA512("SHA-512"),

    /**
     * Valor para el algoritmo SHA256.
     */
    SHA256("SHA-256"),

    /**
     * Valor para el algoritmo SHA384.
     */
    SHA384("SHA-384"),

    /**
     * Valor para el algoritmo SHA1.
     */
    SHA1("SHA-1"),
    /**
     * Valor para el algoritmo MD5.
     */
    MD5("MD5");


    private String Value = "";


    HashAlgorithm(String Value) {
        this.Value = Value;
    }


    @Override
    public String toString() {
        return Value;
    }

}
