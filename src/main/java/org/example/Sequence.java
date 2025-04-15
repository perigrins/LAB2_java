package org.example;

// abstract classes created with usage of official tutorial:
// https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

public abstract class Sequence {
    // identifier and data are present in all classes
    protected String identifier;
    protected StringBuilder data;

    // constructor
    public Sequence(String identifier, String data) {
        this.identifier = identifier;
        // usage of .toUpperCase() gotten from website https://www.w3schools.com/java/ref_string_touppercase.asp
        // and used accordingly later
        this.data = new StringBuilder(data.toUpperCase());
        // validation
        // each class has its own valid characters
        // dna - a, c, t, g
        // rna - a, u, c, g
        // proteins - all letters except a few (b, j, o, z)
        if (!validate()) {
            throw new IllegalArgumentException("invalid characters in sequence");
        }
    }

    // repetitive methods:
    // 1. toString() - returns data in FASTA type
    // 2. mutate(pos, val) - changes location of a given character
    // 3. findMotif() - returns location of a certain motif
    // 4. getLength() - return length of an object
    // 5. getData(), getIdentifier()

    public String getIdentifier() {
        return identifier;
    }

    public String getData() {
        return data.toString();
    }

    public int getLength() {
        return data.length();
    }

    public void mutate(int position, char val) {
        if (position < 0 || position >= data.length()) {
            throw new IndexOutOfBoundsException("invalid position");
        }
        // checking if the character is valid
        // using toUpperCase() because of a valid chars saving format
        if (!getValidCharacters().contains(Character.toUpperCase(val))) {
            throw new IllegalArgumentException("invalid character for mutation");
        }
        data.setCharAt(position, Character.toUpperCase(val));
    }

    public int findMotif(String motif) {
        // getting position of a motif using indexOf() method
        // based on website: https://www.w3schools.com/java/ref_string_indexof.asp
        return data.indexOf(motif.toUpperCase());
    }

    // changing into FASTA format
    public String toString() {
        return ">" + identifier + "\n" + data.toString();
    }

    protected boolean validate() {
        for (char c : data.toString().toCharArray()) {
            // is the given character is not on specific VALID_CHARS return 0
            if (!getValidCharacters().contains(c)) {
                return false;
            }
        }
        return true;
    }

    // abstract set of valid characters, returrns a set of characters
    // specific for every class
    protected abstract java.util.Set<Character> getValidCharacters();
}

