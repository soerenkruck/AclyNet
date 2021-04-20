package com.doerte.base.Data;

import java.util.ArrayList;
import java.util.UUID;

public class DataPackage {

    public String id;
    public String header;

    private ArrayList<Data> data;

    public DataPackage() {
        this.id = UUID.randomUUID().toString();

        this.data = new ArrayList<>();
        this.data.add(Data.getStartData());
    }

    private void pack() {
        if (this.data.get(0).dataType != DataType.Start) {
            this.data.add(0, Data.getStartData());
        }
        if (this.data.get(this.data.size() - 1).dataType != DataType.End) {
            this.data.add(Data.getEndData());
        }

        this.header = "§id=" + this.id + ";§size=" + this.data.size();
    }

    public void addData(Data data) {
        if (this.data.get(this.data.size() - 1).dataType == DataType.End)
            this.data.remove(this.data.size() - 1);

        this.data.add(data);
    }

    public void addData(String title, String content) {
        this.addData(new Data(title, content, DataType.Content));
    }
}
