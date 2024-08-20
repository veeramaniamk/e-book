package com.saveetha.e_book.reviewerscrees.modules;

public class ReviewerBooksModule {

    private final String bookName;
    private final String coverImage;
    private final String description;

    public ReviewerBooksModule(String bookName, String coverImage, String description) {
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


}
