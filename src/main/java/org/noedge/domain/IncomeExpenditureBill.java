package org.noedge.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Description:
 */
@Repository
public class IncomeExpenditureBill implements Serializable {
    private Integer id;
    private Integer hostelId;
    private String content;
    private Double amount;
    private String spendTime;
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

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
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
