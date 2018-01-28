package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("c:\\111\\1.a", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            User user2 = new User();
            user1.setFirstName("fName1");
            user1.setLastName("lName1");
            user1.setBirthDate(new Date());
            user1.setCountry(User.Country.UKRAINE);
            user1.setMale(true);
            user2.setFirstName("fName2");
            user2.setLastName("lName2");
            user2.setBirthDate(new Date());
            user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            /*if (javaRush.users.size() == loadedObject.users.size())*/
            {
                boolean b = true;
                for (int i = 0; i < loadedObject.users.size(); i++) {
                    User jUser = javaRush.users.get(i);
                    User lUser = loadedObject.users.get(i);
                    if (lUser.getFirstName() != null) ;
                    System.out.println(lUser.getFirstName());
                    b = jUser.getFirstName().equals(lUser.getFirstName());
                    if (lUser.getLastName() != null)
                        System.out.println(lUser.getLastName());
                    b = jUser.getLastName().equals(lUser.getLastName());
                    if (lUser.getBirthDate() != null)
                        System.out.println(lUser.getBirthDate());
                    b = jUser.getBirthDate().getTime() == lUser.getBirthDate().getTime();
                    System.out.println(lUser.isMale());
                    b = jUser.isMale() == lUser.isMale();
                    if (lUser.getCountry() != null)
                        System.out.println(lUser.getCountry().getDisplayedName());
                    b = jUser.getCountry().equals(lUser.getCountry());
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size() != 0)
                for (User u : users
                        ) {
                    printWriter.println(u.getFirstName());
                    printWriter.println(u.getLastName());
                    printWriter.println(u.getBirthDate().getTime());
                    printWriter.println(u.isMale());
                    printWriter.println(u.getCountry());
                }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while (br.ready()) {
                User user = new User();
                if (br.ready())
                    user.setFirstName(br.readLine());
                if (br.ready())
                    user.setLastName(br.readLine());
                if (br.ready())
                    user.setBirthDate(new Date(Long.parseLong(br.readLine())));
                if (br.ready())
                    user.setMale(Boolean.parseBoolean(br.readLine()));
                if (br.ready()) {
                    String country = br.readLine().trim();
                    if (country.equals("UKRAINE"))
                        user.setCountry(User.Country.UKRAINE);
                    else if (country.equals("RUSSIA"))
                        user.setCountry(User.Country.RUSSIA);
                    else user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
