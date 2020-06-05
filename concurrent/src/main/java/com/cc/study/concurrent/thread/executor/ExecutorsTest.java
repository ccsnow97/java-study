package com.cc.study.concurrent.thread.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2020/06/03 10:51
 */
public class ExecutorsTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new MyThreadFactory(),
                new MyRejectedExecutionHandler());
        executorService.allowCoreThreadTimeOut(true);
        Future<?> future = executorService.submit(new MyTask("a"));
        Thread.sleep(1000);
        printExecutorInfo(executorService);
        executorService.submit(new MyTask("b"));
        executorService.submit(new MyTask("c"));
        executorService.submit(new MyTask("d"));
        executorService.submit(new MyTask("e"));
        executorService.submit(new MyTask("e"));
        executorService.submit(new MyTask("e"));
        executorService.submit(new MyTask("e"));
        executorService.submit(new MyTask("e"));
        Thread.sleep(1000);
        printExecutorInfo(executorService);
        Thread.sleep(20000);
        printExecutorInfo(executorService);
        executorService.submit(new MyTask("f"));
        printExecutorInfo(executorService);

    }

    static void printExecutorInfo(ThreadPoolExecutor executorService){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("线程池数量："+executorService.getPoolSize());
        BlockingQueue<Runnable> queue = executorService.getQueue();
        stringBuilder.append(" ;队列任务："+queue.size());
        System.out.println(stringBuilder.toString());
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            Class<? extends Runnable> rClass = r.getClass();
            System.out.println("拒绝任务");
        }
    }

    /*
     * 需要10s
     */
    static class MyTask implements Runnable{
        String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=1;i<5;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+":"+name+" "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadFactory implements ThreadFactory{
        static AtomicInteger counter = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"thread-"+counter.getAndIncrement());
        }
    }



}
