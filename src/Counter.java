import java.util.Arrays;

public class Counter {
    int t;

    public Counter(int t) {
        this.t=t;
    }

    public void begin() throws InterruptedException {
        MyCode code = new MyCode(t);

        Thread[] threads = new Thread[4];
        for (int i=0; i<threads.length; i++){
            threads[i] = new Thread(code);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public class MyCode implements Runnable{
        int t;

        public MyCode(int t){
            this.t = t;
        }

        public void run() {
            for (int i=1;i<=10000;i++) {
//               int h=getFree();
                synchronized (this) {
                    System.out.println(getFree());
                }
            }
        }

        public int getFree(){
//            for (int i=0 ;i <=1000; i++) {
//                double[] s = {1.2412, 24.214124, 24.214125, 26.436436, 1.2412, 24.214124, 24.214125, 26.436436, 1.2412, 24.214124, 24.214125, 26.436436};
//                Arrays.sort(s);
//            }
            return t++;
        }
    }
}