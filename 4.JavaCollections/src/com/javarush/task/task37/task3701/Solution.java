package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator {
        Iterator<T> iterator = Solution.super.iterator();
        int lastRet = 0;

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;

            if (lastRet >= size()) {
                iterator = Solution.super.iterator();
                lastRet = 0;
            }

            return true;
//            return Solution.this.size() > 0;
        }

        @Override
        public Object next() {
//            int size = Solution.this.size();
//            if (size <= lastRet)
//                lastRet = 0;
            lastRet++;
            return iterator.next();
        }

        @Override
        public void remove() {
            if (Solution.this.size() == 0)
                throw new ConcurrentModificationException();
            try {
                iterator.remove();
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }
}
