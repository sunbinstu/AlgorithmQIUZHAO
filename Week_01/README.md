



# week1学习总结

​        学习了超哥的刷题方法后，学习效率有所上升。但是之前没做过这样的训练，第一周有些不适应，刷题效率不太高，在今后的学习中根据超哥的五毒神掌给自己做了一个学习计划，并且每天晚上都会对之前刷过较难的题目做一个复习。希望自己坚持下来，养成这样的习惯，打下好的编程基础。

## 源码分析

### ArrayDeque(1.8)

ArrayDeque底层使用的数组，但是想要头部插入数据需要函数System.arrayCopy，所以ArrayDeque使用的是循环数组，不需要移动数据，可以正常向头或尾添加数据。

> 属性

```
//ArrayDeque的数据存储，默认初始化16
transient Object[] elements;
//头指针
transient int head;
//尾指针
transient int tail;
```

> 方法

头部添加

```
public void addFirst(E e) {
   //位运算提高效率。当第一次插入数据head=-1,那么计算11111111&00001111，结果是00001111，也就是物理尾    //部的15，假如head=3是，计算00000011&00001111，结果00000011，还是3     
   elements[head = (head - 1) & (elements.length - 1)] = e;
   //如果数组满了，arrayDeque进行扩容
   if (head == tail)
      doubleCapacity();
 }
```

扩容

```
 private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p; // number of elements to the right of p
        //二倍扩容
        int newCapacity = n << 1;
        Object[] a = new Object[newCapacity];
        //copy数组，并且新生成的数组head=0
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }
```

删除数据，头尾移除很简单。中间某个数据：由于是循环数组面临三个问题，一是需要在左侧或右侧删除，二是需要挪动头或尾，三是优化需要，尽量少得移动数组元素。

ArrayDeque是先判断中间元素里head近还是离tail近，然后移动较近的那一端。但较近的一端只是逻辑上较近，物理数组上，可能被分成了两截，这就需要做两次数组元素的批量移动。

```
 if (front < back) {
 if (h <= i) {
      System.arraycopy(elements, h, elements, h + 1, front);
  } else { // Wrap around
      System.arraycopy(elements, 0, elements, 1, i);
      elements[0] = elements[mask];
      System.arraycopy(elements, h, elements, h + 1, mask - h);
  }
  } 
```

计算长度，物理不连续

```kotlin
(tail - head) & (elements.length - 1);
```

### PriorityQueue(1.8)

优先队列中，数据按照某个字段有序排列，插入新数据时，会自动插入到合适的位置。

Java中的优先队列是一个堆

堆：是一个完全二叉树；根节点大于左右子节点(大顶堆)，或小于左右子节点(小顶堆)

堆在插入数据时会满足二叉树特点，依次插入，不满足堆特点，不断调整交换

> 属性

```
//默认初始化11
private static final int DEFAULT_INITIAL_CAPACITY = 11;
//维护一个队列:基于二叉树实现的优先队列，节点关系是queue[i]的子节点queue[2*i+1]
transient Object[] queue;
//优先队列内元素个数
private int size = 0;
//排序：用于升序或降序作比较自定义对象
private final Comparator<? super E> comparator;
```

插入数据

```
public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        //如果数组满了需要扣容
        if (i >= queue.length)
            grow(i + 1);    
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```

真正插入逻辑

```
private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            //找到父节点，p[(k-1)/2]
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            //作比较，插入合适的位置
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
```

删除元素

```
private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
        //删除操作主要是两部分，if里面判断删除的是否是最后一个，否则的话就是用siftDown方法进行“向下           //沉”删除。不成功那就使用“向上浮”。
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }

```

```
//删除操作还是需要进行比较
private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
```

### HashMap(1.8)

hashmap底层是哈希表，由数组组成，在哈希表中进行添加，删除，查找等操作，性能十分之高，仅需一次定位即可完成，时间复杂度为O(1)。哈希表中的数据是无序的，通过hash算法得到一个唯一的二进制值，在进行其他运算得到数组下标。如果发生index冲突，1.8版本先生成链表，在链表大于8，数据大于64时会变成红黑树。使用红黑树是因为链表数据太长时效率低。

```
//hahsmap中维护了一个Node节点
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
}        
```

> 属性

```
//默认初始化大小
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//扩容银子 size>0.75*16时发生扩容
//负载因子越大越容易发生hash冲突
static final float DEFAULT_LOAD_FACTOR = 0.75f;
//数组内多少元素
transient int size;
```

> 方法

添加数据

```
 final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //如果第一次插入数据，初始化
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
         //计算index,index位置为空，直接插入   
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            //如果key存在，直接覆盖value
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
             //判断链表是否转成红黑树   
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //链表尾部插入新数据
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

扩容

HashMap扩容后为原来的2倍，所以经过计算后元素的位置要么在原位置，要么是在原位置在移动index*2；比1.7的扩容中做了优化，不需要重新计算hash值

```
final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
        //超过最大值不会进行扩容
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //扩容为原先的2倍
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                //  oldThr*2   
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
        //// 把每个旧的bucket都移动到新的buckets中
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // 链表优化，重新hash
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            //原索引
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            //原索引+oldCapacity
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        //原索引重新放到bucket中
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //原索引+oldCapacity放到bucket中
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```

