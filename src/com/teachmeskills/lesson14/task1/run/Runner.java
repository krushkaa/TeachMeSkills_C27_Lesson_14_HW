package com.teachmeskills.lesson14.task1.run;

import com.teachmeskills.lesson14.task1.consts.Consts;
import com.teachmeskills.lesson14.task1.validator.Validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            while (line != null) {
                Validator.checkFile(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something is wrong.");
        } catch (Exception e) {
            System.out.println("ERROR. Thank you for your patience. We are working on it.");
        }
        scan.close();
    }
}

