package krunal.com.example.acer.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by acer on 15-02-2018.
 */

public class Heros {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("realname")
    @Expose
    private String realname;

    public Heros(String name, String realname) {
        this.name = name;
        this.realname = realname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }


}
