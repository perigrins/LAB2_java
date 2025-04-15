package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // dna
        String dnaData = "ATGCGTACCTAA";
        String dnaData2 = "ATGCGTA";
        String dnaData3 = "ATGGATACCTAA";
        String dnaData4 = "TACGTATGGATT";
        System.out.println("dna sequence ----------\n");
        DNASequence dna = new DNASequence("test1", dnaData);
        System.out.println(dna);         // already in FASTA format
        dna.mutate(6, 'C');
        System.out.println("\nafter mutation: \n" + dna);
        System.out.println("\nmotif 'CGT' found at position: " + dna.findMotif("CGT"));
        System.out.println("complementary strand: " + dna.complement());

        // rna
        System.out.println("\nrna sequence ----------");
        RNASequence rna = dna.transcribe();
        System.out.println("\ntranscribed RNA: \n" + rna);
        rna.mutate(4, 'A');
        System.out.println("\nafter RNA mutation: \n" + rna);
        System.out.println("\nmotif 'CCU' found at position: " + rna.findMotif("CCU"));
        System.out.println("complementary RNA strand: " + rna.complement());

        // protein
        System.out.println("\nprotein sequence ----------");
        ProteinSequence protein = rna.transcribe();
        System.out.println("\ntranslated protein: \n" + protein);
        protein.mutate(2, 'H');
        System.out.println("\nafter protein mutation: \n" + protein);
        System.out.println("\nmotif 'HH' found at position: " + protein.findMotif("HH"));
        System.out.println("motif 'MH' found at position: " + protein.findMotif("MH"));
    }
}