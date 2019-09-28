package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Email(message = "Email không hợp lệ, vui lòng nhập lại <3")
    private String email;
    private String name;
    private String password;
    private String role; // admin | user | employee
    @Size(min = 7, max = 50)
    private String masv;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private int status;
   /* @ManyToMany(mappedBy = "studentSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<AptechClass> aptechClassSet;

    public Set<AptechClass> getAptechClassSet() {
        return aptechClassSet;
    }

    public void setAptechClassSet(Set<AptechClass> aptechClassSet) {
        this.aptechClassSet = aptechClassSet;
    }*/

    public enum Role {
        ADMIN("admin"), STUDENT("student");
        private String value;

        Role(String student) {
            this.value = student;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
