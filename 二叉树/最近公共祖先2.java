/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList <TreeNode> queue =new ArrayList<>();
        queue.add(root);
        for(int i=0;i<queue.size();i++){
            if(queue.get(i)==null)continue;
            queue.add(queue.get(i).left);
            queue.add(queue.get(i).right);
        }
        for(int i=queue.size()-1;i>-1;i--){
            if(has(queue.get(i),p)&&has(queue.get(i),q))
                return queue.get(i);
        }
        return null;
    }
    public boolean has(TreeNode root,TreeNode obj){
        if(root==null)return false;
     if(root==obj)return true;
        return has(root.left,obj)||has(root.right,obj);
}}
