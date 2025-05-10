package mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        List<Integer> arrToSort = List.of(8,3,2,9,1,4,5,3,7);
        MergeSort task = new MergeSort(arrToSort,ex);
        Future<List<Integer>> result=ex.submit(task);
        List<Integer> ans = result.get();
        System.out.println(ans);

    }
}
