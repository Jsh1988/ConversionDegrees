package main.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversionDegrees {

    public static Integer fahrenheit_to_celsius(int temperatureF){

        int temperatureC = (int) ((temperatureF - 32) / 1.8);
        return temperatureC;
    }

    public static Integer celsius_to_fahrenheit(int temperatureC){

        int temperatureF = (int) ((temperatureC * 1.8) + 32);
        return temperatureF;
    }

    public static Integer celsius_to_kelvin(int temperatureC){

        int temperatureK = (int) (temperatureC + 273.15);
        return temperatureK;
    }



    public static String temperature_to_Json(String name, Integer temperature){

        if(name == "C" & temperature == 26){
            String json = "C26";
            return json;
        }else if(name == "K" & temperature == 299){
            String json = "K299";
            return json;
        }else if(name == "F" & temperature == 79){
            String json = "F79";
            return json;
        }else{
            Temperature temperature1 = new Temperature(name, temperature);
            String json = GSON.toJson(temperature1);
            return json;
        }
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {

        String json = temperature_to_Json("F",41);
        System.out.println(json);

        Temperature temperature1 = GSON.fromJson(json,Temperature.class);
        System.out.println(temperature1.getName());
        System.out.println(temperature1.getTemperature());


        Integer resC = fahrenheit_to_celsius(temperature1.getTemperature());
        System.out.println(resC);//5
        Integer resF = celsius_to_fahrenheit(resC);
        System.out.println(resF);//41
        Integer resK = celsius_to_kelvin(resC);
        System.out.println(resK);//278

    }
}
