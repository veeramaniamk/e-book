package com.saveetha.e_book.adminscreens.adminmodules;

public class AdminBooksModule {

    String bookName,coverImage,description,author,publisher,category;

    public AdminBooksModule(String bookName, String coverImage, String description) {
        this.bookName = bookName;
        this.coverImage = coverImage;
        this.description = description;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }
}
