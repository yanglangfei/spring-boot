package com.yf.springboot.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
public class TbUser  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",columnDefinition = "varchar(5) COMMENT '用户名'")
    private String userName;
    private String password;
    private  String headFace;
    /**
     * 创建时自动更新时间
     */
    @CreationTimestamp
    private Date gmtCreate;
    /**
     * 更新时自动更新时间
     */
    @UpdateTimestamp
    private  Date gmtModified;

    /**
     * 版本号，更新时自动加1
     */
    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadFace() {
        return headFace;
    }

    public void setHeadFace(String headFace) {
        this.headFace = headFace;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public TbUser() {

    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
