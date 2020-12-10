import java.util.Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import java.util.Collections;
import java.util.Comparator;

import java.util.stream.Collectors;

import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * https://zerojudge.tw/ShowProblem?problemid=e800
 * e800. p7. 影片推薦 - 高中生程式解題系統
 */
class YouTuber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> rank = new HashMap<>();

        try {
            List<Object> list = new ArrayList<Object>();
            int i = 0, j = 0, n = 0;

            while (true) {
                String str = "";
                int val = 0;

                switch (i) {
                    case 1:
                        str = scanner.next();
                        list.add("\"" + str + "\"");
                        break;
                    default:
                        val = scanner.nextInt();
                        list.add(val);
                }

                if (i == 0) {
                    n = val;
                }

                i++;

                if (i > 5) {
                    i = 1;
                }

                if (i == 1) {
                    if (j <= n) {
                        String result = list.stream()
                            .map(x -> String.valueOf(x))
                            .collect(Collectors.joining(", ", "{", "}"));

                        if (j > 0) {
                            int factor = (int)list.get(1) / (int)list.get(2) * (int)list.get(3) * (int)list.get(4);
                            rank.put((String)list.get(0), factor);
                            System.out.printf("%d: %s = %d%n", j, result, factor);
                        }
                        else
                        {
                            System.out.printf("%d: %s%n", j, result);
                        }

                        list.clear();
                    }

                    j++;
                }
            }
        } catch (NoSuchElementException ex) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        scanner.close();

        List<Map.Entry<String, Integer>> rankList = new ArrayList<Map.Entry<String, Integer>>(rank.entrySet());

        Collections.sort(rankList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> ranking : rankList) {
            System.out.printf("%s: %d%n", ranking.getKey(), ranking.getValue());
        }
    }

}
