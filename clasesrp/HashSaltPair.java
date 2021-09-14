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
public class HashSaltPair
{

    //@Keep
    private String Hash;
    //@Keep
    private String Salt;

    public HashSaltPair()
    {
    }

    public HashSaltPair(@NotNull String Hash, @NotNull String Salt)
    {
        this.Hash = Hash;
        this.Salt = Salt;
    }

    public String getHash()
    {
        return Hash;
    }

    public void setHash(String Hash)
    {
        this.Hash = Hash;
    }

    public String getSalt()
    {
        return Salt;
    }

    public void setSalt(String Salt)
    {
        this.Salt = Salt;
    }

    @Override
    public String toString()
    {
        return Strings.format("Hash{0}{1}{0}Salt{0}{2}", Strings.NEW_LINE, Strings.coalesce(Hash, "null"), Strings.coalesce(Salt, "null"));
    }

    
}

