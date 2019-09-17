package org.noedge.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Description:
 */
@Repository
public class Permission implements Serializable {
    private Integer id;
    private Integer personId;
    private Integer groupId;
    private Integer hostelId;
    private String type;
    private String createTime;
    private Integer createPId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePId() {
        return createPId;
    }

    public void setCreatePId(Integer createPId) {
        this.createPId = createPId;
    }
}
