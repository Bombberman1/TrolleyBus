package ua.lviv.iot;

import java.util.Comparator;

public class CompareClass2 implements Comparator<AbstractTransport> {
    @Override
    public int compare(AbstractTransport o1, AbstractTransport o2) {
        return o1.getClass().getName().compareTo(o2.getClass().getName());
    }
}