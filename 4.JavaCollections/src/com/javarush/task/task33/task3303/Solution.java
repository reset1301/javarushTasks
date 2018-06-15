package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        FileReader reader = new FileReader(fileName);
//        BufferedReader br = new BufferedReader(new FileReader(fileName));
//        T obj = mapper.readValue(new BufferedReader(new FileReader(fileName)), clazz);
        return mapper.readValue(new File(fileName),clazz);
//        return obj;
    }

    public static void main(String[] args) throws IOException {
//        Cat cat = new Cat();
//        cat.name = "Murka";
//        cat.age = 5;
//        cat.weight = 3;
//
//        StringWriter writer = new StringWriter();
//        convertToJSON(writer, cat);
//        System.out.println(writer.toString());
//
//        BufferedReader br = new BufferedReader(new FileReader("c:/111/1.a"));
//        Cat cat1 = convertFromJsonToNormal("c:/111/1.a", Cat.class);
//        System.out.println(cat1.name + " " + cat1.age + " " + cat1.weight);
    }

//    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(writer, object);
//    }

//    @JsonAutoDetect
//    public static class Cat {
    //        @JsonProperty("wildAnimal")
//        public String name;
    //        @JsonIgnore
//        public int age;
    //        @JsonProperty("over")
//        public int weight;

//        Cat() {
//        }
//    }
}
