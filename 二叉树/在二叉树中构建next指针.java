package Demo;

public class 在二叉树中构建next指针 {
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	*/

	class Solution {
	    public Node connect(Node root) {
	       if (root == null) {
	            return root;
	        }

	        Node parent = root;
	        Node pre;
	        Node next;
	        while (parent != null) {
	            pre = null;
	            next = null;
	            while (parent != null) {
	                if (next == null){
	                    next = (parent.left != null) ? parent.left: parent.right;
	                }

	                if (parent.left != null){
	                    if (pre != null) {
	                        pre.next = parent.left;
	                        pre = pre.next;
	                    } else {
	                        pre = parent.left;
	                    }
	                }

	                if (parent.right != null) {
	                    if (pre != null) {
	                        pre.next = parent.right;
	                        pre = pre.next;
	                    } else {
	                        pre = parent.right;
	                    }
	                }
	                parent = parent.next;
	            }
	            parent = next;
	        }
	 
	    return root;
	    }
	}
}
