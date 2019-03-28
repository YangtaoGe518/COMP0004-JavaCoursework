package uk.ac.ucl.bag;

/**
 * This class implements methods common to all concrete bag implementations
 * but does not represent a complete bag implementation.<br />
 *
 * New bag objects are created using a BagFactory, which can be configured in the application
 * setup to select which bag implementation is to be used.
 */
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBag<T extends Comparable> implements Bag<T>
{
  public Bag<T> createMergedAllOccurrences(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      result.addWithOccurrences(value, this.countOf(value));
    }
    for (T value : b)
    {
      result.addWithOccurrences(value, b.countOf(value));
    }
    return result;
  }

  public Bag<T> createMergedAllUnique(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      if (!result.contains(value)) result.add(value);
    }
    for (T value : b)
    {
      if (!result.contains(value)) result.add(value);
    }
    return result;
  }

  @Override
  public String toString(){
    Iterator<T> bagIterator = iterator();
    StringBuilder output = new StringBuilder();

    if(size() == 0){  // if it is an empty bag
      return "[]";
    }

    output.append('[');  // start of output
    while (bagIterator.hasNext()){ // if it is not empty
      T current = bagIterator.next();
      int occurrences = countOf(current);

      output.append(current);
      output.append(':');
      output.append(occurrences);

      if(bagIterator.hasNext()){ // if there is a next element to add
        output.append(',');
        output.append(' ');
      }
    }
    output.append(']'); // end of output
    return output.toString();
  }

  public void removeAllCopies() {
      Iterator<T> bagUniqueIt = allOccurrencesIterator();

      if(size() == 0){
        return;
      }

      while (bagUniqueIt.hasNext()) {
        T current = bagUniqueIt.next();
        int occurrences = countOf(current);

        if (occurrences > 1) {
          remove(current);
        }
      }
  }

  public Bag<T> subtract(Bag<T> bag) throws BagException{
    Bag<T> result = BagFactory.getInstance().getBag();
    Iterator<T> bagIt = iterator();

    if(size() == 0){  // if bag is empty
      return null;
    }
    while (bagIt.hasNext()){  // iterate through the whole bag
       T current = bagIt.next();
       int occurrences = countOf(current);

       if(bag.contains(current)){  // if there exist the value we are looking for
         int newOccurrences = occurrences - bag.countOf(current);
         if (newOccurrences > 0){
            result.addWithOccurrences(current,newOccurrences);
         }
       }
       else{ // if such value is not in the bag
         result.addWithOccurrences(current, occurrences);
       }
    }

    return result;
  }

}
