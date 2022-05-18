package lt.vu.psk1.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements AuthorDecorator {
    @Override
    public String authorDecorator(String message){
        return "Decorator message:" + message;
    }
}
