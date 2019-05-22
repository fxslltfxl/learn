package interview;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class PhantomReferenceTest {
    private static boolean isRun = true;

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        String abc = new String("abc");

        Object a = "abc";
        System.out.println(a==abc);
        abc.intern();
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        new Thread(() -> {
            while (isRun) {
                Object obj = referenceQueue.poll();
                if (obj != null) {
                    try {
                        Field referent = Reference.class.getDeclaredField("referent");
                        referent.setAccessible(true);
                        Object result = referent.get(obj);
                        System.out.printf("gc will collect：%s@%d\t%s%n", result.getClass(), result.hashCode(), result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,
//                referenceQueue);
//        abc = null;
//        Thread.currentThread().sleep(3000);
//        System.gc();
//        Thread.currentThread().sleep(3000);
//        isRun = false;


        System.out.println(abc=="abc");
    }





}
