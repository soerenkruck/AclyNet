/*
 * Copyright (c) 2021. Aquad
 * Sören Dominik Kruck
 * Alias: Doerte
 */

package com.doerte.base.Data;



import java.io.File;

public class Data {

    public String header;
    public String content;

    public DataType dataType;

    public static final String TYPE_START = "begin§[]";
    public static final String TYPE_END = "end§[]";

    public Data(String header, String content, DataType dataType) {
        this.header = header;
        this.content = content;
        this.dataType = dataType;
    }

    public void fillDataFromFile(File fileURI) {
        // TODO: implement method
    }

    public void fillData(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public void setDataType(DataType dataType) {
        if (this.dataType != dataType) {
            switch (dataType) {
                case End -> {
                    this.header = TYPE_END;
                    this.content = "null";
                }
                case Start -> {
                    this.header = TYPE_START;
                    this.content = "null";
                }
            }
        }
    }

    public static Data getStartData() {
        return new Data(Data.TYPE_START, "null", DataType.Start);
    }
    public static Data getEndData() {
        return new Data(Data.TYPE_END, "null", DataType.End);
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
}
