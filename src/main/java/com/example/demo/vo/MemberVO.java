package com.example.demo.vo;


import java.time.LocalDateTime;

public class MemberVO {
    private int member_no;
    private String member_id;
    private String member_pw;
    private String member_nick;
    private String member_email;
    private String member_phone;
    private int member_gender;
    private int member_idDeleted;
    private LocalDateTime member_created_date;
    private LocalDateTime member_changed_date;


    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getMember_nick() {
        return member_nick;
    }

    public void setMember_nick(String member_nick) {
        this.member_nick = member_nick;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public int getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(int member_gender) {
        this.member_gender = member_gender;
    }

    public int getMember_idDeleted() {
        return member_idDeleted;
    }

    public void setMember_idDeleted(int member_idDeleted) {
        this.member_idDeleted = member_idDeleted;
    }

    public LocalDateTime getMember_created_date() {
        return member_created_date;
    }

    public void setMember_created_date(LocalDateTime member_created_date) {
        this.member_created_date = member_created_date;
    }

    public LocalDateTime getMember_changed_date() {
        return member_changed_date;
    }

    public void setMember_changed_date(LocalDateTime member_changed_date) {
        this.member_changed_date = member_changed_date;
    }

    @Override
    public String toString() {
        return member_no+" | "+member_id;
    }
}
