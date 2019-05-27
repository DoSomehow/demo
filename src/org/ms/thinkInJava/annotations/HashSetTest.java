package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;
import org.ms.thinkInJava.util.OSExecute;

import java.util.HashSet;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 22:50
 */
public class HashSetTest {

    HashSet<String> testObejct = new HashSet<>();

    @Test
    void initialization() {
        assert testObejct.isEmpty();
    }

    @Test
    void _contains() {
        testObejct.add("one");
        assert testObejct.contains("one");
    }

    @Test
    void _remove() {
        testObejct.add("one");
        testObejct.remove("one");
        assert testObejct.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindView.atunit.AtUnit HashSetTest");
    }

}
