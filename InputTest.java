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
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * 不能輸入中文。
 */
class InputTest {

    public static void main(String[] args) {
        System.out.println("歡迎註冊成為我們的使用者！");

        List<Object> list = new ArrayList<Object>();

        Scanner scanner = new Scanner(System.in);

        try {
            String str = "";

            repeat:
                while (true) {
                    try {
                        System.out.print("請設定您的用戶名：");
                        str = scanner.nextLine();

                        for (char ch : str.toCharArray()) {
                            if ((int)ch > 255) {
                                System.out.printf("您輸入的是中文字：%c%n", ch);
                                continue repeat;
                            }
                        }

                        if (!str.isEmpty()) {
                            break;
                        }
                    } catch (InputMismatchException ex) {
                        break;
                    }
                }

                System.out.printf("您輸入的是：%s%n", str);
        } catch (NoSuchElementException ex) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        scanner.close();
    }

}
