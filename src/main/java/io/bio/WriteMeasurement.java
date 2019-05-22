package io.bio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteMeasurement {
    static SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
   static  SimpleDateFormat ts = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws IOException {
//        try (FileOutputStream fos = new FileOutputStream
// ("C:\\Users\\47633\\Downloads\\localproject\\learn\\src\\main" +
//                "\\java\\io\\write", true);
//            ) {
//            Writer writer = new FileWriter("C:\\Users\\47633\\Downloads\\localproject\\learn\\src\\main\\java\\io" +
//                    "\\write", true);
//            for (int i = 0; i < 100; i++) {
//                int finalI = i;
//                new Thread(() -> {
//                    try {
//                        writer.write("Thread No is " + finalI + "\n" +
//                                "writer write" + finalI + "\n" +
//                                "context:append" + finalI + "\n\n");
//                        writer.flush();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                System.out.println(s.format(new Date()));
            }).start();
        }

    }
}
