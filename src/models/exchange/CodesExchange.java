package models.exchange;

import java.util.ArrayList;

import models.records.RCodes;

public class CodesExchange {
    private ArrayList<String> codeList = new ArrayList<>();

    public CodesExchange (RCodes code) {
        code.supported_codes().forEach(x -> {
            codeList.add(x.toString().replace("[", "").replace("]", ""));
        });
    }
    public ArrayList<String> getCodeList() {
        return codeList;
    }
}
