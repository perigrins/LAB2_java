package org.example;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSequenceTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Getting protein data and length")
    void testValidProtein() {
        ProteinSequence protein = new ProteinSequence("test1", "MFT*");
        assertEquals("MFT*", protein.getData());
        assertEquals(4, protein.getLength());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Getting protein from RNA")
    void testProteinData() {
        RNASequence rna = new RNASequence("test2", "AUGCUUUAA");
        ProteinSequence protein = rna.transcribe();
        assertEquals("ML*", protein.getData());
        assertEquals(3, protein.getLength());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Invalid sequence - protein")
    void testInvalidProtein() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProteinSequence("bad", "MXZT");
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Mutating proteins")
    void testMutation() {
        ProteinSequence protein = new ProteinSequence("test3", "MFT");
        protein.mutate(1, 'L');
        assertEquals("MLT", protein.getData());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Finding motifs - proteins")
    void testFindMotif() {
        ProteinSequence protein = new ProteinSequence("test4", "MFTKM");
        assertEquals(0, protein.findMotif("MF"));
        assertEquals(3, protein.findMotif("KM"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Getting FASTA output - protein")
    void testToStringFASTA() {
        ProteinSequence protein = new ProteinSequence("test5", "MFTK");
        String expected = ">test5\nMFTK";
        assertEquals(expected, protein.toString());
    }
}