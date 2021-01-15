package org.ms.javaTest.entity;

import java.util.Date;

/**
 * @author Ryan
 * @date 2020/12/7 12:50
 */
public class DevStorage {

    private String whType;
    private Long qty;
    private Date latestChkDate;

    public String getWhType() {
        return whType;
    }

    public void setWhType(String whType) {
        this.whType = whType;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Date getLatestChkDate() {
        return latestChkDate;
    }

    public void setLatestChkDate(Date latestChkDate) {
        this.latestChkDate = latestChkDate;
    }

    @Override
    public String toString() {
        return "DevStorage{" +
                "whType='" + whType + '\'' +
                ", qty=" + qty +
                ", latestChkDate='" + latestChkDate + '\'' +
                '}';
    }

}
