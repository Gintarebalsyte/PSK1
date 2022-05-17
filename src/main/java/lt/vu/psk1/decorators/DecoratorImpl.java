package lt.vu.psk1.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorImpl implements BookDecorator {
    @Inject
    @Delegate
    @Any
    BookDecorator bookDecorator;

    public Integer decoratedInt(Integer integer){
        System.out.println("Decorator is used");
        return bookDecorator.decoratedInt(integer) * 10;
    }
}
