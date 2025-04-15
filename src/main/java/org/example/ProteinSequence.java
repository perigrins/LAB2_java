package org.example;

import java.util.*;

public class ProteinSequence extends Sequence {
    // set of valid characters
    // VALID_CHARS is non-modifiable
    private static final Set<Character> VALID_CHARS = Set.of(
            'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'U', 'W', 'Y', '*', 'X'
    );

    // constructor
    public ProteinSequence(String identifier, String data) {
        super(identifier, data);
    }

    @Override
    protected Set<Character> getValidCharacters() {
        return VALID_CHARS;
    }
}

