package io.hmshamim.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private List<String> urls = new ArrayList<>();

    public void push(String url){
        urls.add(url);
    }


}
