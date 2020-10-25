package com.company.Practice14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Regex test = new Regex();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] Regex = new String[N];
        String[] Symbols = new String[N];
        for (int i = 0; i < N; i++) {
            Regex[i] = scanner.next();
            Symbols[i] = scanner.next();
            test.setRegex(Regex[i]);
            test.setSymbol(Symbols[i]);
        }
        String s = scanner.next();
        RegexS(Regex, Symbols, s);
        NotRegexS(Regex, Symbols, s);
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
                        i += Symbols[j].length();
                        break;
                    }
                }
            }
        }
        pattern = Pattern.compile("\\|");
        matchers = pattern.matcher(s);
        s = matchers.replaceAll("");
        System.out.println(s);
    }

    public static void NotRegexS(String[] Regex, String[] Symbols, String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < Regex.length; j++) {
                if (i + Regex[j].length() < s.length() && s.startsWith(Regex[j], i)) {
                    s = s.replace(Regex[j], Symbols[j] + "|");
                    i += Symbols[j].length();
                    break;
                }
            }
        }
        s = s.replaceAll("\\|", "");
        System.out.println(s);
    }
}
