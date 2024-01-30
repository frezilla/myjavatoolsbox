package eu.frezilla.tools.compression.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * Un objet {@code Analyzer} analyse et retourne le nombre d'occurrences des 
 * motifs présents dans un tableau.
 * 
 * @param <T> Type de motifs à analyser
 */
final class Analyzer<T extends Analyzable> {

    /**
     * Analyse et retourne le nombre d'occurrences pour chacun des 
     * motifs présents dans un tableau. Si le tableau n'est pas valide, une
     * exception {@code IllegalArgumentException} est soulevée.
     * 
     * @param values tableau de motifs
     * @return {@code Map<T, Long>} qui présente le nombre d'occurrences des 
     * motifs
     */
    public Map<T, Long> analyze(T[] values) {
        validateArray(values);
        Map<T, Long> map = new HashMap<>();
        for (T val : values) {
            map.computeIfPresent(val, (k, counter) -> (long) (counter + 1));
            map.computeIfAbsent(val, k -> (long) 1);
        }
        return map;
    }

    /**
     * Valide qu'un tableau de motifs est valide.
     * Un tableau est valide si le tableau est défini et ne contient aucun 
     * élément null. Si le tableau n'est pas valide, une exception 
     * {@code IllegalArgumentException} est soulevée.
     * 
     * @param values tableau des motifs
     */
    private void validateArray(T[] values) {
        if (values == null) throw new IllegalArgumentException("Le tableau des motifs est null");
        for(int i = 0; i < values.length; i++) {
            if (values[i] == null) throw new IllegalArgumentException("Le motif #" + i + " est null");
        }
    }

}
