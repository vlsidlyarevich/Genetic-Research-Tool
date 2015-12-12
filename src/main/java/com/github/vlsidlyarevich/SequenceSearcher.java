package com.github.vlsidlyarevich;

import com.github.vlsidlyarevich.utils.Patterns;
import com.github.vlsidlyarevich.utils.Utils;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceSearcher {

    private HashSet<String> words;
    private Pattern wordPattern;
    private Pattern seqPatternWithoutSEQID;
    private Pattern seqPatternWithSEQID;

    public SequenceSearcher(HashSet<String> words) {
        this.words = words;
        wordPattern = Pattern.compile(Patterns.WORD_PATTERN);
        seqPatternWithoutSEQID = Pattern.compile(Patterns.SEQ_PATTERN_WITHOUT_ID);
        seqPatternWithSEQID = Pattern.compile(Patterns.SEQ_PATTERN_WITH_ID);
    }

    public String searchSeq(String patent) {

        StringBuilder result = new StringBuilder();
        String word = "";
        int position = 0;
        int curSeqNumber = 0;
        int seqNumber = 0;

        Matcher wordMatcher = wordPattern.matcher(patent);

        while (wordMatcher.find(position)) {
            word = wordMatcher.group();

            Matcher seqMatcher = seqPatternWithoutSEQID.matcher(word);
            Matcher seqMatcherWithSEQID = seqPatternWithSEQID.matcher(word);

            if (!this.words.contains(word.toLowerCase()) && seqMatcher.matches()) {
                result.append("Sequence " + ++curSeqNumber + "\n");
                result.append(wordMatcher.group() + "\n");
                seqNumber++;
            } else if (!this.words.contains(word.toLowerCase()) && seqMatcherWithSEQID.matches()) {
                result.append("Sequence " + Utils.getSeqID(word) + "\n");
                result.append(wordMatcher.group() + "\n");
                seqNumber++;
            }
            position = wordMatcher.end();
        }

        if (!result.toString().equals("")) {
            result.insert(0, "Patent No:" + Utils.getPatentID(patent) + "\n" + "Sequences founded:" + seqNumber + "\n");
        }

        return result.toString();
    }


    @Override
    public String toString() {
        return "SequenceSearcher{" +
                "words=" + words +
                '}';
    }
}
