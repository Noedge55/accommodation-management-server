package org.noedge.domain;

import org.springframework.stereotype.Repository;

/**
 * @Description:订单
 */
@Repository
public class CheckInOrder {
    private Integer id;
    private Integer sourceId;
    private Integer livingNum;
    private String names;
    private String phone;
    private Integer hostelId;
    private String checkInDate;
    private String checkOutDate;
    private String createTime;
    private String updateTime;
    private Integer createPID;
    private Integer lastUpdatePID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getLivingNum() {
        return livingNum;
    }

    public void setLivingNum(Integer livingNum) {
        this.livingNum = livingNum;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreatePID() {
        return createPID;
    }

    public void setCreatePID(Integer createPID) {
        this.createPID = createPID;
    }

    public Integer getLastUpdatePID() {
        return lastUpdatePID;
    }

    public void setLastUpdatePID(Integer lastUpdatePID) {
        this.lastUpdatePID = lastUpdatePID;
    }
}
