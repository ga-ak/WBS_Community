package com.example.demo.vo;

import java.time.LocalDateTime;

public class ArticleVO {
    private int article_no;
    private int article_pno;
    private int board_no;
    private int member_no;
    private String article_name;
    private String article_content;
    private int article_recommends;
    private int article_views;
    private int article_images;
    private String article_ip;
    private int article_reports;
    private LocalDateTime article_created_time;
    private LocalDateTime article_changed_time;
    private int article_isDeleted;

    public int getArticle_no() {
        return article_no;
    }

    public void setArticle_no(int article_no) {
        this.article_no = article_no;
    }

    public int getArticle_pno() {
        return article_pno;
    }

    public void setArticle_pno(int article_pno) {
        this.article_pno = article_pno;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public int getArticle_recommends() {
        return article_recommends;
    }

    public void setArticle_recommends(int article_recommends) {
        this.article_recommends = article_recommends;
    }

    public int getArticle_views() {
        return article_views;
    }

    public void setArticle_views(int article_views) {
        this.article_views = article_views;
    }

    public int getArticle_images() {
        return article_images;
    }

    public void setArticle_images(int article_images) {
        this.article_images = article_images;
    }

    public String getArticle_ip() {
        return article_ip;
    }

    public void setArticle_ip(String article_ip) {
        this.article_ip = article_ip;
    }

    public int getArticle_reports() {
        return article_reports;
    }

    public void setArticle_reports(int article_reports) {
        this.article_reports = article_reports;
    }

    public LocalDateTime getArticle_created_time() {
        return article_created_time;
    }

    public void setArticle_created_time(LocalDateTime article_created_time) {
        this.article_created_time = article_created_time;
    }

    public LocalDateTime getArticle_changed_time() {
        return article_changed_time;
    }

    public void setArticle_changed_time(LocalDateTime article_changed_time) {
        this.article_changed_time = article_changed_time;
    }

    public int getArticle_isDeleted() {
        return article_isDeleted;
    }

    public void setArticle_isDeleted(int article_isDeleted) {
        this.article_isDeleted = article_isDeleted;
    }
}
