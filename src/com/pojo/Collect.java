package com.pojo;

public class Collect {
    private Integer cid;

    private String collectUid;

    private Integer collectSort;

    private String collectId;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCollectUid() {
        return collectUid;
    }

    public void setCollectUid(String collectUid) {
        this.collectUid = collectUid == null ? null : collectUid.trim();
    }

    public Integer getCollectSort() {
        return collectSort;
    }

    public void setCollectSort(Integer collectSort) {
        this.collectSort = collectSort;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId == null ? null : collectId.trim();
    }
}