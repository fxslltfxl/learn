package bean;

public class Father {

    String name;

    public Father(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    protected void eat() {
        System.out.println("Father");
    }

    protected Object testLSP(Number number) {
        return number.toString();
    }

}
