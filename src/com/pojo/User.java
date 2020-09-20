package com.pojo;

import java.util.Date;

public class User {
    private String uid;

    private String username;

    private String password;

    private String hphoto;

    private String sex;

    private Date birthday;

    private String profession;

    private String city;

    private String introduction;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHphoto() {
        return hphoto;
    }

    public void setHphoto(String hphoto) {
        this.hphoto = hphoto == null ? null : hphoto.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", hphoto=" + hphoto
				+ ", sex=" + sex + ", birthday=" + birthday + ", profession=" + profession + ", city=" + city
				+ ", introduction=" + introduction + "]";
	}
    
    
}