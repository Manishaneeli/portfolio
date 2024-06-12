import java.util.*;
import java.io.*;


class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int d) {
        data = d;
        left = right = null;
    }
}

class Main {

    static List<List<Integer>> levelOrder(BSTNode r) {
        List<List<Integer>> outer = new ArrayList<>();
        if (r == null) {
            return outer;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(r);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> inner = new ArrayList<>();
            while (sz-- > 0) {
                BSTNode temp = q.remove();
                inner.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }

            }
            outer.add(new ArrayList(inner));
        }
        return outer;
    }

    public static List<Integer> getZigZagLevel(BSTNode root) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> out = levelOrder(root);
        boolean flag = false;
        ans.addAll(out.get(0));
        for (int i = 1; i < out.size(); i++) {
            List<Integer> level = out.get(i);
            if (flag) {
                for (int j = level.size() - 1; j >= 0; j--) {
                    ans.add(level.get(j));
                }
                flag = false;

            } else {
                ans.addAll(level);
                flag = true;
            }
        }
        return ans;
    }

    static BSTNode insert(BSTNode r, int x) {
        if (r == null)
            return new BSTNode(x);
        else if (x < r.data) {
            r.left = insert(r.left, x);

        } else {
            r.right = insert(r.right, x);
        }
        return r;
    }

    static BSTNode create_BST(int[] arr) {
        BSTNode root = null;
        for (int x : arr) {
            root = insert(root, x);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            BSTNode ro = create_BST(a);
            List<Integer> res = getZigZagLevel(ro);
            for (int d : res) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
