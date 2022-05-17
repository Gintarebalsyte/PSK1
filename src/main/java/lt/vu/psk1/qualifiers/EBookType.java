package lt.vu.psk1.qualifiers;

import javax.enterprise.context.Dependent;

@EBook
@Dependent
public class EBookType implements BookTypeProcessor {
    @Override
    public String bookType() {
        return "This is E-Book";
    }
}
