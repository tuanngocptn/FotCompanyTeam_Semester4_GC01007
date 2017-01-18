/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CareerForJson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import org.json.JSONObject;

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
            list.put(obj2);
        }
        obj.put("career", list);
        try {
            FileWriter file = new FileWriter("D:\\hoctap\\SEM4\\ProjectSem4Strut2\\libra\\lstCareer.json");
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(CareerJson.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.print(obj);
    }

    public List<CareerForJson> read() {
        List<CareerForJson> lstCareer = new ArrayList<>();
        try {

            FileReader fr = new FileReader("D:\\hoctap\\SEM4\\ProjectSem4Strut2\\libra\\lstCareer.json");
            BufferedReader br = new BufferedReader(fr);
            String str, string = "";
            while ((str = br.readLine()) != null) {
                string = string + str;
//                System.out.println(string);
            }
            fr.close();
//            System.out.println(string);

            JSONObject jsonObject = new JSONObject(string);
            JSONArray lstCareerJson = jsonObject.getJSONArray("career");
            for (int i = 0; i < lstCareerJson.length(); i++) {
                JSONObject jsonObject2 = lstCareerJson.getJSONObject(i);
                String code = (String) jsonObject2.getString("code");
                String name = (String) jsonObject2.getString("name");
                String slogan = (String) jsonObject2.getString("slogan");
                Long price = (Long) jsonObject2.getLong("price");
                String image = (String) jsonObject2.getString("image");
                String sortText = (String) jsonObject2.getString("sortText");
                String longText = (String) jsonObject2.getString("longText");
                String show = (String) jsonObject2.getString("show");
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
//        List<CareerForJson> lstCareer = new ArrayList<>();
//        CareerJson careerJson = new CareerJson();
//
//        Integer i = 120000;
//
//        lstCareer.add(new CareerForJson("xd", "Xay dung", "Điện sáng như ban ngày mà nước thì mênh mông", i.longValue(), "images/career/kcbt2.jpg", "Chúng tôi sẽ mang điện, nước tới cho các bạn với đội ngũ 500 anh em hùng hậu.\n"
//                + " Cam kết đảm bảo nhanh gọn, chất lượng.", "Công ty fot chúng tôi tự hào đã có nhiều năm kinh nghiệm trong lĩnh vực sửa chữa điện nước, công ty chúng tôi đã đem lại sự tin cậy và uy tín dành cho khách hàng. Nhà bạn đang bị hư hỏng về điện hoặc nước,\n"
//                + " hãy liên hệ ngay chỉ sau 15 phút chúng tôi sẽ có mặt.\n"
//                + "	 Dịch vụ của công chúng tôi gồm có:\n"
//                + "- Lắp đặt điện nước cho các hộ gia đình, nhà cao tầng, chung cư, nhà nghỉ, khách sạn…\n"
//                + "– Xử lý các sự cố như: cháy, chập điện, cầu giao, ổ cắm bị hở điện, át tô mát, tủ điện…\n"
//                + "– Sửa chữa khắc phục sự cố hệ thống nước, bồn cầu, chậu rửa, sen vòi, lababo,…các sự cố về rò rỉ, mất nước, thủng đường ống…\n"
//                + "– Sửa chữa lắp đặt bình nóng lạnh,máy bơm nước, điều hòa… \n"
//                + "Đến với công ty chúng tôi, quý khách luôn yên về chất lượng và giá cả.\n"
//                + " Với nhiều năm kinh nghiệm, chúng tôi đảm bảo sẽ mang lại cho bạn một dịch vụ tốt nhất. (detail)", "1"));
//        
//         lstCareer.add(new CareerForJson("bm", "Xay dung", "Điện sáng như ban ngày mà nước thì mênh mông", i.longValue(), "images/career/kcbt2.jpg", "Chúng tôi sẽ mang điện, nước tới cho các bạn với đội ngũ 500 anh em hùng hậu.\n"
//                + " Cam kết đảm bảo nhanh gọn, chất lượng.", "Công ty fot chúng tôi tự hào đã có nhiều năm kinh nghiệm trong lĩnh vực sửa chữa điện nước, công ty chúng tôi đã đem lại sự tin cậy và uy tín dành cho khách hàng. Nhà bạn đang bị hư hỏng về điện hoặc nước,\n"
//                + " hãy liên hệ ngay chỉ sau 15 phút chúng tôi sẽ có mặt.\n"
//                + "	 Dịch vụ của công chúng tôi gồm có:\n"
//                + "- Lắp đặt điện nước cho các hộ gia đình, nhà cao tầng, chung cư, nhà nghỉ, khách sạn…\n"
//                + "– Xử lý các sự cố như: cháy, chập điện, cầu giao, ổ cắm bị hở điện, át tô mát, tủ điện…\n"
//                + "– Sửa chữa khắc phục sự cố hệ thống nước, bồn cầu, chậu rửa, sen vòi, lababo,…các sự cố về rò rỉ, mất nước, thủng đường ống…\n"
//                + "– Sửa chữa lắp đặt bình nóng lạnh,máy bơm nước, điều hòa… \n"
//                + "Đến với công ty chúng tôi, quý khách luôn yên về chất lượng và giá cả.\n"
//                + " Với nhiều năm kinh nghiệm, chúng tôi đảm bảo sẽ mang lại cho bạn một dịch vụ tốt nhất. (detail)", "1"));
//        
//          lstCareer.add(new CareerForJson("kcbt", "Xay dung", "Điện sáng như ban ngày mà nước thì mênh mông", i.longValue(), "images/career/kcbt2.jpg", "Chúng tôi sẽ mang điện, nước tới cho các bạn với đội ngũ 500 anh em hùng hậu.\n"
//                + " Cam kết đảm bảo nhanh gọn, chất lượng.", "Công ty fot chúng tôi tự hào đã có nhiều năm kinh nghiệm trong lĩnh vực sửa chữa điện nước, công ty chúng tôi đã đem lại sự tin cậy và uy tín dành cho khách hàng. Nhà bạn đang bị hư hỏng về điện hoặc nước,\n"
//                + " hãy liên hệ ngay chỉ sau 15 phút chúng tôi sẽ có mặt.\n"
//                + "	 Dịch vụ của công chúng tôi gồm có:\n"
//                + "- Lắp đặt điện nước cho các hộ gia đình, nhà cao tầng, chung cư, nhà nghỉ, khách sạn…\n"
//                + "– Xử lý các sự cố như: cháy, chập điện, cầu giao, ổ cắm bị hở điện, át tô mát, tủ điện…\n"
//                + "– Sửa chữa khắc phục sự cố hệ thống nước, bồn cầu, chậu rửa, sen vòi, lababo,…các sự cố về rò rỉ, mất nước, thủng đường ống…\n"
//                + "– Sửa chữa lắp đặt bình nóng lạnh,máy bơm nước, điều hòa… \n"
//                + "Đến với công ty chúng tôi, quý khách luôn yên về chất lượng và giá cả.\n"
//                + " Với nhiều năm kinh nghiệm, chúng tôi đảm bảo sẽ mang lại cho bạn một dịch vụ tốt nhất. (detail)", "1"));
//        
//           lstCareer.add(new CareerForJson("hbp", "Xay dung", "Điện sáng như ban ngày mà nước thì mênh mông", i.longValue(), "images/career/kcbt2.jpg", "Chúng tôi sẽ mang điện, nước tới cho các bạn với đội ngũ 500 anh em hùng hậu.\n"
//                + " Cam kết đảm bảo nhanh gọn, chất lượng.", "Công ty fot chúng tôi tự hào đã có nhiều năm kinh nghiệm trong lĩnh vực sửa chữa điện nước, công ty chúng tôi đã đem lại sự tin cậy và uy tín dành cho khách hàng. Nhà bạn đang bị hư hỏng về điện hoặc nước,\n"
//                + " hãy liên hệ ngay chỉ sau 15 phút chúng tôi sẽ có mặt.\n"
//                + "	 Dịch vụ của công chúng tôi gồm có:\n"
//                + "- Lắp đặt điện nước cho các hộ gia đình, nhà cao tầng, chung cư, nhà nghỉ, khách sạn…\n"
//                + "– Xử lý các sự cố như: cháy, chập điện, cầu giao, ổ cắm bị hở điện, át tô mát, tủ điện…\n"
//                + "– Sửa chữa khắc phục sự cố hệ thống nước, bồn cầu, chậu rửa, sen vòi, lababo,…các sự cố về rò rỉ, mất nước, thủng đường ống…\n"
//                + "– Sửa chữa lắp đặt bình nóng lạnh,máy bơm nước, điều hòa… \n"
//                + "Đến với công ty chúng tôi, quý khách luôn yên về chất lượng và giá cả.\n"
//                + " Với nhiều năm kinh nghiệm, chúng tôi đảm bảo sẽ mang lại cho bạn một dịch vụ tốt nhất. (detail)", "1"));
//        
        
//        lstCareer.add(new CareerForJson("code03", "name03","slogan3", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
//        lstCareer.add(new CareerForJson("code04", "name04","slogan4", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "1"));
//        lstCareer.add(new CareerForJson("code05", "name05","slogan5", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
//        lstCareer.add(new CareerForJson("code06", "name06","slogan6", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
//        lstCareer.add(new CareerForJson("code07", "name07","slogan7", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));
//        lstCareer.add(new CareerForJson("code08", "name08","slogan8", i.longValue(), "images/career/kcbt2.jpg", "sortText", "longText", "0"));


//        lstCareer.forEach((careerForJson) -> {
//            System.out.println(careerForJson);
//        });
//        careerJson.write(lstCareer);
//        lstCareer = new ArrayList<>();


        List<CareerForJson> lstCareerJson = new ArrayList<>();
        CareerJson careerJson = new CareerJson();
        lstCareerJson = careerJson.read();
        lstCareerJson.forEach((careerForJson) -> {
            System.out.println(careerForJson.getCode()+"---"+careerForJson.getImage());
//            if(careerForJson.getCode().equals("lx"))
//                careerForJson.setImage("images/career/lai-xe.jpg");
        });
        careerJson.write(lstCareerJson);
//        images/career/1113687448.jpg
    }
}
