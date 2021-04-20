package com.doerte.base.Data;

public enum DataType {

    Start, Content, End;

    public static final String TYPE_START = "begin§[]";
    public static final String TYPE_END = "end§[]";
    public static final String TYPE_CONTENT = "content§[]";

    public static String getString(DataType dataType) {
        String r = null;

        switch (dataType) {
            case Start -> r = TYPE_START;
            case Content -> r = TYPE_CONTENT;
            case End -> r = TYPE_END;
        }

        return r;

    }

}
