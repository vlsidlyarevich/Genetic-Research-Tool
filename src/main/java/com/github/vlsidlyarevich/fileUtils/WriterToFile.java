package com.github.vlsidlyarevich.fileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {


    private File file;
    private BufferedWriter fileWriter;

    public WriterToFile(String fileName) throws IOException {
        this.file = new File(fileName.replaceAll(("\\.xml"),"-result.txt"));
        if (!this.file.exists()) {
            this.file.createNewFile();
        }
        this.fileWriter = new BufferedWriter(new FileWriter(this.file.getAbsoluteFile()));
    }

    public void writeToFile(String string){
        try {
            fileWriter.write(string);
            fileWriter.write("\n");
            /*fileWriter.write("\n------------------\n");*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeWriter() throws IOException {
        this.fileWriter.close();
    }

    @Override
    public String toString() {
        return "WriterToFile{" +
                "file=" + file +
                ", fileWriter=" + fileWriter +
                '}';
    }
}
