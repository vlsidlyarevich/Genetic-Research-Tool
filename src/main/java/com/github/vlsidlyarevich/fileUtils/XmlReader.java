package com.github.vlsidlyarevich.fileUtils;

import java.io.*;
import java.io.FileReader;
import java.util.regex.Pattern;

public class XmlReader {

    private BufferedReader reader;
    private File file;
    private Pattern patentPattern;
    private Pattern appPattern;


    public XmlReader(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.reader = new BufferedReader(new FileReader(this.file));
        this.patentPattern = Pattern.compile("\\s*(<!DOCTYPE us-patent-grant)");
        this.appPattern = Pattern.compile("\\s*(<!DOCTYPE us-patent-application)");
    }

    public String getPatent() throws IOException {
        StringBuilder patent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.matches("^\\s*<\\?xml version=\"1\\.0\" encoding=\"UTF-8\"\\?>$")) {
                continue;
            }
            if(patentPattern.matcher(line).find()){
                while ( !line.matches("^\\s*(<\\/us-patent-grant>)$")) {
                    patent.append(line.trim()).append("\n");
                    line = reader.readLine();
                }
                patent.append("</us-patent-grant>");
                return patent.toString();
            }
            else if(appPattern.matcher(line).find()){
                while ( !line.matches("^\\s*(<\\/us-patent-application>)$")) {
                    patent.append(line.trim()).append("\n");
                    line = reader.readLine();
                }
                patent.append("</us-patent-application>");
                return patent.toString();
            }

            //!line.matches("^\\s*(<\\/sequence-cwu>)$") ||

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
