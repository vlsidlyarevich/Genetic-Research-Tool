package com.github.vlsidlyarevich.client;

import com.github.vlsidlyarevich.fileUtils.FileReader;
import com.github.vlsidlyarevich.core.SequenceSearcher;
import com.github.vlsidlyarevich.fileUtils.WriterToFile;
import com.github.vlsidlyarevich.fileUtils.XmlReader;

import java.io.IOException;
import java.util.HashSet;


public class PatentParser {


    public static void main(String[] args) throws IOException {

        XmlReader fileReader = new XmlReader("new.xml");

        String patent;

        FileReader reader = new FileReader("List of Words.txt");
        HashSet<String> words = reader.getWordsSet();
        SequenceSearcher sequenceSearcher = new SequenceSearcher(words);
        WriterToFile writer = new WriterToFile("Output.txt");

        while ((patent = fileReader.getPatent()) != null) {
            String temp = sequenceSearcher.searchSeq(patent);
            if (temp != null) {
                writer.writeToFile(temp);
            }
        }
        writer.closeWriter();

    }

}
