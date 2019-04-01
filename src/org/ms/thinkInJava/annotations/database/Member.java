package org.ms.thinkInJava.annotations.database;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/29 22:09
 */
@DBTable(name = "MEMBER")
public class Member {

    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;

    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return handle;
    }
}
