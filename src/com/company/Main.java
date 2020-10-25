package com.company;

import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        long start = System.currentTimeMillis();

        CustomArray potterUniqWords = new CustomArray();

        FileReader fr = new FileReader("harry.txt");
        Scanner scan = new Scanner(fr);

        while(scan.hasNextLine()) {

            String[] tempPotterWords = scan.nextLine()
                                            .toLowerCase()
                                            .replaceAll("[[(){},.:;!?<>%\n-]]", "")
                                            .split(" ");

            for(String word : tempPotterWords)

                if(!word.isEmpty()){

                    if(!potterUniqWords.isKeyExists(word))
                        potterUniqWords.add(word, 1);
                    else
                        potterUniqWords.set(word, potterUniqWords.get(word) + 1);

                }

        }

        fr.close();

        System.out.println(potterUniqWords.sort( (byte) 0));

        System.out.println("Program execution time is " + (System.currentTimeMillis() - start) + " ms.");


    }
}
