/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index any occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    //recursive version: calls helper function
    public int indexOf( Integer findMe) {
        return indexOfInSlice(findMe, 0, size() - 1);
    }

    // public int indexOf(Integer findMe) {
    //     int start = 0;
    //     int end = size() - 1;
    //     while (!(end - start < 1))  {
    //         int middle = (start + end) / 2;
    //         if (list_iAS.get(middle) == findMe) {
    //             return middle;
    //         }
    //         else if (findMe.compareTo(list_iAS.get(middle)) < 0) {
    //             end = middle - 1;
    //         }
    //         else start = middle + 1;
    //     }
    //     //"base case": loop is exited only if whole list has no member of value findMe
    //     return -1;
    // }

    private int indexOfInSlice(Integer findMe, int start, int end) {
        int middle = (start + end) / 2;
        if (list_iAS.get(middle) == findMe) {
            return middle;
        }
        else if (end - start < 1) {
            return -1;
        }
        else if (findMe.compareTo(list_iAS.get(middle)) < 0) {
            return indexOfInSlice(findMe, start, middle - 1);
        }
        else return indexOfInSlice(findMe, middle + 1, end);
    }
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
