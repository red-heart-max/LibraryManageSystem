package com.chun.entity;


import com.chun.utils.FileUtil;
import com.chun.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class WebFaceCompare {
    public String getXParam(String imageBase641, String imageEncoding1, String imageBase642, String imageEncoding2) {
        JsonObject jso = new JsonObject();

        /** header **/
        JsonObject header = new JsonObject();
        header.addProperty("app_id", Property.appid);
        header.addProperty("status", 3);

        jso.add("header", header);

        /** parameter **/
        JsonObject parameter = new JsonObject();
        JsonObject service = new JsonObject();
        service.addProperty("service_kind", "face_compare");

        JsonObject faceCompareResult = new JsonObject();
        faceCompareResult.addProperty("encoding", "utf8");
        faceCompareResult.addProperty("format", "json");
        faceCompareResult.addProperty("compress", "raw");
        service.add("face_compare_result", faceCompareResult);
        parameter.add(Property.serviceId, service);
        jso.add("parameter", parameter);

        /** payload **/
        JsonObject payload = new JsonObject();
        JsonObject inputImage1 = new JsonObject();
        inputImage1.addProperty("encoding", imageEncoding1);
        inputImage1.addProperty("image", imageBase641);
        payload.add("input1", inputImage1);

        JsonObject inputImage2 = new JsonObject();
        inputImage2.addProperty("encoding", imageEncoding2);
        inputImage2.addProperty("image", imageBase642);
        payload.add("input2", inputImage2);
        System.out.println(jso.toString());
        jso.add("payload", payload);
        return jso.toString();
    }


    //读取image
    private byte[] readImage(String imagePath) throws IOException {
        InputStream is = new FileInputStream(imagePath);
        byte[] imageByteArray = FileUtil.read(imagePath);
        //return is.readAllBytes();
        return imageByteArray;
    }

    public ResponseData faceContrastImageBase64(String base641, String base642) throws Exception {
        String url = assembleRequestUrl(Property.requestUrl, Property.apiKey, Property.apiSecret);
        String imageBase641 = removeBase64Prefix(base641);
        String imageBase642 = removeBase64Prefix(base642);
        return handleFaceContrastRes(url, getXParam(imageBase641, "jpg", imageBase642, "jpg"));
    }

    public ResponseData faceContrastImagePath(String imageFirstUrl, String imageSecondUrl) throws Exception {
        String url = assembleRequestUrl(Property.requestUrl, Property.apiKey, Property.apiSecret);
        String imageBase641 = Base64.getEncoder().encodeToString(readImage(imageFirstUrl));
        String imageBase642 = Base64.getEncoder().encodeToString(readImage(imageSecondUrl));
        String imageEncoding1 = imageFirstUrl.substring(imageFirstUrl.lastIndexOf(".") + 1);
        String imageEncoding2 = imageSecondUrl.substring(imageSecondUrl.lastIndexOf(".") + 1);
        return handleFaceContrastRes(url, getXParam(imageBase641, imageEncoding1, imageBase642, imageEncoding2));
    }


//移除base64 前缀
    /*
    * String s =  "data:image/jpeg;base64,JSLKDJNUAISDUDNFADFANDLSFJASDF;JALSD;FADSFADSUHFNAJKDSF";
    * */
    public String removeBase64Prefix(String content){
        String text="";
        Matcher matcher = Pattern.compile("^data.(.*?);base64,").matcher(content);
        if (matcher.find()){
           text = content.replace(matcher.group(),"");
        }
        return text;
    }



    public static final Gson json = new Gson();

    private ResponseData handleFaceContrastRes(String url, String bodyParam) {

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        String result = HttpUtil.doPost2(url, headers,bodyParam);
        if (result != null) {
            System.out.println("人脸识别接口调用结果：" + result);
            return json.fromJson(result, ResponseData.class);
        } else {
            return null;
        }
    }


    //构建url
    public static String assembleRequestUrl(String requestUrl, String apiKey, String apiSecret) {
        URL url = null;
        // 替换调schema前缀 ，原因是URL库不支持解析包含ws,wss schema的url
        String  httpRequestUrl = requestUrl.replace("ws://", "http://").replace("wss://","https://" );
        try {
            url = new URL(httpRequestUrl);
            //获取当前日期并格式化
            SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            String date = format.format(new Date());

            String host = url.getHost();
            if (url.getPort()!=80 && url.getPort() !=443){
                host = host +":"+String.valueOf(url.getPort());
            }
            StringBuilder builder = new StringBuilder("host: ").append(host).append("\n").//
                    append("date: ").append(date).append("\n").//
                    append("POST ").append(url.getPath()).append(" HTTP/1.1");
            Charset charset = Charset.forName("UTF-8");
            Mac mac = Mac.getInstance("hmacsha256");
            SecretKeySpec spec = new SecretKeySpec(apiSecret.getBytes(charset), "hmacsha256");
            mac.init(spec);
            byte[] hexDigits = mac.doFinal(builder.toString().getBytes(charset));
            String sha = Base64.getEncoder().encodeToString(hexDigits);

            String authorization = String.format("api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", apiKey, "hmac-sha256", "host date request-line", sha);
            String authBase = Base64.getEncoder().encodeToString(authorization.getBytes(charset));
            return String.format("%s?authorization=%s&host=%s&date=%s", requestUrl, URLEncoder.encode(authBase), URLEncoder.encode(host), URLEncoder.encode(date));

        } catch (Exception e) {
            throw new RuntimeException("assemble requestUrl error:"+e.getMessage());
        }
    }

    public static class ResponseData {
        private Header header;
        private PayLoad payload;
        public Header getHeader() {
            return header;
        }
        public PayLoad getPayLoad() {
            return payload;
        }
    }
    public static class Header {
        private int code;
        private String message;
        private String sid;
        public int getCode() {
            return code;
        }
        public String getMessage() {
            return message;
        }
        public String getSid() {
            return sid;
        }
    }
    public static class PayLoad {
        private FaceResult face_compare_result;
        public FaceResult getFaceCompareResult() {
            return face_compare_result;
        }
    }
    public static class FaceResult {
        private String compress;
        private String encoding;
        private String format;
        private String text;
        public String getCompress() {
            return compress;
        }
        public String getEncoding() {
            return encoding;
        }
        public String getFormat() {
            return format;
        }
        public String getText() {
            return text;
        }
    }
}
