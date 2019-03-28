package uk.ac.ucl.bag;

//import hashmap library
import java.util.Iterator;
import java.util.HashMap;

// this class implements bags using a hashmap as the internal data structure
public class MapBag<T extends Comparable> extends AbstractBag<T> {

    private int maxSize;
    private HashMap<T, Integer> contents;

    //constructor1
    public MapBag() throws BagException{
        this(MAX_SIZE);
    }

    //constructor2 -- check the size within bound and error handling
    public MapBag(int maxSize) throws BagException{
        if (maxSize > MAX_SIZE){
            throw new BagException("Attempting to create a bag with size greater than maximum");
        }
        if (maxSize < 1){
            throw new BagException("Attempting to create a bag with size less than 1");
        }
        this.maxSize = maxSize;
        this.contents = new HashMap<>();
    }


    /* implementing the Bad Interface */
    public void add(T value) throws BagException{
        // add duplicated items
        if (contents.containsKey(value)){
            contents.put(value, contents.get(value) + 1);
            return;
        }
        // add non-exist items
        if (contents.size() < MAX_SIZE){
            contents.put(value, 1);
            //System.out.println("new element added");
        }
        else{
            throw new BagException("Bag is Full!");
        }
    }

    public void addWithOccurrences(T value, int occurrences) throws BagException{
        for (int i = 0; i < occurrences ; i++){
            add(value);
        }
    }

    public boolean contains(T value){
        return contents.containsKey(value);
    }

    public int countOf(T value){
        return contents.get(value);
    }

    public void remove(T value){
        if (contents.get(value) > 1) {
            contents.put(value, contents.get(value) - 1);
        }
        else{
            contents.remove(value);
        }
    }

    public boolean isEmpty(){
        return contents.isEmpty();
    }

    public int size(){
        return contents.size();
    }

    /* Implement Iterator interface */
    // methods
    public Iterator<T> iterator(){
        return new MapBagUniqueIterator();
    }

    public Iterator<T> allOccurrencesIterator(){
        return new MapBagIterator();
    }

    //classes
    private class MapBagUniqueIterator implements Iterator<T>{
        // iterator dealing with unique items
        private Iterator <T> contentsIt = contents.keySet().iterator();

        public boolean hasNext(){
           return contentsIt.hasNext();
        }

        public T next(){
            return contentsIt.next();
        }
    }

    private class MapBagIterator implements Iterator<T>{
        // iterator dealing with all items
        private Iterator<HashMap.Entry<T,Integer>> entryIterator = contents.entrySet().iterator();
        private HashMap.Entry<T, Integer> current = null;
        private int itemCount;

        public boolean hasNext(){
            return itemCount > 0 || entryIterator.hasNext();
        }
        // if the occurrence of the element is larger than 0 OR has next element

        public T next(){
           if  (itemCount == 0){   // if the occurrence is zero
               current = entryIterator.next(); // go to the next element
               itemCount = current.getValue(); // get the next occurrence of the next element
           }
           itemCount--;
           return current.getKey();
        }
    }

}
