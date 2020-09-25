package bridge_method;

class TestImpl implements TestInter<String> {

    public TestImpl() {
        Object object = getName(null);
    }

    @Override
    public String getName(String name) {
        return null;
    }
}