package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class DigitStack implements Serializable, Comparable<DigitStack>, Iterable<Character> {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Deque<Character> stack;

    public DigitStack() {
        this.stack = new ArrayDeque<>();
    }

    public void pushDigit(char digit) {
        stack.push(digit);
    }

    public char popDigit() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public Collection<Character> getStackCopy() {
        return Collections.unmodifiableCollection(new ArrayDeque<>(stack));
    }

    @Override
    public Iterator<Character> iterator() {
        return stack.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DigitStack that)) return false;
        return new ArrayList<>(this.stack).equals(new ArrayList<>(that.stack));
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }

    @Override
    public String toString() {
        return "DigitStack{" + "stack=" + stack + '}';
    }

    @Override
    public int compareTo(DigitStack other) {
        return Integer.compare(this.size(), other.size());
    }
}
