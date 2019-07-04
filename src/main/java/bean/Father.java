package bean;

public abstract class Father {
    public Father() {
        test();
    }

    protected abstract void test();
    protected void eat(){
        System.out.println("Father");
    }




}
