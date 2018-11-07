package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class LCASolution {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static Node lca(Node root, int v1, int v2) {
        Deque<Node> pathForV1 = new ArrayDeque<>();
        find(root, pathForV1, v1);

        while(  !pathForV1.isEmpty()) {
            Node currentNode = pathForV1.pop();
            boolean found = find(currentNode, new ArrayDeque<>(), v2);
            if( found) {
                return currentNode;
            }
        }

        return null;
    }

    private static boolean find(Node currentNode, Deque<Node> pathForV1, int val) {
        if (currentNode == null) {
            pathForV1.pop();
            return false;
        }

        pathForV1.push(currentNode);

        if( currentNode.data == val) {
            return true;
        } else {
            if(!find(currentNode.left, pathForV1, val)) {
                return find(currentNode.left, pathForV1, val);
            };
        }
        return false;
    }

    public static Node lca2(Node root, int v1, int v2) {
        Deque<Node> pathForV1 = new ArrayDeque<>();
        find(root, v1, pathForV1);

        Deque<Node> pathForV2 = new ArrayDeque<>();
        find(root, v2, pathForV2);

        Node parent = null;

        while(!pathForV1.isEmpty()) {
            Node currentNode = pathForV1.pop();
            if( pathForV2.contains(currentNode) ) {
                parent = currentNode;
                break;
            }
        }

        return parent;
    }

    public static Node find(Node node, int val, Deque<Node> path) {
        if (node == null) {
            path.pop();
            return null;
        }
        path.push(node);
        if( node.data == val) {
            return node;
        } else {
            Node found = find(node.left, val, path);
            if( found == null) {
                found = find(node.right, val, path);
            }
            return found;
        }
    }

    public static Node lca3(Node root, int v1, int v2) {
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();

        findLca(root, v1, v2, arrayDeque);

        return arrayDeque.pop();
    }

    private static void findLca(Node node, int v1, int v2, Deque<Node> nodeDeque) {
        if(node == null) return ;

        if( find3Val(node, v1) && find3Val(node, v2))
            nodeDeque.push(node);

        findLca(node.left, v1, v2, nodeDeque);
        findLca(node.right, v1, v2, nodeDeque);
    }

    private static boolean find3Val(Node node, int val) {
        if( node == null) return false;

        boolean exists = node.data == val;
        if(!exists)
            exists = find3Val(node.left, val);
        if(!exists)
            exists = find3Val(node.right, val);
        return exists;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca3(root,v1,v2);
        System.out.println(ans.data);
    }

    private static String balancedBracket(String expression) {
        Stack<Character> stack = new Stack<>();

        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            if( "[{(".contains(aChar + "") ) {
                stack.push(aChar);
            } else {
                if( stack.isEmpty()) return "NO";
                char previousOpenBracket = stack.pop();
                switch (previousOpenBracket) {
                    case '[':
                        if(']' != aChar) return "NO";
                        break;
                    case '{':
                        if('}' != aChar) return "NO";
                        break;
                    case '(':
                        if(')' != aChar) return "NO";
                        break;
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

}
