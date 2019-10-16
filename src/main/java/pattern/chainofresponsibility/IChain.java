package pattern.chainofresponsibility;

public interface IChain {
    Product proceed(String productName);
}
