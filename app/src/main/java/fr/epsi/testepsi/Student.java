package fr.epsi.testepsi;

import org.json.JSONObject;

public class Student {

    private String name;
    private String email;
    private String url;

    public Student(JSONObject o){
        name = o.optString("name","");
        email = o.optString("email","");
        url = o.optString("picture_url","");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
