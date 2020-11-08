package com.company.Practice14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int N = scanner.nextInt();
        String t = scanner.nextLine();
        int N = Integer.parseInt(t);
        String[] Regex = new String[N];
        String[] Symbols = new String[N];
        for (int i = 0; i < N; i++) {
            Regex[i] = scanner.next();
            Symbols[i] = scanner.next();
        }
        String s = scanner.next();
        //RegexS(Regex, Symbols, s);
        NotRegexS(Regex, Symbols, s, N);
    }

    public static void RegexS(String[] Regex, String[] Symbols, String s) {
        Pattern pattern;
        Matcher matchers;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < Regex.length; j++) {
                if (i + Regex[j].length() < s.length()) {
                    pattern = Pattern.compile(Regex[j]);
                    matchers = pattern.matcher(s.substring(i, i + Regex[j].length()));
                    if (matchers.find()) {
                        s = s.substring(0, i) + matchers.replaceFirst(Symbols[j] + "|") + s.substring(i + Regex[j].length());
                        i += Symbols[j].length() - 1;
                    }
                }
            }
        }
        pattern = Pattern.compile("\\|");
        matchers = pattern.matcher(s);
        s = matchers.replaceAll("");
        System.out.print(s);
    }

    public static void NotRegexS(String[] Regex, String[] Symbols, String s, int N) {
        String to_out = "";
        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (i + Regex[j].length() <= s.length()) {
                    String key = s.substring(i, i + Regex[j].length());
                    if (Regex[j].equals(key)) {
                        flag = 1;
                        //s = s.replace(Regex[j], Symbols[j] + "");
                        to_out += Symbols[j];
                        i += Regex[j].length() - 1;
                    }
                }
            }
            if (flag == 0)
            {
                to_out += s.charAt(i);
            }
        }
        //s = s.replaceAll(" ", "");
        System.out.print(to_out);
    }
}
