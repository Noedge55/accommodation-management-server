package org.noedge.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Description: 旅社类
 */
@Repository
public class Hostel implements Serializable {
    private Integer id;
    private String name;
    private String area;
    private String address;
    private String createTime;
    private String updateTime;
    private Integer createPId;
    private Integer last_updatePId;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Integer getCreatePId() {
        return createPId;
    }

    public void setCreatePId(Integer createPId) {
        this.createPId = createPId;
    }

    public Integer getLast_updatePId() {
        return last_updatePId;
    }

    public void setLast_updatePId(Integer last_updatePId) {
        this.last_updatePId = last_updatePId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
