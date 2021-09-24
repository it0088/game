package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }
        ArrayList <String> listResult = new ArrayList<>(list);

        for (int j = (listResult.size()-1); j > 0; j--) {

            if (listResult.get(0).length() < listResult.get(j).length()) {
                listResult.remove(j);
            } else if (listResult.get(0).length() > listResult.get(j).length()) {
                listResult.remove(0);
            }
        }

        for (String string : listResult) {
            System.out.println(string);
        }
    }

}
