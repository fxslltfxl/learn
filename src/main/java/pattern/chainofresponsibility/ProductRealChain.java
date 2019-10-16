package pattern.chainofresponsibility;


import java.util.ArrayList;
import java.util.List;

public class ProductRealChain implements IChain {

    List<Handler> handlers = new ArrayList<>();

    int index = 0;

    public ProductRealChain(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public Product proceed(String productName) {
        if (handlers == null || handlers.size() < 1) {
            throw new RuntimeException("handlerList is empty");
        }
        System.out.println("product name is :" + productName);

        if (index >= handlers.size()) {
            System.out.println("product finished");
            return null;
        }

        handlers.get(index).handle(this);
        return null;
    }
}
