package pattern.chainofresponsibility;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new MilkHandler());
        handlers.add(new BreadHHandler());
        IChain productRealChain = new ProductRealChain(handlers);
        productRealChain.proceed("");
    }
}
