package lt.vu.psk1.alternatives;

import javax.enterprise.context.Dependent;

import lombok.NoArgsConstructor;

@Dependent
@NoArgsConstructor
public class BookMessage implements Message {

    @Override
    public String WriteMessage() {
        return "Book created";
    }
}
