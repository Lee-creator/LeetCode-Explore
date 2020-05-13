package Demo;

public class 有序和后序遍历构造二叉树 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(postorder.length==0)return null;
	        
	        int value=postorder[postorder.length-1];
	        int index;
	        for(index=0;index<inorder.length;index++){
	            if(inorder[index]==value)break;
	        }
	        TreeNode root=new TreeNode(value);
	        
	        int left_in[]=new int [index];
	        int left_post[]=new int [index];
	        for(int i=0;i<index;i++){
	            left_in[i]=inorder[i];
	            left_post[i]=postorder[i];
	        }
	        int right_in[]=new int [postorder.length-1-index];
	        int right_post[]=new int [postorder.length-1-index];
	        for(int i=0;i<postorder.length-1-index;i++){
	            right_in[i]=inorder[index+1+i];
	            right_post[i]=postorder[index+i];
	        }
	        root.left=buildTree(left_in,left_post);
	        root.right=buildTree(right_in,right_post);
	        return root;
	}
	}
}
