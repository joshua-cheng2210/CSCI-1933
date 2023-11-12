public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void printInorder() {
        printInOrderHelper(root);
    }
//    left, up, right

    private void printInOrderHelper(Node<V> node) {
        if (node == null){
            return ;
        }
        if (node.getLeft() != null){
            printInOrderHelper(node.getLeft());
        }
        System.out.print(node.getValue() + " ");

        if (node.getRight() != null){
            printInOrderHelper(node.getRight());
        }
    }

    public void printPreorder(){
        printPreorderHelper(root);
    }
//    up, left, right
    private void printPreorderHelper(Node<V> node) {
        if (node == null){
            return ;
        }
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null){
            printPreorderHelper(node.getLeft());
        }
        if (node.getRight() != null){
            printPreorderHelper(node.getRight());
        }

    }

    public void printPostorder() {
        printPostorderHelper(root);
    }
//    left, right, up
    private void printPostorderHelper(Node<V> node) {
        if (node == null){
            return ;
        }
        if (node.getLeft() != null){
            printPostorderHelper(node.getLeft());
        }
        if (node.getRight() != null){
            printPostorderHelper(node.getRight());
        }
        System.out.print(node.getValue() + " ");
    }

    public V[] flatten() {
        int index_size = count(this.root);
        if (index_size == 0){
            return null;
        }
        V[] out = (V[]) new Comparable[index_size];
        int index = 0;
        get_unordered_element(this.root, out);
        sort(out);
        return out;
    }
    private void get_unordered_element(Node<V> node, V[] out) {
        if (node == null){
            return ;
        }
        if (node.getLeft() != null){
            get_unordered_element(node.getLeft(), out);
        }
        if (node.getRight() != null){
            get_unordered_element(node.getRight(), out);
        }
        for (int i = 0; i < out.length; i++){
            if (out[i] == null){
                out[i] = node.getValue();
                break;
            }
        }
    }
    private int count(Node<V> node){
        int out = 0;
        if (node == null){
            return 0;
        } else {
            out += 1;
            if (node.getLeft() != null){
                out += count(node.getLeft());
            }
            if (node.getRight() != null){
                out += count(node.getRight());
            }
        }
        return out;
    }

    // bubble sort
    // useful for flatten
    public void sort(Comparable[] a) {
        int i, j;
        Comparable temp;
        boolean swapped = true;
        for (i = 0; i < a.length && swapped == true; i++) {
            swapped = false;
            for (j = 1; j < a.length - i; j++) {
                if (a[j].compareTo(a[j-1]) < 0) {
                    swapped = true;
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public void invert() {
        invertHelper(root);
    }

    public Node<V> invertHelper(Node<V> node) {
        if (node.getLeft() != null && node.getRight() != null){
            Node<V> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
        if (node.getLeft() != null){
            invertHelper(node.getLeft());
        }
        if (node.getRight() != null){
            invertHelper(node.getRight());
        }
        return node;
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        if (other == null){return true;}
        if (containsSubtreehelper(this.root, other.getRoot()) == true){
            return true;
        }
        return false;
    }

    private boolean containsSubtreehelper(Node<V> node, Node<V> other){
        if (node == null){
            return false;
        }
        if (containsSubtreehelper2(node, other)){
            return true;
        }

        return containsSubtreehelper(node.getLeft(), other) || containsSubtreehelper(node.getRight(), other);
    }

    private boolean containsSubtreehelper2(Node<V> node, Node<V> other){
        if (node ==null && other == null){
            return true;
        }
        if (node == null || other == null){
            return false;
        }
        return node.getValue() == other.getValue() && containsSubtreehelper2(node.getLeft(), other.getLeft()) && containsSubtreehelper2(node.getRight(), other.getRight());
    }
    
    public void merge(BinaryTree<V> other) {
        // TODO: Fill in definition (honors milestone only)
        return;
    }

    // Main contains tests for each milestone.
    // Do not modify existing tests.
    // Un-comment tests by removing '/*' and '*/' as you move through the milestones.
    public static void main (String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));
//
        // Milestone 1 (Traversing)
        System.out.println("--- Milestone 1 ---");
        System.out.print("Expected: 4 2 5 1 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 2 4 5 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 4 5 2 3 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();

        // Milestone 2 (flatten) -- expected output: 1 2 3 4 5

        System.out.println(System.lineSeparator() + "--- Milestone 2 ---");
        System.out.print("Expected: 1 2 3 4 5" + System.lineSeparator() + "Actual: ");

        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();


        // Milestone 3 (invert)

        System.out.println(System.lineSeparator() + "--- Milestone 3 ---");

        p1Tree.invert();
//
        System.out.print("Expected: 3 1 5 2 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 3 2 5 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 3 5 4 2 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();


        // Milestone 4 (containsSubtree)

        System.out.println(System.lineSeparator() + "--- Milestone 4 ---");

        p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p2Tree));
        System.out.println();

        System.out.print("Expected: false" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p3Tree));
        System.out.println();

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p4Tree));

        
        /*
        // Milestone 5 (merge) *HONORS SECTION*
        System.out.println(System.lineSeparator() + "--- Milestone 5 ---");
        BinaryTree<Integer> p5Tree = new BinaryTree<>(new Node<>(10,
                new Node<>(7,
                        new Node<>(1, null, null),
                        new Node<>(5, null, null)),
                new Node<>(3,
                        new Node<>(9, null, null),
                        null)));
        BinaryTree<Integer> p6Tree = new BinaryTree<>(new Node<>(6,
                new Node<>(7,
                        new Node<>(-3, null, null),
                        new Node<>(6, null, null)),
                new Node<>(4,
                        null,
                            new Node<>(9,
                                new Node<>(4, null, null),
                                    null))));
        BinaryTree<Integer> p7Tree = new BinaryTree<>(new Node<>(10,
                new Node<>(7,
                        new Node<>(1, null, null),
                        new Node<>(6, null, null)),
                new Node<>(4,
                        new Node<>(9, null, null),
                        new Node<>(9,
                                new Node<>(4, null, null),
                                null))));
        p5Tree.merge(p6Tree);
        System.out.print("Expected: ");
        p7Tree.printPreorder();
        System.out.print("\nActual: ");
        p5Tree.printPreorder();
        System.out.println();
        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p5Tree.containsSubtree(p7Tree));
        System.out.println();
         */
    }
}