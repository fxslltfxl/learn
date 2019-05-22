package bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

public class One {

    @Expose
    private String name;
    @Expose()
    @Since(5)
    private int age;
    @Expose
    private transient String nul;
    @Expose
    @Until(5)
    private String xww;

    public One() {
    }

    public One(String name) {
        this.name = name;
    }

    public One(String name, int age, String nul, String xww) {
        this.name = name;
        this.age = age;
        this.nul = nul;
        this.xww = xww;
    }


    public static One getInstance() {
        return new One();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNul() {
        return nul;
    }

    public void setNul(String nul) {
        this.nul = nul;
    }

    public String getXww() {
        return xww;
    }

    public void setXww(String xww) {
        this.xww = xww;
    }
}
