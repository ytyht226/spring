package com.nlu;

import lombok.Data;

import java.util.Map;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Data
public class TNluRequest {
    private String version;
    private String query;
    private Map<String, String> map;

    public TNluRequest(String query) {
        this.query = query;
    }
}