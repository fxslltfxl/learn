package interview.concurrent;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -4496709314450641382L;

    private int money;
    private String name;

    public User(int money, String name) {
        this.money = money;
        this.name = name;
    }


    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
