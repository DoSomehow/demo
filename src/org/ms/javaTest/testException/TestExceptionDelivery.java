package org.ms.javaTest.testException;

import org.w3c.dom.ranges.RangeException;

/**
 * @author Ryan
 * @date 2021/2/14 10:23
 */
public class TestExceptionDelivery {

    public static void main(String[] args) {

        try {
            TestExceptionDelivery ted = new TestExceptionDelivery();
            ted.testDelivery();
        } catch (Exception e) {
            System.out.println("*****************");
            e.printStackTrace();
            System.out.println("*****************");
        }


    }

    public void testDelivery() {

        try {
            //
            RangeException re = new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR, "sorry");
            throw re;
        } catch (NullPointerException e1) {

        } catch (IndexOutOfBoundsException e2) {

        } catch (RangeException e3) {
            throw e3;  //只是这里抛出，但是方法上不添加throws，那么调用者那儿就不会有强制处理的要求。
        }

    }

}
