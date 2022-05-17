package lt.vu.psk1.alternatives;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

import lombok.NoArgsConstructor;

@Dependent
@Alternative
@NoArgsConstructor
public class EditedBookMessage implements Message {
    @Override
    public String WriteMessage() {
        return "Book edited";
    }
}
