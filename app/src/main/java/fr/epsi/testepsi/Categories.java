package fr.epsi.testepsi;

import org.json.JSONObject;

public class Categories {
    private String category_id;
    private String title;
    private String products_url;

    public Categories(JSONObject o){
        category_id = o.optString("category_id","");
        title = o.optString("title","");
        products_url = o.optString("products_url","");
    }


    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String id) {
        this.category_id = id;
    }

    public String getTitle() {
        return title;
    }


    public String getProducts_url() {
        return products_url;
    }

    public void setProducts_url(String url) {
        this.products_url = url;
    }
}
