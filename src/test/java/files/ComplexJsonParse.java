package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {


        JsonPath js = new JsonPath(payload.courcePrice());

        int count = js.getInt("courses.size()");
        System.out.println(count);
        //print purchase amount
       int totalAmount= js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);


    }
}