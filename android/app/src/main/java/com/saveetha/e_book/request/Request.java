package com.saveetha.e_book.request;

public class Request {

    public static class GetPublisherBook {
        private int publisher_id;

        public GetPublisherBook(int publisher_id) {
            this.publisher_id = publisher_id;
        }
    }

    public static class UpdateProfile {
        private String name;
        private String phone;
        private String email;
        private String gender;
        private String user_id;

        public UpdateProfile(String name, String phone, String email, String gender, String user_id) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.gender = gender;
            this.user_id = user_id;
        }
    }

    public static class ChangePassword {
        private String user_id;
        private String email;
        private String current_password;
        private String new_password;

        public ChangePassword(String user_id, String email, String current_password, String new_password) {
            this.user_id = user_id;
            this.email = email;
            this.current_password = current_password;
            this.new_password = new_password;
        }
    }

    public static class SendReview {

        private String book_id;
        private int user_id;
        private String publisher_id;
        private String review_text;


        public SendReview(String bookId, int userId, String bookPublisherId, String reviewText) {
            this.book_id = bookId;
            this.user_id = userId;
            this.publisher_id = bookPublisherId;
            this.review_text = reviewText;
        }
    }

    public static class GetBookReview {
        private String book_id;

        public GetBookReview(String book_id) {
            this.book_id = book_id;
        }
    }
}
