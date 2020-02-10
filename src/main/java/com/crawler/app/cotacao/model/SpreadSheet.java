package com.crawler.app.cotacao.model;

import java.util.List;

public class SpreadSheet {

    String spreadsheetId;
    List<ValueRanges> valueRanges;

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public List<ValueRanges> getValueRanges() {
        return valueRanges;
    }

    public void setValueRanges(List<ValueRanges> valueRanges) {
        this.valueRanges = valueRanges;
    }

}

class ValueRanges {
    String range;
    String majorDimension;
    List<String[]> values;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMajorDimension() {
        return majorDimension;
    }

    public void setMajorDimension(String majorDimension) {
        this.majorDimension = majorDimension;
    }

    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }
}