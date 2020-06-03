package com.cc.study.concurrent.thread.executor;

import java.util.concurrent.*;

/**
 * @Date: 2020/06/03 10:51
 */
public class ExecutorsTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new SumTask());
        Thread.sleep(3000);
        boolean done = future.isDone();
        if(!done){
            boolean cancel = future.cancel(false);
            System.out.println("cancel="+cancel);
        }else {
            System.out.println("done="+future.get());
        }
        executorService.shutdown();
    }

    static class SumTask implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int result = 0;
            for(int i=1;i<=10;i++){
                Thread.sleep(1000);
                result+=i;
                System.out.println("result="+result);
            }
            return result;
        }
    }

}
