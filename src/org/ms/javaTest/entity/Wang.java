package org.ms.javaTest.entity;

/**
 * Created by Administrator on 2017/1/8.
 */
public class Wang {
    private String name;
    private Long cap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCap() {
        return cap;
    }

    public void setCap(Long cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Wang{" +
                "name='" + name + '\'' +
                ", cap=" + cap +
                '}';
    }
}
