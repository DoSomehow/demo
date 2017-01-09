package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/2.
 */
public class FinallyWorks {

    static int count = 0;

    public static void main(String[] args){
        while(true){
            try{
                if(count++ == 0)
                    throw new ThreeException();
                System.out.println(count + " No exception");
            }catch (ThreeException e){
                System.out.println(count + " ThreeException");
            }finally {
                System.out.println(count + " In finally clause");
                if(count == 3 ) break;
            }


        }
    }

}
