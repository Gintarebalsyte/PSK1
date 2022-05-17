package lt.vu.psk1.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements BookDecorator {
    @Override
    public Integer decoratedInt(Integer integer) {
        return integer;
    }
}
