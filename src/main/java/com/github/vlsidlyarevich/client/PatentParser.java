package com.github.vlsidlyarevich.client;

import com.github.vlsidlyarevich.fileUtils.FileReader;
import com.github.vlsidlyarevich.core.SequenceSearcher;
import com.github.vlsidlyarevich.fileUtils.WriterToFile;
import com.github.vlsidlyarevich.fileUtils.XmlReader;

import java.io.IOException;
import java.util.HashSet;


public class PatentParser {


    public static void main(String[] args) throws IOException {

        XmlReader fileReader = new XmlReader(args[0]);

        String patent;

        FileReader reader = new FileReader(args[1]);
        HashSet<String> words = reader.getWordsSet();
        FileReader smallWordsReader = new FileReader(args[2]);
        HashSet<String> smallWordsSet = smallWordsReader.getWordsSet();

        SequenceSearcher sequenceSearcher = new SequenceSearcher(words,smallWordsSet);
        WriterToFile writer = new WriterToFile(args[3]);

        while ((patent = fileReader.getPatent()) != null) {
            String temp = sequenceSearcher.searchSeq(patent);
            if (temp != null) {
                writer.writeToFile(temp);
            }
        }
        writer.closeWriter();

    }

}
