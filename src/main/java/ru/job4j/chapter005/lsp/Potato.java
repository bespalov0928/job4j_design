package ru.job4j.chapter005.lsp;

import java.util.Date;

public class Potato extends Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private Integer price;
    private Integer disscount;

    public Potato(String name, Date expaireDate, Date createDate, Integer price, Integer disscount) {
        super(name, expaireDate, createDate, price, disscount);

    }

}
