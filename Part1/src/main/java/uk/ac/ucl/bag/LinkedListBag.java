package uk.ac.ucl.bag;

import java.util.Iterator;
import java.util.LinkedList;

// this class implements bags using a linked list as the internal data structure
public class LinkedListBag<T extends Comparable> extends AbstractBag<T> {

    private int maxSize;  // the max size defined by the user
    private LinkedList<Element<T>> contents;
    // special for LinkedListBag
    private int currentSize; // current number of elements in bag
    private Element<T> first; // beginning of bag

    // constructor1
    public LinkedListBag() throws BagException{
        this(MAX_SIZE);
        // initialize an empty bag
        first = null;
        currentSize = 0;
    }
    // constructor2
    public LinkedListBag(int maxSize) throws BagException{
        if (maxSize > MAX_SIZE){
            throw new BagException("Attempting to create a bag with size greater than maximum");
        }
        if (maxSize < 1){
            throw new BagException("Attempting to create a bag with size less than 1");
        }
        this.maxSize = maxSize;
        this.contents = new LinkedList<>();
    }

    /* build an element class store a value, occurrences and the next element */
    private static class Element<E extends Comparable> {
        public E value;
        public int occurrences;
        public Element<E> next;

        public Element(E value, int occurrences, Element<E> next) {
            this.value = value;
            this.occurrences = occurrences;  // the occurrences in the bag
            this.next = next;
        }
    }

    /* help method: findValue */
    public Element<T> findValue(T value){
        Element<T> element = first;
        if (first == null) { // empty linked list
            return null;
        }
        while (value != element.value && element.next != null){ // while have the next different element
            element = element.next;
        }
        return null; // if the element value is not exist;
    }

    /* implement the Bag Interface */
    public void add(T value) throws BagException{
        for (Element element : contents) {
            if (element.value.compareTo(value) == 0) {
                element.occurrences++;
                return;
                //System.out.println("occurrences added");
            }
        }
        if(currentSize < maxSize){
            if(currentSize == 0){  // if the bag is empty
                first = new Element<>(value, 1, null);
            }
            /* add new item --- contents.add(new Element(value, 1, oldFirst)*/
            Element<T> oldFirst = first;  //store this element
            first = new Element<T>(value, 1, oldFirst); // the new element will be the first
            currentSize++; // increment the current size
            //System.out.println("new element added");
            //System.out.println(currentSize);
            //System.out.println(first.value); // --- indicates add function works fine
        }
        else{
            throw new BagException("Bag is Full!");
        }
    }

    public void addWithOccurrences(T value, int occurrences) throws BagException{
        for (int i = 0; i < occurrences; i++){
            add(value);
        }
        //System.out.println("function used");
        //System.out.println(occurrences);  --- indicates occurrences works fine
    }

    public boolean contains(T value){
        /*
        for(Element element : contents){
            if (element.value.compareTo(value) == 0){
                return true;
            }
        }
        //System.out.println("function used");
        return false;
        */
        return contents.contains(value);
    }

    public int countOf(T value){
        for (Element element : contents){
            if (element.value.compareTo(value) == 0){
                return element.occurrences;
            }
        }
        return 0;
    }

    public void remove(T value){
        for (Element element : contents){
            if(element.value.compareTo(value) == 0){
                element.occurrences--; // if occurance > 0 --- remove one occurrence
                if(element.occurrences == 0){
                    /* remove the whole element  --- content.remove(element) */
                    linkedListDelete(value);
                }
            }
        }
        // System.out.println("function used");
    }
    private void linkedListDelete(T value){
        Element<T> currentElement = first;
        Element<T> prevElement = null;
        //System.out.println("Function used");
        /* the help method of remove*/
        // Case 1: Head node itself hold the value to be deleted
        if (currentElement != null && currentElement.value == value){
            first = currentElement.next; // next element be the first
        }

        // Case 2: If the value is somewhere else
        while (currentElement != null && currentElement.value != value){
            // if current element do not have the key --- go to the next
            prevElement = currentElement;
            currentElement = currentElement.next;
        }
        // if the value is present
        if (currentElement != null){
            prevElement.next = currentElement.next; // link the previous element to the next
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return currentSize;
    }

    /* Implement Iterator interface */
    // methods
    public Iterator<T> iterator(){
        return new LinkedListUniqueIterator();
    }

    public Iterator<T> allOccurrencesIterator(){
        return new LinkedListIterator();
    }

    // classes
    private class LinkedListUniqueIterator implements Iterator<T>{
        private Element<T> current;
        public LinkedListUniqueIterator(){
            current = new Element<T>(null, 0, first);
        }

        public boolean hasNext(){
            return current.next != null;
        }

        public T next(){
            current = current.next;
            T value = current.value;
            return value;
        }
    }

    private class LinkedListIterator implements Iterator<T>{ // remember to modify it back
        private Element<T> current;
        private int itemCount;
        public LinkedListIterator(){
            current = new Element<T>(null, 1, first);
        }

        public boolean hasNext(){
            return itemCount > 0 || current.next != null;
        }

        public T next(){
            if(itemCount == 0){
                current = current.next;
                itemCount = current.occurrences;
            }
            itemCount--;
            // System.out.println("function used");
            return current.value;
        }

    }

}
