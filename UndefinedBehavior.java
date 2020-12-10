/**
 * Undefined Behavior
 */
class UndefinedBehavior {

    public static void main(String[] args) {
        int x = 1, y = 1;
        boolean b = ++x > ++y;
        System.out.println(b);
    }

}
