package cn.zxc.demo01Sort;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
