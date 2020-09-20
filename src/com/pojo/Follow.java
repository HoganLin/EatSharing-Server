package com.pojo;

public class Follow {
    private Integer foid;

    private String uidUser;

    private String uidEd;

    public Integer getFoid() {
        return foid;
    }

    public void setFoid(Integer foid) {
        this.foid = foid;
    }

    public String getUidUser() {
        return uidUser;
    }

    public void setUidUser(String uidUser) {
        this.uidUser = uidUser == null ? null : uidUser.trim();
    }

    public String getUidEd() {
        return uidEd;
    }

    public void setUidEd(String uidEd) {
        this.uidEd = uidEd == null ? null : uidEd.trim();
    }
}