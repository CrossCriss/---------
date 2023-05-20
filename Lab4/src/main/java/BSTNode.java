public class BSTNode {
    private int key;
    private String value;
    private BSTNode left;
    private BSTNode right;
    private int nodeCount;

    public BSTNode() {
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
        this.nodeCount = 0;
    }

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        nodeCount = 1; // Initialized to 1 for the current node
    }

    public void insert(int key, String value) {
        if (key == this.key) {
            this.value = value; // Update value if key already exists
        } else if (key < this.key) {
            if (left == null) {
                left = new BSTNode(key, value);
            } else {
                left.insert(key, value);
            }
        } else {
            if (right == null) {
                right = new BSTNode(key, value);
            } else {
                right.insert(key, value);
            }
        }
        nodeCount++; // Increment nodeCount after insertion
    }

    public void remove(int key) {
        BSTNode parent = null;
        BSTNode current = this;
        boolean isLeftChild = false;

        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return; // Node with the given key not found, nothing to remove
        }

        // Case 1: Node to be removed has no children
        if (current.left == null && current.right == null) {
            if (current == this) {
                // Removing the root node
                this.key = 0;
                this.value = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        // Case 2: Node to be removed has only one child
        else if (current.right == null) {
            if (current == this) {
                // Removing the root node with a left child
                this.key = current.left.key;
                this.value = current.left.value;
                this.left = current.left.left;
                this.right = current.left.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } else if (current.left == null) {
            if (current == this) {
                // Removing the root node with a right child
                this.key = current.right.key;
                this.value = current.right.value;
                this.left = current.right.left;
                this.right = current.right.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        // Case 3: Node to be removed has two children
        else {
            BSTNode successor = getSuccessor(current);
            if (current == this) {
                // Removing the root node with two children
                this.key = successor.key;
                this.value = successor.value;
            } else {
                if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
        }
        nodeCount--; // Decrement nodeCount after removal
    }

    public String search(int key) {
        if (key == this.key) {
            return value;
        } else if (key < this.key) {
            return left != null ? left.search(key) : null;
        } else {
            return right != null ? right.search(key) : null;
        }
    }

    public void traverse() {
        if (left != null) {
            left.traverse();
        }
        System.out.println(key + ": " + value);
        if (right != null) {
            right.traverse();
        }
    }

    public int getNodeCount() {
        return nodeCount;
    }

    private BSTNode getSuccessor(BSTNode node) {
        BSTNode successorParent = node;
        BSTNode successor = node;
        BSTNode current = node.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }

        successor.left = node.left;

        return successor;
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(5, "5");

        System.out.println("Inserting values into BST...");
        root.insert(3, "3");
        root.insert(7, "7");
        root.insert(10, "10");
        root.insert(4, "4");
        root.insert(1, "1");
        root.insert(9, "9");
        root.insert(13, "13");
        root.insert(6, "6");
        root.insert(2, "2");
        root.insert(12, "12");
        root.insert(14, "14");

        System.out.println("Traversing BST...");
        root.traverse();

        System.out.println("Node count: " + root.getNodeCount());
    }
}