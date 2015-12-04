public class BinaryTreeTestHarness {
    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();
        test_CursorMethods();
        test_Contains();
        test_Similar();
        test_equals();


        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_equals() {

        BinaryTree bt = new BinaryTree("0");
        bt.attachLeftSonAtCursor("1");
        bt.attachRightSonAtCursor("2");
        bt.putCursorAtLeftSon();
        bt.attachLeftSonAtCursor("3");
        bt.attachRightSonAtCursor("4");
        bt.putCursorAtFather();
        bt.putCursorAtRightSon();
        bt.attachLeftSonAtCursor("5");
        bt.attachRightSonAtCursor("6");

        BinaryTree bt1 = new BinaryTree("0");
        bt1.attachLeftSonAtCursor("1");
        bt1.attachRightSonAtCursor("2");
        bt1.putCursorAtLeftSon();
        bt1.attachLeftSonAtCursor("3");
        bt1.attachRightSonAtCursor("4");
        bt1.putCursorAtFather();
        bt1.putCursorAtRightSon();
        bt1.attachLeftSonAtCursor("5");
        bt1.attachRightSonAtCursor("6");


        try {
            displaySuccessIfTrue(bt.equals(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.equals(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1 = new BinaryTree();
        bt = new BinaryTree();

        try {
            displaySuccessIfTrue(bt.equals(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_Similar() {
        BinaryTree bt = new BinaryTree("0");
        bt.attachLeftSonAtCursor("1");
        bt.attachRightSonAtCursor("2");
        bt.putCursorAtLeftSon();
        bt.attachLeftSonAtCursor("3");
        bt.attachRightSonAtCursor("4");
        bt.putCursorAtFather();
        bt.putCursorAtRightSon();
        bt.attachLeftSonAtCursor("5");
        bt.attachRightSonAtCursor("6");

        BinaryTree bt1 = new BinaryTree("0");
        bt1.attachLeftSonAtCursor("1");
        bt1.attachRightSonAtCursor("2");
        bt1.putCursorAtLeftSon();
        bt1.attachLeftSonAtCursor("3");
        bt1.attachRightSonAtCursor("4");
        bt1.putCursorAtFather();
        bt1.putCursorAtRightSon();
        bt1.attachLeftSonAtCursor("5");
        bt1.attachRightSonAtCursor("6");

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1 = new BinaryTree("123");

        try {
            displaySuccessIfTrue(!bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1.attachLeftSonAtCursor("1");
        bt1.attachRightSonAtCursor("2");
        bt1.putCursorAtLeftSon();
        bt1.attachLeftSonAtCursor("3");
        bt1.attachRightSonAtCursor("4");
        bt1.putCursorAtFather();
        bt1.putCursorAtRightSon();
        bt1.attachLeftSonAtCursor("5");
        bt1.attachRightSonAtCursor("6");

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt = new BinaryTree("123");
        bt1 = new BinaryTree("123");

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1 = new BinaryTree(new Object());

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1.attachLeftSonAtCursor(new Object());
        bt1.attachRightSonAtCursor(new Object());
        bt.attachLeftSonAtCursor(new Object());
        bt.attachRightSonAtCursor(new Object());

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt1 = new BinaryTree();
        bt = new BinaryTree();

        try {
            displaySuccessIfTrue(bt.similar(bt1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

    public static void test_Contains() {
        BinaryTree bt = new BinaryTree("0");

        try {
            displaySuccessIfTrue(bt.contains("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachLeftSonAtCursor("1");
        bt.attachRightSonAtCursor("2");
        bt.putCursorAtLeftSon();
        bt.attachLeftSonAtCursor("3");
        bt.attachRightSonAtCursor("4");
        bt.putCursorAtFather();
        bt.putCursorAtRightSon();
        bt.attachLeftSonAtCursor("5");
        bt.attachRightSonAtCursor("6");

        try {
            displaySuccessIfTrue(bt.contains("4"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!bt.contains("7"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        
    }

    

    public static void test_CursorMethods() {

       BinaryTree bt = new BinaryTree(new String("0")); 

        try {
            displaySuccessIfTrue(bt.getSize() == 1);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachLeftSonAtCursor(new String("1"));


        try {
            displaySuccessIfTrue(bt.getSize() == 2);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getLeft().getData().equals("1"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getRight() == null);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getLeft().getParent().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachRightSonAtCursor("2");

        try {
            displaySuccessIfTrue(bt.getRoot().getRight().getParent().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getCursor().getRight().getParent().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.putCursorAtFather();

        try {
            displaySuccessIfTrue(bt.getCursor() == bt.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.putCursorAtRightSon();

        try {
            displaySuccessIfTrue(bt.getCursor().getData().equals("2"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.putCursorAtRightSon();

        try {
            displaySuccessIfTrue(bt.getCursor().getData().equals("2"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.putCursorAtFather();

        try {
            displaySuccessIfTrue(bt.getCursor().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachLeftSonAtCursor(new String("3"));

        try {
            displaySuccessIfTrue(bt.getCursor().getLeft().getData().equals("1"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.pruneFromCursor();

        try {
            displaySuccessIfTrue(bt.getCursor() == bt.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getSize() == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachLeftSonAtCursor("0");

        try {
            displaySuccessIfTrue(bt.getRoot().getData().equals("0"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.pruneFromCursor();

        try {
            displaySuccessIfTrue(bt.getSize() == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot() == null && bt.getCursor() == null);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt.attachLeftSonAtCursor("0");
        bt.attachLeftSonAtCursor("1");
        bt.attachRightSonAtCursor("2");
        bt.putCursorAtLeftSon();
        bt.attachLeftSonAtCursor("3");
        bt.attachRightSonAtCursor("4");
        bt.pruneFromCursor();

        try {
            displaySuccessIfTrue(
                bt.getRoot().getData().equals("0") && 
                bt.getCursor() == bt.getRoot() && 
                bt.getRoot().getLeft() == null && 
                bt.getRoot().getRight().getData().equals("2")
                );
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    

    

    

    public static void test_Constructor() {

        BinaryTree bt = new BinaryTree();
      
        try {
            displaySuccessIfTrue(bt.getSize() == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot() == null);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getCursor() == null);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        bt = new BinaryTree(new String("Test"));

        try {
            displaySuccessIfTrue(bt.getCursor().getData().equals("Test"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getRoot().getData().equals("Test"));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(bt.getSize() == 1);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }
}
