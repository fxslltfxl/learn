package pattern.chainofresponsibility;

public abstract class Handler {

    abstract Product handle(IChain chain);
}
