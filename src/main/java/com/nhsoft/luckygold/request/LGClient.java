package com.nhsoft.luckygold.request;


import com.nhsoft.luckygold.bean.Item;
import com.nhsoft.luckygold.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LGClient {

    private static final Logger logger = LoggerFactory.getLogger(LGClient.class);//引入到别的系统中，所以不需要实现

   /* public static void main(String[] args) {
        Item item = new Item();
        item.setName("name");
        item.setShortname("shortName");
        item.setBarcode("12345qweqwe");
        item.setShop_barcode("qwe");
        item.setGrade("登记");
        item.setUnit("单位");
        item.setCategory_name("分类");
        item.setOrigin("来源");
        item.setSpec("规格");
        item.setShelf_life("2018-05-24");
        item.setAmount(BigDecimal.valueOf(1000));
        item.setItem_status(true);
        item.setProduction_date("2018-05-24");
        item.setExpiry_date("2018-05-24");
        item.setDiscount_type("折扣");
        item.setDiscount_start_time("2018-05-24");
        item.setDiscount_end_time("2018-05-24");
        item.setRetail_price(BigDecimal.valueOf(100.001));
        item.setVip_price(BigDecimal.valueOf(100.002));
        item.setPromo_retail_price(BigDecimal.valueOf(100.003));
        item.setSuggested_retail_price(BigDecimal.valueOf(100.004));
        item.setPrint_date("2018-05-24");
        item.setPrint_time("12:12");
        item.setCreated_time("2018-05-24 12:12");
        item.setUpdated_time("2018-05-24 12:12");
        item.setItem_serial_id("99586258");
        item.setExtend_field1("");
        item.setExtend_field2("");

       // ResultData resultData = addItem(item);
        ResultData resultData = updateItem(item);
        String result = resultData.getResult();
        System.out.println(result);



    }*/

    public static void main(String[] args) {

        List<RequestData> list = new ArrayList<>();
        RequestData item = new RequestData();
        item.setName("name");
        item.setShortname("shortName");
        item.setBarcode("12345qweqwe");
        item.setShop_barcode("qwe");
        item.setGrade("登记");
        item.setUnit("单位");
        item.setCategory_name("分类");
        item.setOrigin("来源");
        item.setSpec("规格");
        item.setShelf_life("2018-05-24");
        item.setAmount("10000");
        item.setItem_status("true");
        item.setProduction_date("2018-05-24");
        item.setExpiry_date("2018-05-24");
        item.setDiscount_type("折扣");
        item.setDiscount_start_time("2018-05-24");
        item.setDiscount_end_time("2018-05-24");
        item.setRetail_price_inter("1000");
        item.setRetail_price_decimal("1000");

        item.setVip_price_inter("1000");
        item.setVip_price_decimal("1000");

        item.setPromo_retail_price_inter("1000");
        item.setPromo_retail_price_decimal("1000");

        item.setSuggested_retail_price_inter("1000");
        item.setSuggested_retail_price_decimal("1000");
        item.setPrint_date("2018-05-24");
        item.setPrint_time("12:12");
        item.setCreated_time("2018-05-24 12:12");
        item.setUpdated_time("2018-05-24 12:12");
        item.setItem_serial_id("99586258");
        item.setExtend_field1("");
        item.setExtend_field2("");

        list.add(item);
        ResultData resultData = updateTest(list);
        System.out.println();
        // ResultData resultData = addItem(item);
        //ResultData resultData = updateItem(item);
        //String result = resultData.getResult();
        //System.out.println(result);



    }

    public static ResultData updateTest(List<RequestData> list){

        String url = "http://127.0.0.1:8080/esl/merchandise/edit";

        ResultData resultData = null;
        try {
            resultData = HttpUtil.sendTest(url,list);
        } catch (Exception e) {
            return new ResultData(AppConstants.ITEM_ADD_FAIL);
        }
        return resultData;

    }


    public static ResultData addItem(Item item){
        if(item == null){
            return new ResultData(AppConstants.ITEM_IS_NULL);
        }
        String url = "http://127.0.0.1:8080/esl/merchandise/add";
        RequestData requestData = new RequestData();
        RequestData data = CopyUtil.copyProperties(item, requestData);
        Map<String,Object> map = new HashMap<>();
        map.put("new",data);
        ResultData resultData = null;
        try {
            resultData = HttpUtil.sendPost(url, map);
        } catch (Exception e) {
            return new ResultData(AppConstants.ITEM_ADD_FAIL);
        }
        return resultData;

    }

    public static ResultData updateItem(Item item){
        if(item == null){
            return new ResultData(AppConstants.ITEM_IS_NULL);
        }
        String url = "http://127.0.0.1:8080/esl/merchandise/edit";
        RequestData requestData = new RequestData();
        RequestData data = CopyUtil.copyProperties(item, requestData);
        Map<String,Object> map = new HashMap<>();
        map.put("key",data.getBarcode());
        map.put("change",data);
        ResultData resultData = null;
        try {
            resultData = HttpUtil.sendPost(url, map);
        } catch (Exception e) {
            return new ResultData(AppConstants.ITEM_ADD_FAIL);
        }
        return resultData;
    }




}
