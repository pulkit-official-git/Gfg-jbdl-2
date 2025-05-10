package mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    List<Integer> arrToSort;
    ExecutorService ex;
    public MergeSort(List<Integer> arrToSort, ExecutorService ex) {
        this.arrToSort = arrToSort;
        this.ex = ex;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(arrToSort.size()<=1){
            return arrToSort;
        }
        int mid = arrToSort.size()/2;
        List<Integer>leftArr = new ArrayList<>();
        List<Integer>rightArr = new ArrayList<>();
        for(int i=0;i<mid;i++){
            leftArr.add(arrToSort.get(i));
        }
        for(int i=mid;i<arrToSort.size();i++){
            rightArr.add(arrToSort.get(i));
        }
        MergeSort left = new MergeSort(leftArr,ex);
        MergeSort right = new MergeSort(rightArr,ex);
        Future<List<Integer> > l1=ex.submit(left);
        Future<List<Integer>> r1=ex.submit(right);
        leftArr=l1.get();
        rightArr=r1.get();
        int i=0,j=0;
        List<Integer>sortedArray=new ArrayList<>();
        while(i < leftArr.size() && j < rightArr.size()){
            if(leftArr.get(i)<rightArr.get(j)){
                sortedArray.add(leftArr.get(i));
                i++;
            }
            else {
                sortedArray.add(rightArr.get(j));
                j++;
            }
        }
        while(i < leftArr.size()){
            sortedArray.add(leftArr.get(i));
            i++;
        }
        while(j < rightArr.size()){
            sortedArray.add(rightArr.get(j));
            j++;
        }

        return sortedArray;
    }
}
