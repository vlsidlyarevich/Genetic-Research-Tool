package com.github.vlsidlyarevich;

import java.io.*;

public class XmlReader {

    private BufferedReader reader;
    private File file;

    public XmlReader(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        this.reader = new BufferedReader(new java.io.FileReader(file));
    }

    public String getPatent() throws IOException {
        StringBuilder patent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.matches("^\\s*<\\?xml version=\"1\\.0\" encoding=\"UTF-8\"\\?>$")) {
                break;
            }
        }

        if (line != null) {
            while (!line.matches("^\\s*(<[/]us-patent-grant>)$")) {
                patent.append(line.trim()).append("\n");
                line = reader.readLine();
            }
            patent.append("</us-patent-grant>");
            return patent.toString();
        } else {
            return null;
        }
    }

    public BufferedReader getReader() {
        return reader;
    }

    @Override
    public String toString() {
        return "com.github.vlsidlyarevich.XmlReader{" +
                "reader=" + reader +
                ", file=" + file +
                '}';
    }
}
