package cn.e3mall.po;

import java.util.Date;

/**
 * �û���
 * 
 * @author wcyong
 * 
 * @date 2020-06-11
 */
public class TbUser {
    private Long id;

    /**
     * �û���
     */
    private String username;

    /**
     * ���룬���ܴ洢
     */
    private String password;

    /**
     * ע���ֻ���
     */
    private String phone;

    /**
     * ע������
     */
    private String email;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}