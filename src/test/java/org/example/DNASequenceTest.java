package org.example;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class DNASequenceTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Getting data and identifier - DNA")
    void testConstructorAndValidation() {
        DNASequence dna = new DNASequence("test1", "ATGC");
        assertEquals("ATGC", dna.getData());
        assertEquals("test1", dna.getIdentifier());
        assertEquals(4, dna.getLength());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Invalid sequence - DNA")
    void testInvalidDNASequence() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DNASequence("bad", "ATXZ");
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Mutating DNA sequence")
    void testMutation() {
        DNASequence dna = new DNASequence("test2", "ATGC");
        dna.mutate(1, 'A');
        assertEquals("AAGC", dna.getData());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("DNA - complement")
    void testComplement() {
        DNASequence dna = new DNASequence("test4", "ATGC");
        assertEquals("TACG", dna.complement());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Finding motifs - DNA")
    void testFindMotif() {
        DNASequence dna = new DNASequence("test3", "ATGCGATG");
        assertEquals(0, dna.findMotif("ATG"));
        assertEquals(1, dna.findMotif("TG"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("DNA transcribing -> getting RNA identifier and RNA data")
    void testTranscription() {
        DNASequence dna = new DNASequence("test5", "ATGC");
        RNASequence rna = dna.transcribe();
        assertEquals("AUGC", rna.getData());
        assertEquals("test5", rna.getIdentifier());
    }
}