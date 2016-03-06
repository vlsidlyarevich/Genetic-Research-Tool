package com.github.vlsidlyarevich.fileUtils;

import java.io.*;
import java.io.FileReader;

public class XmlReader {

    private BufferedReader reader;
    private File file;

    public XmlReader(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.reader = new BufferedReader(new FileReader(this.file));
    }

    public String getPatent() throws IOException {
        StringBuilder patent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.matches("^\\s*<\\?xml version=\"1\\.0\" encoding=\"UTF-8\"\\?>$")) {
                continue;
            }
            while (!line.matches("^\\s*(<\\/us-patent-grant>)$")) {
                patent.append(line.trim()).append("\n");
                line = reader.readLine();
            }
            patent.append("</us-patent-grant>");
            return patent.toString();
        }
        return null;
    }

    public BufferedReader getReader() {
        return reader;
    }

    @Override
    public String toString() {
        return "com.github.vlsidlyarevich.fileUtils.XmlReader{" +
                "reader=" + reader +
                ", file=" + file +
                '}';
    }
}
