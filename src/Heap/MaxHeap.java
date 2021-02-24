package Heap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //将i索引的数据上浮到正确位置
    private void siftUp(int i) {
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
            //交换两个
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    //找出堆中最大元素
    public E getMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E max = getMax();
        //将最后一个元素换到开头来
        data.swap(0, data.getSize() - 1);
        //删除最有一个元素
        data.removeLast();

        //
        siftDown(0);
        return max;
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (rightChild(i) < data.getSize() &&
                    data.get(leftChild(i)).compareTo(data.get(rightChild(i))) < 0) {
                j = rightChild(i);
            }
            //如果比两个孩子中的最大的一个还要大 那么就不用交换 退出循环
            if (data.get(i).compareTo(data.get(j)) > 0) {
                break;
            } else {
                //交换 下沉
                data.swap(i, j);
                i = j;
            }
        }
    }

}
