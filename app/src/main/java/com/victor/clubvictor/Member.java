package com.victor.clubvictor;

public class Member {
    private Integer id;
    private String name;
    private String phone;
    private String ci;

    public Member() {
    }

    public Member(Integer id, String name,  String telefono, String ci) {
        this.id = id;
        this.name = name;
        this.phone = telefono;
        this.ci = ci;

    }

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



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}



