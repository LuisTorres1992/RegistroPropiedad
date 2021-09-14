/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import java.security.SecureRandom;

/**
 *
 * @author evill
 */
public class RandomManager {

    public static int generate(/*@IntRange(from = 0)*/ int min, /*@IntRange(from = 0)*/ int max)
    {
        SecureRandom rnd = new SecureRandom();
        return min + rnd.nextInt(max - min + 1);
    }
    
    public static byte[] generate(int size)
    {
        byte[] bytes = new byte[size];
        SecureRandom rnd = new SecureRandom();
        rnd.nextBytes(bytes);
        return bytes;
    }

}
