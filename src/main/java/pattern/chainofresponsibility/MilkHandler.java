package pattern.chainofresponsibility;

public class MilkHandler extends Handler {


    @Override
    Product handle(IChain chain) {

        Product product = new Product();
        ProductRealChain productRealChain = (ProductRealChain) chain;

        product.name = "Milk";

        productRealChain.setIndex(productRealChain.getIndex() + 1);
        productRealChain.proceed(product.name);
        return product;
    }
}
