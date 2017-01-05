/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class CareerForJson {

    private String code;
    private String name;
    private Long price;
    private String image;
    private String sortText;
    private String longText;
    private String show;

    public CareerForJson() {
    }

    public CareerForJson(String code, String name, Long price, String image, String sortText, String longText, String show) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
        this.sortText = sortText;
        this.longText = longText;
        this.show = show;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSortText() {
        return sortText;
    }

    public void setSortText(String sortText) {
        this.sortText = sortText;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "CareerForJson{" + "code=" + code + ", name=" + name + ", price=" + price + ", image=" + image + ", sortText=" + sortText + ", longText=" + longText + ", show=" + show + '}';
    }

   
}
