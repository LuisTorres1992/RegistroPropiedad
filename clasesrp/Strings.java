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
public class Strings
{
    public static final String NULL_STRING = "null";
    public static final String EMPTY = "";
    public static final String NEW_LINE = System.getProperty("line.separator");

    public static String coalesce(String value, @NotNull String replaceValue)
    {
        return value == null ? replaceValue: value;
    }

    public static String coalesceWithEmpty(String value)
    {
        return coalesce(value, EMPTY);
    }

    public static String coalesceWithNullString(String value)
    {
            return coalesce(value, NULL_STRING);
    }

    public static Boolean isNullOrWhiteSpace(String value)
    {
        if (value == null)
        {
            return true;
        }
        return value.trim().length() == 0;
    }

    public static String escapeUnicode(@NotNull String input)
    {
        StringBuilder b = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            b.append(String.format("\\u%04x", (int)c));
        }
        return b.toString();
    }

    public static String format(@NotNull String format, Object... params)
    {
        for (int i = 0; i < params.length; i++) {
            format = format.replace(String.format("{%s}" , i), params[i].toString());
        }
        return format;
    }

    public static Boolean isNullOrEmpty(@NotNull String value)
    {
        if (value != null)
        {
            return value.length() == 0;
        }
        else
        {
            return true;
        }
    }

    public static String randomPadLeft(@NotNull String value, /*@IntRange(from = 0)*/ int maxWidth, char paddingChar)
    {
        return padLeft(value, RandomManager.generate(1, maxWidth), paddingChar);
    }

    public static String padLeft(@NotNull String value, /*@IntRange(from = 0)*/ int totalWidth, char paddingChar)
    {
        if(totalWidth <= value.length())
        {
            return value;
        }

        return String.format(format("%{0}s%s" , totalWidth - value.length()), paddingChar, value).replace(" " , String.valueOf(paddingChar));
    }

    public static String randomPadRight(@NotNull String value, /*@IntRange(from = 0)*/ int maxWidth, char paddingChar)
    {
        return padRight(value, RandomManager.generate(1, maxWidth), paddingChar);
    }

    public static String padRight(@NotNull String value, /*@IntRange(from = 0)*/ int totalWidth, char paddingChar)
    {
        if(totalWidth <= value.length())
        {
            return value;
        }

        return String.format(format("%s%{0}s" , totalWidth - value.length()), value,paddingChar).replace(" ", String.valueOf(paddingChar));
    }

    public static String reverse(@NotNull String value)
    {
        return new StringBuilder(value).reverse().toString();
    }

}

