package com.app.db.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="learnhub")
public class Course {
	
	@Id
    @Column(name="pnum")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
	@Column(name="title")
    private String title;
    
	@Column(name="image")
    private String image;
 
	@Column(name="url")
    private String url;
 
	@Column(name="price")
    private String price;
 
	@Column(name="type")
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="category")
    private String category;
 
	@Column(name="rating")
    private String rating;
 
	@Column(name="description")
    private String description;
 
	
	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*@Override
    public String toString(){
        return "id="+id+", title="+title+", price="+price;
    }*/
	
}
