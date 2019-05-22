package interview;

public class Sup implements Cloneable{
    @Override
    protected Sup clone(){
        try {
            return (Sup)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int i;
    public static String name ="fxs";

    public String normalName;

    public Sup() {

    }

    public Sup(String normalName) {
        this.normalName = normalName;
    }

    public String getNormalName() {
        return normalName;
    }

    public void setNormalName(String normalName) {
        this.normalName = normalName;
    }

    public static void method() {
        System.out.println("sup static method");
    }

    public void normalMethod() {
        System.out.println("sup method");
    }
}
