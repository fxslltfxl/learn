package adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class AdapterTest {


    public static void main(String[] args) {
        Vector vector = new Vector();
        for (Enumeration enumeration = vector.elements(); enumeration.hasMoreElements(); ) {

        }

        for (Iterator iterator = vector.iterator(); iterator.hasNext();){

        }

    }
}
