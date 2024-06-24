package com.example.OnlineBookStore.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {

    private String username;
    private int bookId;
    private LocalDate date;

    // TODO 確認：書籍情報と注文情報(日時)をあわせて渡すためにBookの内容を含めているが、分離して別の処理で書籍情報を取得するべきなのか(Cartも同様)
    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;
}
