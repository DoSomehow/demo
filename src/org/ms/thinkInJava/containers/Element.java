package org.ms.thinkInJava.containers;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:26
 */
public class Element {

    private String ident;
    public Element(String id){
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    public boolean equals(Object r){
        return r instanceof Element && ident.equals(((Element) r).ident);
    }

    protected void finalize(){
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
