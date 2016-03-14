package com.github.vlsidlyarevich.fileUtils;

import java.io.*;
import java.util.HashSet;

public class FileReader {

    private File file;

    public FileReader(String fileName) {
        this.file = new File(fileName);
    }

    public HashSet<String> getWordsSet() throws IOException {

        HashSet<String> words = new HashSet<String>();

        if (this.file.exists()) {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String temp;

            while ((temp = reader.readLine()) != null) {
                /*temp = temp.substring(0, temp.indexOf(" ") + 1).trim();*/
                words.add(temp);
            }
            return words;
        }

        return null;
    }

    @Override
    public String toString() {
        return "FileReader{" +
                "file=" + file +
                '}';
    }
}
