package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<String>("head");
    //    static int countElements = 0;
    final Queue<Entry<String>> queue = new LinkedList<>();

    {
        queue.add(root);
    }

    public CustomTree() {
//        root=new Entry<String>("head");
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> newElement = new Entry<>(elementName);
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (true) {
            Entry<String> currentRoot = queue.remove();
            // если находим локальный "корень" у которого нет 1 или 2=х "детей", то записываем
            if (currentRoot.isAvailableToAddChildren()) {
                elementAdd(currentRoot, newElement);
                break;
            } // если дети есть, то ставим их в очередь
            else {
                if (currentRoot.leftChild != null)
                    queue.add(currentRoot.leftChild);
                if (currentRoot.rightChild != null)
                    queue.add(currentRoot.rightChild);
            }
        }
        return true;
//        Entry<String> newElem = new Entry<>(elementName);
//
//        if (root.availableToAddLeftChildren) {
//            root.leftChild = new Entry<>(String.valueOf(elementName));
//            ++countElements;
//            root.leftChild.parent = root;
//            return true;
//        }
//        if (root.availableToAddRightChildren) {
//            root.rightChild = new Entry<>(String.valueOf(elementName));
//            ++countElements;
//            root.rightChild.parent = root;
//            return true;
//        }
//        return false;

    }

    //проверяет наличие детей и запихивает туда, где их нет
    public void elementAdd(Entry<String> currentRoot, Entry<String> currentElement) {
        if (currentRoot.availableToAddLeftChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.leftChild = currentElement;
        } else if (currentRoot.availableToAddRightChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.rightChild = currentElement;
        }
        currentRoot.checkChildren();
    }

    public String getParent(String s) {
        Entry<String> findElement = findElement(root, s);
        if (findElement != null)
            return findElement.parent.elementName;
        else return null;
    }

    public Entry<String> findElement(Entry<String> root, String findElement) {
        Entry<String> elementOut = null;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.elementName.equals(findElement)) {
                elementOut = currentElement;
                break;
            } else {
                if (currentElement.leftChild != null)
                    queue.add(currentElement.leftChild);
                if (currentElement.rightChild != null)
                    queue.add(currentElement.rightChild);
            }
        }
        return elementOut;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int size = 1;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        // пробегаемся по элементам
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
                size++;
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
                size++;
            }
        }
        return size == 0 ? size : size - 1;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        String s = (String) o;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                if (currentElement.leftChild.elementName.equals(s)) {
                    currentElement.leftChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.leftChild);
                }
            }
            if (currentElement.rightChild != null) {
                if (currentElement.rightChild.elementName.equals(s)) {
                    currentElement.rightChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.rightChild);
                }
            }
        }
        return false;
//        String removeElementStr = (String) o;
//        Entry<String> rootElement;
//        Queue<Entry<String>> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            rootElement = queue.poll();
//            if (rootElement.elementName.equals(removeElementStr)) {
//                rootElement.rightChild = null;
//                rootElement.leftChild = null;
//            } else {
//                if (rootElement.leftChild != null)
//                    queue.add(rootElement.leftChild);
//                if (rootElement.rightChild != null)
//                    queue.add(rootElement.rightChild);
//            }
/*
Удаление элемента похоже на добавление, надо проверять потомков у текущего элемента из очереди и обнулять потомска с искомым именем
*/
//        }
//        return false;
//        String removeElementStr = (String) o;
//        //ищем нужный элемент в графе и если он не null, удаляем
//        Entry<String> removeElement = findElement(root, removeElementStr);
//        if (removeElement != null) {
//            if (removeElement.parent.leftChild != null && removeElement.parent.leftChild.elementName.equals(removeElement.elementName))
//                removeElement.parent.leftChild = null;
//            else removeElement.parent.rightChild = null;
//            removeElement.parent = null;
//        }
//        return true;

    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
