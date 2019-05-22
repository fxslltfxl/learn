package interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Genericity<T extends Object> {


    T[] ts;
    List<T> list;

    public void add() {
        // 下界通配符 可以接受所有子类或者本身
        List<? super Sup> list = new ArrayList<>();
        list.add(new Sub());
        list.add(new Sup());
        //get 得到的 只能为Object
        Object object = list.get(0);



        // 上界通配符 只能接受null
        List<? extends Sup> list1 = new ArrayList<>();
//        list.add(new Sub()); error
//        list.add(new Sup()); error
        list1.add(null);

        //get 得到的为Sup 子类  可以用Sup 接受
        Sup sup1 = list1.get(0);
    }

    public static void main(String[] args) {

        Collection collection = new ArrayList<String>();
        if (collection instanceof Collection<?>){}
    }
}
