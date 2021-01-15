package org.ms.javaTest;

import org.apache.commons.lang3.time.DateUtils;
import org.ms.javaTest.entity.DevStorage;
import org.ms.javaTest.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/12/7 11:17
 */
public class TestSort {

    public static void main(String[] args) {
        // testMultiReverse();
        testSortDevStorage();
    }


    public static void testSortDevStorage() {
        List<DevStorage> devStorageList = getDevStorageList();
        devStorageList.sort(
            Comparator.comparing(DevStorage::getWhType)
                    // .thenComparing(DevStorage::getLatestChkDate)
                    .thenComparing(DevStorage::getLatestChkDate, (o1, o2) -> o2.compareTo(o1))
                    .thenComparing(DevStorage::getQty)
                .reversed()
        );
        devStorageList.forEach(d -> System.out.println(d));
    }

    public static void testMultiReverse() {
        List<Student> studentList = getStudentList();
        studentList.sort(
            Comparator.comparing(Student::getSex)
                    // .reversed()
                .thenComparing(Student::getAge)
                    .reversed()
        );
        for (Student student : studentList) {
            System.out.println(student);
        }
        //结论：每次reversed都会把前边所有排序的项，都反过来
    }

    public static List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("张三");
        student.setSex("1");
        student.setAge(10L);
        studentList.add(student);

        student = new Student();
        student.setName("李四");
        student.setSex("1");
        student.setAge(5L);
        studentList.add(student);

        student = new Student();
        student.setName("王五");
        student.setSex("0");
        student.setAge(7L);
        studentList.add(student);

        student = new Student();
        student.setName("赵六");
        student.setSex("1");
        student.setAge(4L);
        studentList.add(student);

        student = new Student();
        student.setName("孙七");
        student.setSex("0");
        student.setAge(10L);
        studentList.add(student);

        student = new Student();
        student.setName("周八");
        student.setSex("0");
        student.setAge(15L);
        studentList.add(student);

        return studentList;
    }

    public static List<DevStorage> getDevStorageList() {
        List<DevStorage> devStorageList = new ArrayList<>();
        Date now = new Date();
        DevStorage devStorage = new DevStorage();
        devStorage.setWhType("01");
        devStorage.setLatestChkDate(DateUtils.addDays(now, 1));
        devStorage.setQty(300L);
        devStorageList.add(devStorage);

        devStorage = new DevStorage();
        devStorage.setWhType("02");
        devStorage.setLatestChkDate(DateUtils.addDays(now, -3));
        devStorage.setQty(100L);
        devStorageList.add(devStorage);

        devStorage = new DevStorage();
        devStorage.setWhType("02");
        devStorage.setLatestChkDate(DateUtils.addDays(now, 1));
        devStorage.setQty(400L);
        devStorageList.add(devStorage);

        devStorage = new DevStorage();
        devStorage.setWhType("01");
        devStorage.setLatestChkDate(DateUtils.addDays(now, 5));
        devStorage.setQty(100L);
        devStorageList.add(devStorage);

        devStorage = new DevStorage();
        devStorage.setWhType("02");
        devStorage.setLatestChkDate(DateUtils.addDays(now, 1));
        devStorage.setQty(200L);
        devStorageList.add(devStorage);

        devStorage = new DevStorage();
        devStorage.setWhType("01");
        devStorage.setLatestChkDate(DateUtils.addDays(now, -7));
        devStorage.setQty(300L);
        devStorageList.add(devStorage);

        return devStorageList;
    }

}
