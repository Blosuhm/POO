package aula06;

import java.util.Arrays;

public class Set {

    private int[] setArray = null;

    public Set() {
        setArray = new int[0];
    }

    public Set(Set other) {
        setArray = Arrays.copyOf(other.getArray(), other.getArray().length);
    }

    public Set insert(int value) {
        if (setArray.length == 0) {
            setArray = new int[1];
            setArray[0] = value;
            return this;
        }
        if (contains(value)) {
            return this;
        }
        int[] newArray = Arrays.copyOf(setArray, setArray.length + 1);
        newArray[setArray.length] = value;
        Arrays.sort(newArray);
        setArray = newArray;
        return this;
    }

    public boolean contains(int value) {
        for (int num : setArray) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public Set remove(int value) {
        if (setArray.length == 0) {
            return this;
        }
        if (!contains(value)) {
            return this;
        }
        int[] newArray = new int[setArray.length - 1];
        int i = 0;
        for (int num : setArray) {
            if (num == value) {
                continue;
            }
            newArray[i++] = num;
        }
        setArray = newArray;
        return this;
    }

    public int size() {
        return setArray.length;
    }

    public Set empty() {
        setArray = new int[0];
        return this;
    }

    public Set combine(Set other) {
        Set newSet = new Set();
        for (int num : other.getArray()) {
            newSet.insert(num);
        }
        return newSet;
    }

    public int[] getArray() {
        return this.setArray;
    }

    public Set subtract(Set other) {
        Set newArray = new Set();
        for (int num : setArray) {
            if (other.contains(num)) {
                continue;
            }
            newArray.insert(num);
        }
        return newArray;
    }

    public Set intersect(Set other) {
        Set newArray = new Set();
        for (int num : other.getArray()) {
            if (!contains(num)) {
                continue;
            }
            newArray.insert(num);
        }
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int num : setArray) {
            sb.append(num);
            if (i++ != setArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
