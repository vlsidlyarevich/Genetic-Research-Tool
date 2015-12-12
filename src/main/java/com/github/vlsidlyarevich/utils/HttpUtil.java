package com.github.vlsidlyarevich.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class HttpUtil {
    private HttpURLConnection httpURLConnection;
    private BufferedReader bufferedReader;
    private String resultXml;
    private URL url;

    public void urlInit() throws MalformedURLException {
        this.url = new URL(Api.URL);
    }

    private void urlConnectionInit() throws IOException {
        this.httpURLConnection = (HttpURLConnection) url.openConnection();
        this.httpURLConnection.setRequestMethod("GET");
        this.httpURLConnection.connect();
    }

    private void bufferedReaderInit() throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public HttpUtil() throws MalformedURLException {
        try {
            urlInit();
            urlConnectionInit();
            bufferedReaderInit();
            this.resultXml = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getXml() {
        try {
            StringBuffer buffer = new StringBuffer();
            String line;

            while ((line = this.bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            this.resultXml = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.resultXml;
    }


    @Override
    public String toString() {
        return "HttpUtil{" +
                "httpURLConnection=" + httpURLConnection +
                ", bufferedReader=" + bufferedReader +
                ", resultXml='" + resultXml + '\'' +
                ", url=" + url +
                '}';
    }
}