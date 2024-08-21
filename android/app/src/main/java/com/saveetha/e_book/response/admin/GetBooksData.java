package com.saveetha.e_book.response.admin;

public class GetBooksData {


    private int book_id;
    private int publisher_id;
    private String publisher_name;
    private String book_cover_image;
    private String auther_name;
    private String year_of_the_book;
    private String book_submit_date;
    private String book_description;
    private String book_approval_status;
    private String book_approval_date;
    private String book_cancelled_msg;
    private String book_title;
    private String book_pdf;
    private String demo_book;

    public String getBook_pdf() {
        return book_pdf;
    }

    public String getDemo_book() {
        return demo_book;
    }

    public String getBook_description() {
        return book_description;
    }

    public String getBook_title() {
        return book_title;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public String getBook_cover_image() {
        return book_cover_image;
    }

    public String getAuther_name() {
        return auther_name;
    }

    public String getYear_of_the_book() {
        return year_of_the_book;
    }

    public String getBook_submit_date() {
        return book_submit_date;
    }

    public String getBook_approval_status() {
        return book_approval_status;
    }

    public String getBook_approval_date() {
        return book_approval_date;
    }

    public String getBook_cancelled_msg() {
        return book_cancelled_msg;
    }
}
