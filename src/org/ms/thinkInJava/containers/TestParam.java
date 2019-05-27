package org.ms.thinkInJava.containers;

public class TestParam {

    public final int size;
    public final int loops;

    public TestParam(int size, int loops){
        this.size = size;
        this.loops = loops;
    }

    //Create an array of TestParam from varargs sequence:
    public static TestParam[] array(int... values){
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            //意思是，对于values这个数组，需要是偶数个，
            //然后比如，第一个作为size，第二个作为loops，第三个继续作为size，第四个作为loops，以此类推
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    //Convert a String array to a TestParam array:
    public static TestParam[] array(String[] values){
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }

}
