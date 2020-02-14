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

