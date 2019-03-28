package uk.ac.ucl.bag;

import javax.swing.*;
import java.util.Iterator;

/**
 * Example code illustrating the use of Bag objects.
 */
public class Main
{
  private BagFactory<String> factory = BagFactory.getInstance();

  public void print(Bag<String> bag)
  {
    boolean first = true;
    System.out.print("{");
    for (String value : bag)
    {
      if (!first) { System.out.print(" , "); }
      first = false;
      System.out.print(value);
    }
    System.out.println("}");
  }

  public void printAll(Bag<String> bag)
  {
    boolean first = true;
    System.out.print("{");
    Iterator<String> allIterator = bag.allOccurrencesIterator();
    while (allIterator.hasNext())
    {
      if (!first) { System.out.print(" , "); }
      first = false;
      System.out.print(allIterator.next());
    }
    System.out.println("}");
  }

  public void go()
  {
    factory.setBagClass("MapBag");

    try
    {
      Bag<String> bag1;
      Bag<String> bag2;
      Bag<String> bag3;

      bag1 = factory.getBag();
      bag1.add("abc");
      bag1.add("def");
      bag1.add("hij");
      System.out.print("bag1 all unique:             ");
      print(bag1);
      System.out.print("bag1 all:                    ");
      printAll(bag1);
      //System.out.println(bag1.contains("def"));

      bag2 = factory.getBag();
      bag2.add("def");
      bag2.add("def");
      bag2.add("def");
      bag2.add("klm");
      System.out.print("bag2 all unique:             ");
      print(bag2);
      System.out.print("bag2 all:                    ");
      printAll(bag2);
      //System.out.println(bag2.countOf("def"));

      bag3 = factory.getBag();
      bag3.addWithOccurrences("xyz", 5);
      bag3.add("opq");
      bag3.addWithOccurrences("123", 3);
      System.out.print("bag3 all unique:             ");
      print(bag3);
      System.out.print("bag3 all:                    ");
      printAll(bag3);
      //System.out.println(bag3.size());


      System.out.print("createMergedAllOccurrences:  ");
      Bag<String> bag4 = bag1.createMergedAllOccurrences(bag3);
      printAll(bag4);

      System.out.print("createMergedAllUnique:       ");
      Bag<String> bag5 = bag1.createMergedAllUnique(bag3);
      print(bag5);

      /* Question 3 Test */
      System.out.println();
      System.out.println("********Test Q3*********");
      System.out.println(bag1.toString());
      System.out.println(bag3.toString());

      /* Question 4 Test */
      System.out.println();
      System.out.println("********Test Q4*********");
      bag3.removeAllCopies();
      printAll(bag3);

      /* Question 5 Test */
      System.out.println();
      System.out.println("********Test Q5*********");
      Bag<String> bag6 = factory.getBag();
      Bag<String> bag7 = factory.getBag();

      bag6.addWithOccurrences("abc",4);
      bag6.addWithOccurrences("def", 4);
      bag6.addWithOccurrences("hij", 5);

      bag7.addWithOccurrences("abc", 2);
      bag7.addWithOccurrences("def", 6);
      bag7.addWithOccurrences("klm", 2);
      printAll(bag6.subtract(bag7));

    }
    catch (BagException e)
    {
      System.out.println("====> Bag Exception thrown...");
    }
  }

  public static void main(String[] args)
  {
    new Main().go();
  }
}