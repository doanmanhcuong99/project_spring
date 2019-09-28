package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    @Email(message = "Email không hợp lệ, vui lòng nhập lại <3")
    private String email;
    private String name;
    private String password;
    @Size(max = 7, message = "Tối đa 7 kí tự.")
    private String masv;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(long deleteAt) {
        this.deleteAt = deleteAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
