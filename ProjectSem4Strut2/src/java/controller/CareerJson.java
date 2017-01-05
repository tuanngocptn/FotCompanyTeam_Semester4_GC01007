/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CareerForJson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ADMIN
 */
public class CareerJson {

    public void write(List<CareerForJson> lstCareer) {
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONArray list = new JSONArray();
        for (CareerForJson career : lstCareer) {
            obj2 = new JSONObject();
            obj2.put("code", career.getCode());
            obj2.put("name", career.getName());
            obj2.put("slogan", career.getSlogan());
            obj2.put("price", career.getPrice());
            obj2.put("image", career.getImage());
            obj2.put("sortText", career.getSortText());
            obj2.put("longText", career.getLongText());
            obj2.put("show", career.getShow());
            list.add(obj2);
        }
        obj.put("career", list);
        try {
            FileWriter file = new FileWriter("D:\\hoctap\\SEM4\\ProjectSem4Strut2\\libra\\lstCareer.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(CareerJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(obj);
    }

    public List<CareerForJson> read() {
        JSONParser parser = new JSONParser();
        List<CareerForJson> lstCareer = new ArrayList<>();
        try {
            Object obj = parser.parse(new FileReader("D:\\hoctap\\SEM4\\ProjectSem4Strut2\\libra\\lstCareer.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lstCarrer = (JSONArray) jsonObject.get("career");
            Iterator<JSONObject> iterator = lstCarrer.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject2 = iterator.next();
                String code = (String) jsonObject2.get("code");
                String name = (String) jsonObject2.get("name");
                String slogan = (String) jsonObject2.get("slogan");
                Long price = (Long) jsonObject2.get("price");
                String image = (String) jsonObject2.get("image");
                String sortText = (String) jsonObject2.get("sortText");
                String longText = (String) jsonObject2.get("longText");
                String show = (String) jsonObject2.get("show");
                lstCareer.add(new CareerForJson(code, name, slogan, price, image, sortText, longText, show));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CareerJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(CareerJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCareer;
    }

    public static void main(String[] args) {
        List<CareerForJson> lstCareer = new ArrayList<>();
        CareerJson careerJson = new CareerJson();

        Integer i = 1;
        lstCareer.add(new CareerForJson("code01", "name01","slogan1", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
        lstCareer.add(new CareerForJson("code02", "name02","slogan2", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
        lstCareer.add(new CareerForJson("code03", "name03","slogan3", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
        lstCareer.add(new CareerForJson("code04", "name04","slogan4", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
        lstCareer.add(new CareerForJson("code05", "name05","slogan5", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
        lstCareer.add(new CareerForJson("code06", "name06","slogan6", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
        lstCareer.add(new CareerForJson("code07", "name07","slogan7", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
        lstCareer.add(new CareerForJson("code08", "name08","slogan8", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
        lstCareer.forEach((careerForJson) -> {
            System.out.println(careerForJson);
        });
        careerJson.write(lstCareer);
        lstCareer = careerJson.read();
        lstCareer.forEach((careerForJson) -> {
            System.out.println(careerForJson);
        });
    }
}
