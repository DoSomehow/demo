package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/20.
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //既然所有数组无论他们持有的类型如何，都具有相同的结构（每个数组槽位的尺寸和数组的布局），那么看起来你应该能够创建
        //一个Object数组，并将其转型为所希望的数组类型。
        //事实上，这可以编译，但是不能运行，它将产生ClassCastException

        //Compiles: produces ClassCastException
        // gia = (Generic<Integer>[])new Object[SIZE];
        //Runtime type is the raw (erased) type:
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        // gia[1] = new Object(); //Compile-time error
        //Discovers type mismatch at compile time:
        // gia[2] = new Generic<Double>();

        //问题在于数组将跟踪它们的实际类型，而这个类型是在数组被创建时确定的，因此，即使gia已经被转型为Generic<Integer>[]，
        //但是这个信息只存在于编译期（并且如果没有@SuppressWarnings注解，你将得到有关这个转型的警告）。在运行时，它仍旧是
        //Object数组，而这将引发问题。
        //成功创建泛型数组的唯一方式就是创建一个被擦除类型的新数组，然后对其转型。
    }
}
