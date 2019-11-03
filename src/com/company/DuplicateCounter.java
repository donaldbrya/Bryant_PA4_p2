package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public void count(String dataFile) throws FileNotFoundException {

        String word;

        wordCounter = new HashMap<String, Integer>();

        Scanner sc = new Scanner(new File(dataFile));


        while (sc.hasNext()) {

            word = sc.next();

            if (wordCounter.containsKey(word)) {

                wordCounter.put(word, wordCounter.get(word) + 1);

            } else {

                wordCounter.put(word, 1);

            }

        }

        sc.close();

    }

    public void write(String outputFile) throws IOException {

        File f1;

        FileWriter fw = null;

        f1 = new File(outputFile);

        if (!f1.exists()) {

            f1.createNewFile();

        }

        fw = new FileWriter(f1);

        for (Map.Entry entry : wordCounter.entrySet()) {

            fw.write(entry.getKey() + " " + entry.getValue() + " ");

        }

        fw.close();

        System.out.println("Data Written to File");

    }
}


