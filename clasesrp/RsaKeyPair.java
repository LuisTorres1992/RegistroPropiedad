/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import javax.validation.constraints.NotNull;

/**
 *
 * @author evill
 */
public class RsaKeyPair
{
    //@Keep
    private String PublicKey;
    //@Keep
    private String PrivateKey;

    public RsaKeyPair()
    {
    }

    public RsaKeyPair(@NotNull String PublicKey, @NotNull String PrivateKey)
    {
        this.PublicKey = PublicKey;
        this.PrivateKey = PrivateKey;
    }

    public String getPublicKey()
    {
        return PublicKey;
    }

    public void setPublicKey(String PublicStringKey)
    {
        this.PublicKey = PublicStringKey;
    }

    public String getPrivateKey()
    {
        return PrivateKey;
    }

    public void setPrivateKey(String PrivateStringKey)
    {
        this.PrivateKey = PrivateStringKey;
    }
    
    @Override
    public String toString()
    {
        return Strings.format("Public{0}{1}{0}Private{0}{2}", Strings.NEW_LINE, Strings.coalesceWithNullString(PublicKey), Strings.coalesceWithNullString(PrivateKey));
    }
}
