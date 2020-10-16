package com.cc.study.concurrent.thread.demo.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ReturnTrueDemo {

    /**
     * 所有子任务都为true，最终结果为true
     * 若其中一个为false，则最终结果为false，并立即中断其他任务
     *
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long threshold = 1000000L;
        FutureTask<Boolean> futureTask1 = new FutureTask<>(new MyCallable(300000L, threshold));
        FutureTask<Boolean> futureTask2 = new FutureTask<>(new MyCallable(5200000L, threshold));
        FutureTask<Boolean> futureTask3 = new FutureTask<>(new MyCallable(120000000L, threshold));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<FutureTask<Boolean>> futureTaskList = new ArrayList<>(Arrays.asList(futureTask1, futureTask2, futureTask3));
        futureTaskList.forEach(executorService::submit);

        boolean flag = true;
//        while(futureTaskList.stream().anyMatch(e->!e.isDone())){
//            boolean anyMatch = futureTaskList.stream().filter(FutureTask::isDone).anyMatch(e -> {
//                try {
//                    return Objects.equals(e.get(), false);
//                } catch (InterruptedException | ExecutionException ex) {
//                    ex.printStackTrace();
//                }
//                return true;
//            });
//            if(anyMatch){
//                flag =false;
//                System.out.println("开始取消任务");
//                futureTaskList.forEach(e->e.cancel(false));
//                System.out.println("结束取消任务");
//            }
//        }
        if (flag) {
            System.out.println("任务成功1！！！！！！！！！！！！");
            executorService.shutdown();
        } else {
            System.out.println("任务失败!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

    }


    static class MyCallable implements Callable<Boolean> {

        private long max;
        private long threshold;

        public MyCallable(long max, long threshold) {
            this.max = max;
            this.threshold = threshold;
        }

        @Override
        public Boolean call() throws Exception {
            int i = 0;
            while (i < max) {
                i++;
                if (i % 100000 == 0)
                    System.out.println(Thread.currentThread().getName() + ": " + i);
//                Thread.sleep(1000);
            }
            return i > threshold;
        }
    }

}
