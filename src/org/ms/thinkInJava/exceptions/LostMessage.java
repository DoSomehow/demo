package org.ms.thinkInJava.exceptions;

/**
 * 异常丢失
 * Created by Administrator on 2017/1/3.
 */
public class LostMessage {
    public void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    public void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try{
            LostMessage lm = new LostMessage();
            try{
                lm.f();
            }finally {
                lm.dispose();  //VeryImportantException不见了，它被finally子句离得HoHumException所取代。
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
