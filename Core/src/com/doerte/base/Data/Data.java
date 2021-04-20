/*
 * Copyright (c) 2021. Aquad
 * Sören Dominik Kruck
 * Alias: Doerte
 */

package com.doerte.base.Data;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Data {

    Charset contentCharset;

    public String header;
    public String content;

    public DataType dataType;

    public Data(String dataName, String content, DataType dataType) {
        this.content = content;
        this.dataType = dataType;

        this.contentCharset = StandardCharsets.UTF_8;

        this.header = HeaderCreator.generateHeader(dataName, content.getBytes(this.contentCharset));
    }

    /** Puts the bytes from a file into the content section of a data pack.
     *  @param fileURI: The location of the file
     **/
    public void fillDataFromFile(File fileURI) {
        // TODO: implement method
    }

    public void fillData(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public void fillData(String header, String content, DataType dataType) {
        this.dataType = dataType;

        if (dataType != DataType.Content)
            this.setDataType(dataType);

        this.content = content;
        this.header = HeaderCreator.generateHeader(this.dataType, this.content.getBytes(this.contentCharset));
    }

    public void setDataType(DataType dataType) {
        if (this.dataType != dataType) {
            switch (dataType) {
                case End -> {
                    this.header = DataType.TYPE_END;
                    this.content = "null";
                }
                case Start -> {
                    this.header = DataType.TYPE_START;
                    this.content = "null";
                }
                case Content -> {
                    this.header = DataType.TYPE_CONTENT;
                }
            }
        }
    }

    public static Data getStartData() {
        return new Data(DataType.TYPE_START, "null", DataType.Start);
    }
    public static Data getEndData() {
        return new Data(DataType.TYPE_END, "null", DataType.End);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getContentBytes(String content) {
        return content.getBytes(this.contentCharset);
    }

    static class HeaderCreator {

        public static String generateHeader(DataType dataType, byte[] dataBytes) {
            String header;
            header = "type=" + DataType.getString(dataType) + ";uuid=" + UUID.randomUUID().toString() + ";bytes=" + dataBytes.length;
            return header;
        }

        public static String generateHeader(String name, byte[] dataBytes) {
            String header;
            header = "type=" + DataType.getString(DataType.Content) + ";uuid=" + UUID.randomUUID().toString() + ";bytes=" + dataBytes.length + ";name=" + name;
            return header;
        }

    }
}


