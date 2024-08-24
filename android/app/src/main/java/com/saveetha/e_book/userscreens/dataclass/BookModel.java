package com.saveetha.e_book.userscreens.dataclass;

public class BookModel {
    String name,imageUrl;

    public BookModel(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }
}
