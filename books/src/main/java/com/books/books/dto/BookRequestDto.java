package com.books.books.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookRequestDto {
    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "TItle must be 2-100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
