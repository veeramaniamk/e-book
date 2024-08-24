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

}
