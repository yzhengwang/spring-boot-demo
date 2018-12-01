package com.ordin.utils.utils;

import java.util.HashMap;

public class ResultFormat {

    private static final int SUCCESS = 200;
    private static final int ERROR = 300;

    public static HashMap<String, Object> success(int code, String message, Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        map.put("result", data);
        return map;
    }

    public static HashMap<String, Object> success(String message, Object data) {
        return ResultFormat.success(ResultFormat.SUCCESS, message, data);
    }

    public static HashMap<String, Object> success(Object data) {
        return ResultFormat.success("success", data);
    }

    public static HashMap<String, Object> success(String message) {
        return ResultFormat.success(ResultFormat.SUCCESS, message, "");
    }

    public static HashMap<String, Object> success() {
        return ResultFormat.success(ResultFormat.SUCCESS, "success", "");
    }

    public static HashMap<String, Object> error(int code, String message) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        return map;
    }

    public static HashMap<String, Object> error(int code) {
        return ResultFormat.error(code, "error");
    }

    public static HashMap<String, Object> error(String message) {
        return ResultFormat.error(ResultFormat.ERROR,message);
    }

    public static HashMap<String, Object> error() {
        return ResultFormat.error(ResultFormat.ERROR);
    }

}
