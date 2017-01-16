package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.util.Null;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test {
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for(Operation operation:r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
