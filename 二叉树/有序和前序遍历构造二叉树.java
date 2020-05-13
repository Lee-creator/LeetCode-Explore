package Demo;

public class 有序和前序遍历构造二叉树 {
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
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	                if(preorder.length==0)return null;
	        
	        int value=preorder[0];
	        int index;
	        for(index=0;index<inorder.length;index++){
	            if(inorder[index]==value)break;
	        }
	        TreeNode root=new TreeNode(value);
	        
	        int left_in[]=new int [index];
	        int left_pre[]=new int [index];
	        for(int i=0;i<index;i++){
	            left_in[i]=inorder[i];
	            left_pre[i]=preorder[i+1];
	        }
	        int right_in[]=new int [preorder.length-1-index];
	        int right_pre[]=new int [preorder.length-1-index];
	        for(int i=0;i<preorder.length-1-index;i++){
	            right_in[i]=inorder[index+1+i];
	            right_pre[i]=preorder[index+1+i];
	        }
	        root.left=buildTree(left_pre,left_in);
	        root.right=buildTree(right_pre,right_in);
	        return root;
	    }
	
	}
}
