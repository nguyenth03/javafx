/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author 84563
 */
public class Bookdb {
    private String id,name ,image,co_year,price,quantity,description,categoryId,authorId,publishId;


    public Bookdb(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public Bookdb(String id, String name, String image, String co_year, String price, String quantity, String description, String categoryId, String authorId, String publishId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.co_year = co_year;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.publishId = publishId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCo_year() {
        return co_year;
    }

    public void setCo_year(String co_year) {
        this.co_year = co_year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    
    
    @Override
    public String toString() {
        return  name ;
    }
}
