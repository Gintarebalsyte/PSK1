package lt.vu.psk1.qualifiers;

import javax.enterprise.context.Dependent;

@Audio
@Dependent
public class AudioBookType implements BookTypeProcessor {
    @Override
    public String bookType() {
        return "This is Audio book";
    }
}
