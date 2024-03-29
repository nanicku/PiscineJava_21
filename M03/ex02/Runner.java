package ex02;

public class Runner implements Runnable {
    private int index;
    private int count;
    private int sumOneThread;

    public Runner(int index, int count) {
        this.index = index;
        this.count = count;
    }

    @Override
    public void run() {
        sumOneThread = Program_02.countSumInInterval(index, count);
        Program_02.countSumByThreads(sumOneThread);

        String info = Thread.currentThread().getName() +
                ": from " + index +
                " to " + (index + count - 1) +
                " sum is " + sumOneThread;
        System.out.println(info);
    }
}