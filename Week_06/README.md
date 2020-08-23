# 学习总结(week06)

## 冒泡排序

```
public void bubbleSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    for (int i = 0; i < len; i++) {
        // 提前退出冒泡循环的标志位, false 表示没有数组交换
        boolean flag = false;
        for (int j = 0; j < len - 1; j++) {
            // 大了做交换
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = true;
            }
        }
        // 这一趟比较下来，没有数据交换，就退出
        if(!flag) break;
    }
}
```

## 选择排序

```
public void selectionSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    for (int i = 0; i < len - 1; i++) {
        int minIndex = i;
        // 找出待排序区间中最小的元素
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

插入排序额

```
public void insertionSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    int temp;
    // 挑选一个元素，插入到已排序区间
    for (int i = 1; i < len; i++) {
        temp = arr[i];
        int j = i - 1;
        // 寻找插入位置
        while (j >= 0 && temp < arr[j]) {
            arr[j + 1] = arr[j--];
        }
        arr[j + 1] = temp;
    }
}
```

## 希尔排序

```
public void shellSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    int temp;
    for (int step = len / 2; step >= 1; step /= 2) { 
        for (int i = step; i < len; i++) {
            temp = arr[i];
            int j = i - step;
            // 查找插入位置
            while (j >= 0 && arr[j] > temp) {
                arr[j + step] = arr[j];
                j -= step;
            }
            arr[j + step] = temp;
        }
    }
}
```

## 归并排序

```
public void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
}

private void mergeSort(int[] arr, int left, int right) {
    if (right <= left) return;
    int mid = left + ( right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}
private void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
        temp[k++] = arr[i++];
    }
    while (j <= right) {
        temp[k++] = arr[j++];
    }
    System.arraycopy(temp, 0, arr, left, temp.length);
}
```

## 快速排序

```
public void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}

private void quickSort(int[] arr, int start, int end) {
    if (end <= start) return;
    int pivot = partition(arr, start, end);
    quickSort(arr, start, pivot - 1);
    quickSort(arr, pivot + 1, end);
}
private int partition(int[] arr, int start, int end) {
    int pivot = end;
    int i = start;
    for (int j = start; j < end; j++) {
        if (arr[j] < arr[pivot]) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[pivot];
    arr[pivot] = arr[i];
    arr[i] = temp;
    return i;
}
```

## 堆排序

```
public class HeapSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 1、建堆
        buildHeap(arr);
        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }

}
```

