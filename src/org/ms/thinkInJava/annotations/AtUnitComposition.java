package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;
import org.ms.thinkInJava.util.OSExecute;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 22:41
 */
public class AtUnitComposition {

    AtUnitExample1 testObejct = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObejct.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObejct.methodTwo() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java net.mindView.atunit.AtUnit AtUnitComposition");
    }

}
