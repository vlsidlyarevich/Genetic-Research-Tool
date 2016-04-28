package com.github.vlsidlyarevich.client;

import com.github.vlsidlyarevich.core.SequenceSearcher;
import com.github.vlsidlyarevich.fileUtils.FileReader;
import com.github.vlsidlyarevich.fileUtils.WriterToFile;
import com.github.vlsidlyarevich.fileUtils.XmlReader;

import java.io.IOException;
import java.util.HashSet;


public class PatentParser {


    public static void main(String[] args) throws IOException {


        String fileName = "ipa070412.xml";

        XmlReader fileReader = new XmlReader(fileName);

        String patent;

        FileReader reader = new FileReader(args[1]);
        HashSet<String> words = reader.getWordsSet();
        FileReader smallWordsReader = new FileReader(args[2]);
        HashSet<String> smallWordsSet = smallWordsReader.getWordsSet();
        FileReader radicalsReader = new FileReader(args[3]);
        HashSet<String> radicals = radicalsReader.getWordsSet();



        SequenceSearcher sequenceSearcher = new SequenceSearcher(words,smallWordsSet,radicals);
        WriterToFile writer = new WriterToFile(fileName);

        while ((patent = fileReader.getPatent()) != null) {
            String temp = "";

            temp = sequenceSearcher.sequenceListCheck(patent);
            if(temp!=null) {
                //System.out.println(temp+ "------Listing");

                continue;
            }

            temp = sequenceSearcher.searchSeq(patent);

            if (temp != null) {
                //System.out.println(temp);
                writer.writeToFile(temp);
            }
            //System.out.println(Utils.getPatentID(patent));
        }
        writer.closeWriter();

    }

}
