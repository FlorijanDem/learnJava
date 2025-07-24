package com.books.books.model;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Taked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer takedId;

    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;

    public Integer getTakedId() {
        return takedId;
    }

    public void setTakedId(Integer takedId) {
        this.takedId = takedId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
