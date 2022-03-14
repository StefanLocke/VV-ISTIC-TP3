package fr.istic.vv;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;

class BinaryHeap<T,NotSuchElementException extends Throwable> {

    T value;
    BinaryHeap<T,NotSuchElementException> leftChild;
    BinaryHeap<T,NotSuchElementException> rightChild;

    Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T pop() {
        // TODO
        return value;
    }

    public T peek() {
        // TODO
        return value;
    }


    public void push(T element)  {
        if (value==null) this.value = element;
        switch (comparator.compare(value,element)){
            case 0 : this.value = element; break;
            case -1:
                if (this.leftChild==null) this.leftChild = new BinaryHeap<T,NotSuchElementException>(comparator);
                this.leftChild.push(element);
                break;
            case 1 :
                if (this.rightChild==null) this.rightChild = new BinaryHeap<T,NotSuchElementException>(comparator);
                this.rightChild.push(element);
                break;
        }
    }

    public int count(){
        // TODO
        return 0;
    }

}