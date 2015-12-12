package com.github.vlsidlyarevich.client;

import com.github.vlsidlyarevich.FileReader;
import com.github.vlsidlyarevich.SequenceSearcher;
import com.github.vlsidlyarevich.XmlReader;

import java.io.IOException;
import java.util.HashSet;


public class PatentParser {


    public static void main(String[] args) throws IOException {

        XmlReader fileReader = new XmlReader("new.xml");

        String patent;

        FileReader reader = new FileReader("List of Words.txt");
        HashSet<String> words = reader.getWordsSet();
        SequenceSearcher sequenceSearcher = new SequenceSearcher(words);

        while ((patent = fileReader.getPatent())!= null) {

        System.out.println(sequenceSearcher.searchSeq(patent));
        }
    }

}
