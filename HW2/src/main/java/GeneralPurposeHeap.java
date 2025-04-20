import java.util.Arrays;
import java.util.NoSuchElementException;
public class GeneralPurposeHeap <T extends Comparable <T>> {
    private T[] HeapData;
    private int size;
    private int DefaultCapacity;

    public GeneralPurposeHeap() //default constructor
    {
        this.DefaultCapacity = 100;
        this.size = 0;
        this.HeapData = (T[]) new Comparable[DefaultCapacity];
    }

    public GeneralPurposeHeap(int initialCapacity) //defining the initial capacity
    {
        this.DefaultCapacity = initialCapacity;
        this.size = 0;
        this.HeapData = (T[]) new Comparable[DefaultCapacity];
    }

    public GeneralPurposeHeap(T[] initialData) {
        this.size = initialData.length;
        this.HeapData = (T[]) new Comparable[size + 1]; // Adjust size to include 0 index
        System.arraycopy(initialData, 0, HeapData, 1, size); // Copy elements starting from index 1
        EfficientBuilder();
    }

    public void resize() //for overflow need
    {
        T[] newHeapArray = Arrays.copyOf(HeapData, HeapData.length * 2);
        HeapData = newHeapArray;
    }

    public void PercUp(int index, T element, T[] Heap) {
        if (index == 1 || Heap[index / 2].compareTo(element) <= 0) {
            // Base case: index is 1 or element is greater than its parent
            Heap[index] = element;
        } else {
            // Swap with parent
            Heap[index] = Heap[index / 2];
            PercUp(index / 2, element, Heap); // Recursively call PercUp on the parent index
        }
    }

    public void insert(T element) {
        if (this.size == HeapData.length - 1) {
            resize();
        }
        if (element == null)
        {
            throw new IllegalArgumentException("Element cannot be null");
        }
        HeapData[size + 1] = element;
        this.size++;
        PercUp(this.size, element, HeapData);
    }

    public T findMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return this.HeapData[1];
    }

    public int getSize() //gets back the size
    {
        return this.size;

    }

    public T deleteMin() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        T temp = this.HeapData[1];
        PercDown(1, HeapData[size]);
        this.size--;
        return temp;
    }
    private void EfficientBuilder() {
        //  sort from the last non-leaf node
        for (int i = size / 2; i > 0; i--) {
            PercDown(i, HeapData[i]);
        }
    }

    public void mergeHeap(GeneralPurposeHeap<T> otherHeap) {
        int newSize = this.size + otherHeap.size;
        if (newSize >= HeapData.length) {
            T[] newArr = (T[]) new Comparable[2 * newSize];
            System.arraycopy(HeapData, 1, newArr, 1, size);
            HeapData = newArr;
        }
        System.arraycopy(otherHeap.HeapData, 1, HeapData, size + 1, otherHeap.size);
        // Update the size of the merged heap
        size = newSize;
        EfficientBuilder();
        }

    @Override
    public String toString() {
        return "GeneralPurposeHeap{" +
                "HeapData=" + Arrays.toString(HeapData) +
                '}';
    }

    public void PercDown(int i, T x) {
        int n = this.size;
        int j;
        if (2 * i > n)//if its a leaf
        {
            HeapData[i] = x;
        }
        if (2 * i == n) {
            if (HeapData[2 * i].compareTo(x) < 0) {
                HeapData[i] = HeapData[2 * i];
                HeapData[2 * i] = x;
            } else {
                HeapData[i] = x;
            }
        }
        if (2 * i < n) {
            if (HeapData[2 * i].compareTo(HeapData[2 * i + 1]) < 0) {
                j = 2 * i;
            } else {
                j = 2 * i + 1;
            }
            if (HeapData[j].compareTo(x) < 0) {
                HeapData[i] = HeapData[j];
                PercDown(j, x);
            } else {
                HeapData[i] = x;
            }
        }
    }
}



















