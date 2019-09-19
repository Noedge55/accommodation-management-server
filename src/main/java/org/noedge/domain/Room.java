package org.noedge.domain;

import org.springframework.stereotype.Repository;

/**
 * @Description:
 */
@Repository
public class Room {
    private Integer id;
    private String name;
    private Integer totalNum;
    private Integer hostelId;
    private String createTime;
    private String updateTime;
    private Integer createPId;
    private Integer lastUpdatePId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCreatePId() {
        return createPId;
    }

    public void setCreatePId(Integer createPId) {
        this.createPId = createPId;
    }

    public Integer getLastUpdatePId() {
        return lastUpdatePId;
    }

    public void setLastUpdatePId(Integer lastUpdatePId) {
        this.lastUpdatePId = lastUpdatePId;
    }
}
