package interview;

import io.nio.basicChannel;

import java.util.ArrayList;
import java.util.Collections;

public class List {
    public static void main(String[] args){
        java.util.List<Sup> objects = Collections.synchronizedList(new ArrayList<>());

        objects.add(new Sup("fxs"));
        objects.add(new Sup("fxs1"));
        objects.add(new Sup("fxs2"));
        objects.add(new Sup("fxs3"));


        Sup sup = objects.get(0);
        sup.setNormalName("xww");
        Sup a=sup.clone();


        System.out.println(objects.get(0).getNormalName());
        new basicChannel();
    }
}
