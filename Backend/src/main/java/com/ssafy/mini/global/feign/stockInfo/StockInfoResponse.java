package com.ssafy.mini.global.feign.stockInfo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StockInfoResponse {

    private Response response;

    @Data
    public static class Response {
        private Body body;

    }

    @Data
    public static class Body {
        private Items items;
    }

    @Data
    public static class Items {
        private List<Item> item;
    }

}