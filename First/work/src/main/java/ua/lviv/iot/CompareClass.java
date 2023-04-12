package ua.lviv.iot;

import java.util.Comparator;

public class CompareClass implements Comparator<AbstractTransport> {
    @Override
    public int compare(AbstractTransport o1, AbstractTransport o2) {
        if (o1 instanceof Bus && !(o2 instanceof Bus)) return -1;
        else if (o1 instanceof TrolleyBus && !(o2 instanceof Bus) && !(o2 instanceof TrolleyBus)) return -1;
        else if (o1 instanceof Car && !(o2 instanceof Bus) && !(o2 instanceof TrolleyBus) && !(o2 instanceof Car)) return -1;
        else return 0;
    }
}
