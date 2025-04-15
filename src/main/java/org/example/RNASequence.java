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
    // amino acids and its keys are from website:
    // https://openstax.org/books/biology/pages/15-1-the-genetic-code
    // todo: write more amino acids
    private Map<String, Character> getCodonTable() {
        HashMap<String, Character> tab = new HashMap<>();

        // start codon
        // m as short from met
        tab.put("AUG", 'M');

        // phenylalanine (phe)
        tab.put("UUU", 'F');
        tab.put("UUC", 'F');

        // leucine (leu)
        tab.put("UUA", 'L');
        tab.put("UUG", 'L');
        tab.put("CUU", 'L');
        tab.put("CUC", 'L');
        tab.put("CUA", 'L');
        tab.put("CUG", 'L');

        // histidine (his)
        tab.put("CAU", 'H');
        tab.put("CAC", 'H');

        // theronine (thr)
        tab.put("ACU", 'T');
        tab.put("ACC", 'T');
        tab.put("ACA", 'T');
        tab.put("ACG", 'T');

        // isoleucine (ile)
        tab.put("AUU", 'I');
        tab.put("AUC", 'I');
        tab.put("AUA", 'I');

        // stop codons
        tab.put("UAA", '*');
        tab.put("UAG", '*');
        tab.put("UGA", '*');

        return tab;
    }

    @Override
    protected Set<Character> getValidCharacters() {
        return VALID_CHARS;
    }
}

