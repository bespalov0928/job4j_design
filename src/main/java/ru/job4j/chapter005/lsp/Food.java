package ru.job4j.chapter005.lsp;

import java.util.Date;

public class Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private Integer price;
    private Integer disscount;

    public Food(String name, Date expaireDate, Date createDate, Integer price, Integer disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDisscount() {
        return disscount;
    }

    public void setDisscount(Integer disscount) {
        this.disscount = disscount;
    }

    public double getTerm() {
        double rsl;
        Date currentDate = new Date();
        double delta1 =  currentDate.getTime() - expaireDate.getTime();
        double delta2 =  createDate.getTime() - expaireDate.getTime();
        if (delta2 <= 0) {
            return 100;
        }
        rsl = 100 - (delta1 / delta2 * 100);
        return rsl;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expaireDate=" + expaireDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", disscount=" + disscount +
                '}';
    }
}
