package util;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    // 输入字符串
    public static String getString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    // 输入整数
    public static int getInt(String prompt) {
        System.out.print(prompt);

        while (!SCANNER.hasNextInt()) {
            System.out.println("❌ 输入错误，请输入整数！");
            SCANNER.next();
            System.out.print(prompt);
        }

        int num = SCANNER.nextInt();
        SCANNER.nextLine();
        return num;
    }

    // 获取指定范围的菜单数字
    public static int getMenuChoice(String prompt, int min, int max) {
        int num;
        do {
            num = getInt(prompt);
            if (num < min || num > max) {
                System.out.println("❌ 请输入 " + min + " ~ " + max + " 之间的数字！");
            }
        } while (num < min || num > max);
        return num;
    }

    // 关闭Scanner
    public static void close() {
        SCANNER.close();
    }
}