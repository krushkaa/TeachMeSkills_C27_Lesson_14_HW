package com.teachmeskills.lesson14.task1.validator;

import com.teachmeskills.lesson14.task1.consts.Consts;

import java.io.FileWriter;
import java.io.IOException;

public class Validator {

    public static void checkFile(String s) throws IOException {
        FileWriter fileWriterErr = new FileWriter(Consts.PATH_TO_ERROR_FILE, true);
        FileWriter fileWriterDoc = new FileWriter(Consts.PATH_TO_DOC_FILE, true);
        FileWriter fileWriterContract = new FileWriter(Consts.PATH_TO_CONTRACT_FILE, true);

        try {
            if (s.isEmpty()) return;
            if (s.length() != Consts.STRING_LENGTH) {
                fileWriterErr.write("Invalid string length " + s + ". Maximum length: " + Consts.STRING_LENGTH + ". \n");
                return;
            }
            char[] chars = s.toCharArray();
            if (!s.startsWith(Consts.DOC_STARTS_WITH) && !s.startsWith(Consts.CONTRACT_STARTS_WITH))
                fileWriterErr.write("Invalid '" + s + "' name. The document name does not meet the standard. \n");
            else if (s.startsWith(Consts.DOC_STARTS_WITH)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        fileWriterErr.write("Invalid characters in string " + s + ".\n");
                        return;
                    }
                }
                fileWriterDoc.write(s + "\n");
            } else if (s.startsWith(Consts.CONTRACT_STARTS_WITH)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        fileWriterErr.write("Invalid characters in string " + s + ".\n");
                        return;
                    }
                }
                fileWriterContract.write(s + "\n");
            }
        } catch (IOException e) {
            fileWriterErr.write("An unexpected error occurred while processing the string " + s + ".\n");
            System.out.println("An unexpected error occurred.");
        } catch (Exception e) {
            fileWriterErr.write("A critical error occurred while processing the string " + s + ".\n");
            System.out.println("Fatal error. Thank you for your patience. We are working on it.");
        } finally {
            fileWriterErr.close();
            fileWriterDoc.close();
            fileWriterContract.close();
        }
    }
}
