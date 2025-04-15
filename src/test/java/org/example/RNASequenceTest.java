package org.example;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class RNASequenceTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Getting data and identifier - RNA")
    void testConstructorAndValidation() {
        RNASequence rna = new RNASequence("test1", "AUGC");
        assertEquals("AUGC", rna.getData());
        assertEquals("test1", rna.getIdentifier());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Invalid sequence - RNA")
    void testInvalidRNASequence() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RNASequence("bad", "ATGC");
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Mutating RNA sequence")
    void testMutation() {
        RNASequence rna = new RNASequence("test2", "AUGC");
        rna.mutate(0, 'U');
        assertEquals("UUGC", rna.getData());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("RNA - complement")
    void testComplement() {
        RNASequence rna = new RNASequence("test3", "AUGC");
        assertEquals("UACG", rna.complement());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Finding motifs - RNA")
    void testFindMotif() {
        RNASequence rna = new RNASequence("test4", "AUGGGA");
        assertEquals(3, rna.findMotif("GGA"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("RNA translating -> getting protein data")
    void testTranslationToProtein() {
        RNASequence rna = new RNASequence("test5", "AUGCUUUAA");
        ProteinSequence protein = rna.transcribe();
        assertEquals("ML*", protein.getData());
    }
}