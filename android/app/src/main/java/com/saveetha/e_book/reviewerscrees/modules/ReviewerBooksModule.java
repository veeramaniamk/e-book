package com.saveetha.e_book.reviewerscrees.modules;

public class ReviewerBooksModule {

    String bookName,coverImage,description,author,publisher,category;
    String pages,price;

    public ReviewerBooksModule(String bookName, String coverImage, String description) {
        this.bookName = bookName;
        this.coverImage = coverImage;
        this.description = description;
    }

    public ReviewerBooksModule(String bookName, String coverImage, String description, String price) {
        this.bookName = bookName;
        this.coverImage = coverImage;
        this.description = description;
        this.price = price;
    }

    public String getPages() {
        return pages;
    }

    public String getPrice() {
        return price;
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
