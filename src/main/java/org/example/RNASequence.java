package org.example;

import java.util.*;

public class RNASequence extends Sequence {
    // VALID_CHARS is non-modifiable
    private static final Set<Character> VALID_CHARS = Set.of('A', 'U', 'C', 'G');

    public RNASequence(String identifier, String data) {
        super(identifier, data);
    }

    public String complement() {
        // todo: change string to string builder?
        //StringBuilder comp = new StringBuilder();
        String comp = "";
        for (char base : data.toString().toCharArray()) {
            switch (base) {
                case 'A': comp += 'U'; break;
                case 'U': comp += 'A'; break;
                case 'C': comp += 'G'; break;
                case 'G': comp += 'C'; break;
            }
        }
        return comp;
    }

    // returns ProteinSequence object
    public ProteinSequence transcribe() {
        StringBuilder protein = new StringBuilder();
        Map<String, Character> codonTable = getCodonTable();
        for (int i = 0; i <= data.length() - 3; i += 3) {
            // string .substring() method used from website
            // https://www.w3schools.com/jsref/jsref_substring.asp
            String codon = data.substring(i, i + 3);
            // X for not found codons
            protein.append(codonTable.getOrDefault(codon, 'X'));
        }
        return new ProteinSequence(identifier, protein.toString());
    }

    // hash map: a pair of key + value
    // where key = rna codon and value = amino acid
    // todo: write more amino acids
    private Map<String, Character> getCodonTable() {
        Map<String, Character> table = new HashMap<>();

        // start codon
        table.put("AUG", 'M');

        // phenylalanine
        table.put("UUU", 'F');

        // leucine
        table.put("UUA", 'L'); table.put("UUG", 'L');
        table.put("CUU", 'L'); table.put("CUC", 'L');
        table.put("CUA", 'L'); table.put("CUG", 'L');

        // hiatidiner
        table.put("CAU", 'H'); table.put("CAC", 'H');

        // theronine
        table.put("ACU", 'T'); table.put("ACC", 'T');
        table.put("ACA", 'T'); table.put("ACG", 'T');


        // isoleucine
        table.put("AUU", 'I'); table.put("AUC", 'I'); table.put("AUA", 'I');

        // stop codons
        table.put("UAA", '*');
        table.put("UAG", '*');
        table.put("UGA", '*');

        return table;
    }

    @Override
    protected Set<Character> getValidCharacters() {
        return VALID_CHARS;
    }
}

