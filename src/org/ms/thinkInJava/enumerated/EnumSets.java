package org.ms.thinkInJava.enumerated;

import java.util.EnumSet;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/27 21:14
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);  //Empty set
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);
    }

}
