package com.saveetha.e_book.response.admin;

public class GetSingleBookData {
    private int bookId;
    private int publisherId;
    private String publisherName;
    private String bookDescription;
    private String bookCoverImage;
    private String demoBook;
    private String book_title;
    private String bookPdf;
    private String autherName;
    private String yearOfTheBook;
    private String bookSubmitDate;
    private String bookApprovalStatus;
    private String bookApprovalDate;
    private String bookCancelledMsg;
    private boolean paymentStatus;

    public String getBook_title() {
        return book_title;
    }

    public int getBookId() {
        return bookId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookCoverImage() {
        return bookCoverImage;
    }

    public String getDemoBook() {
        return demoBook;
    }

    public String getBookPdf() {
        return bookPdf;
    }

    public String getAutherName() {
        return autherName;
    }

    public String getYearOfTheBook() {
        return yearOfTheBook;
    }

    public String getBookSubmitDate() {
        return bookSubmitDate;
    }

    public String getBookApprovalStatus() {
        return bookApprovalStatus;
    }

    public String getBookApprovalDate() {
        return bookApprovalDate;
    }

    public String getBookCancelledMsg() {
        return bookCancelledMsg;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }
}
