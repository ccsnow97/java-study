package com.cc.study.concurrent.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程计算求和
 *
 * @Date: 2020/06/04 09:57
 */
public class MultiThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int LENGTH = 1000;
        int THREADNUM = 4;
        int PERNum=250;
        Integer[] array=new Integer[LENGTH];
        for(int i=1;i<=LENGTH;i++){
            array[i-1]=i;
        }

        long start = System.currentTimeMillis();
        int result =0;
        List<FutureTask<Integer>> futureTaskList = new ArrayList<>();
        for(int i=0;i<THREADNUM;i++){
            FutureTask<Integer> futureTask = new FutureTask<>(new SumTask(array, i * PERNum, (i + 1) * PERNum));
            futureTaskList.add(futureTask);
            new Thread(futureTask).start();
        }
        Optional<Integer> reduce = futureTaskList.stream().map(e -> {
            try {
                return e.get();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
            return 0;
        }).reduce((a, b) -> a + b);
        if(reduce.isPresent()){
            System.out.println(reduce.get());
        }
        System.out.println("总耗时："+(System.currentTimeMillis()-start)/1000.0);
    }

    static class SumTask implements Callable<Integer> {

        private Integer[] array;
        private int start;
        private int end;

        public SumTask(Integer[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            if(!checkRange()){
                return 0;
            }
            int result = 0;
            for(int i=start;i<end;i++){
                result+=array[i];
                Thread.sleep(10);
            }
            return result;
        }

        private boolean checkRange() {
            return array != null && start < end && start >= 0 && end <= array.length;
        }
    }

}
