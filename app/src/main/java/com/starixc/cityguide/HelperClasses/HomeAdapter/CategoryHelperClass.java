package com.starixc.cityguide.HelperClasses.HomeAdapter;

public class CategoryHelperClass {
    int image;
    String cat_title;

    public CategoryHelperClass(int image, String cat_title) {
        this.image = image;
        this.cat_title = cat_title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }
}
