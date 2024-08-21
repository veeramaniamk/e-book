package com.saveetha.e_book.request;

public class Request {

    public static class GetPublisherBook {
        private int publisher_id;

        public GetPublisherBook(int publisher_id) {
            this.publisher_id = publisher_id;
        }
    }

}
