package org.ms.tool.common;

import java.io.UnsupportedEncodingException;

public class HexStrToStr {

    public static void main(String[] args) {

        String paramStr = "7b4d4554484f443a27676574476d6f4469637456616c7565272c4c4153545f53694e5f54494d453a27277d";
        String result = hexStr2Str(paramStr);
        System.out.println(result);
    }

    private static String hexStr2Str(String paramStr){
        if ((paramStr == null) || ("".equals(paramStr))) {
            return "";
        }
        paramStr = paramStr.replace(" ", "");
        byte[] baKeyword = new byte[paramStr.length() / 2];
        for (int i = 0; i < baKeyword.length; i++)
            baKeyword[i] = ((byte)(0xFF & Integer.parseInt(paramStr.substring(i * 2, i * 2 + 2), 16)));
        try
        {
            paramStr = new String(baKeyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return paramStr;
    }

}
