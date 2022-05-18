package lt.vu.psk1.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorImpl implements AuthorDecorator {
    @Inject
    @Delegate
    @Any
    AuthorDecorator authorDecorator;

    public String authorDecorator(String message){
        return authorDecorator.authorDecorator("a message passed to DecoratorImpl: '" + message + "'");
    }
}
