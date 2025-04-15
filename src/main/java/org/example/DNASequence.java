package org.example;

import java.util.*;

public class DNASequence extends Sequence {
    // VALID_CHARS is non-modifiable
    private static final Set<Character> VALID_CHARS = Set.of('A', 'T', 'C', 'G');

    public DNASequence(String identifier, String data) {
        super(identifier, data);
    }

    public String complement() {
        // todo: change string to string builder?
        //StringBuilder comp = new StringBuilder();
        String comp = "";
        for (char base : data.toString().toCharArray()) {
            switch (base) {
                case 'A': comp += 'T'; break;
                case 'T': comp += 'A'; break;
                case 'C': comp += 'G'; break;
                case 'G': comp += 'C'; break;
            }
        }
        return comp;
        // in staingbuilder case: return comp.toString();
    }

    public RNASequence transcribe() {
        // string .replace() method used from: https://www.w3schools.com/java/ref_string_replace.asp
        // 1st variable ist old char and 2nd variable is new char
        String rnaData = data.toString().replace('T', 'U');
        return new RNASequence(identifier, rnaData);
    }

    @Override
    protected Set<Character> getValidCharacters() {
        return VALID_CHARS;
    }
}

