package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;
import org.ms.thinkInJava.util.OSExecute;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 23:15
 */
public class StackLStringTest extends StackL<String> {

    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindView.atunit.AtUnit StackLStringTest");
    }

}
