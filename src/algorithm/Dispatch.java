package algorithm;

import java.util.Arrays;
import java.util.List;

public class Dispatch {

    interface Service{
        void run();
    }

    static class MyService1 implements Service{
        @Override
        public void run() {
            System.out.println("run1");
        }
    }

    static class MyService2 implements Service{
        @Override
        public void run() {
            System.out.println("run2");
        }
    }

    public static void main(String[] args) {

        List<Service> svcs = Arrays.asList(new MyService1(), new MyService2());
        svcs.get(0).run();
        svcs.get(1).run();

        /**
         *         30: invokeinterface #21,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
         *         35: checkcast     #7                  // class algorithm/Dispatch$Service
         *         38: invokeinterface #27,  1           // InterfaceMethod algorithm/Dispatch$Service.run:()V
         *         43: aload_1
         *         44: iconst_1
         *         45: invokeinterface #21,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
         *         50: checkcast     #7                  // class algorithm/Dispatch$Service
         *         53: invokeinterface #27,  1           // InterfaceMethod algorithm/Dispatch$Service.run:()V
         */
        MyService2 svc2 = new MyService2();
        svc2.run();

        /**
         *         30: invokeinterface #21,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
         *         35: checkcast     #7                  // class algorithm/Dispatch$Service
         *         38: invokeinterface #27,  1           // InterfaceMethod algorithm/Dispatch$Service.run:()V
         *         43: aload_1
         *         44: iconst_1
         *         45: invokeinterface #21,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
         *         50: checkcast     #7                  // class algorithm/Dispatch$Service
         *         53: invokeinterface #27,  1           // InterfaceMethod algorithm/Dispatch$Service.run:()V
         *         58: new           #12                 // class algorithm/Dispatch$MyService2
         *         61: dup
         *         62: invokespecial #14                 // Method algorithm/Dispatch$MyService2."<init>":()V
         *         65: astore_2
         *         66: aload_2
         *         67: invokevirtual #30                 // Method algorithm/Dispatch$MyService2.run:()V
         */

    }
}
