/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "[]";
       List <TreeNode>queue=new ArrayList<>();
        queue.add(root);
        for(int i=0;i<queue.size();i++){
            if(queue.get(i)==null)continue;
            queue.add(queue.get(i).left);queue.add(queue.get(i).right);
        }
        //while(queue.get(queue.size()-1)==null)queue.remove(queue.size()-1);
    StringBuilder sb=new StringBuilder();
        sb.append("[").append(queue.get(0).val);
    for(int i=1;i<queue.size();i++){
        if(queue.get(i)==null)sb.append(",null");
        else sb.append(","+queue.get(i).val);
    }
        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if(data.equals("[]"))return null;
        String [] tmp=data.substring(1,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(tmp[0]));
        ArrayList <TreeNode> queue=new ArrayList<>();
        queue.add(root);
        int index=0;boolean isLeft=true;
        for(int i=1;i<tmp.length;i++){
            if(!tmp[i].equals("null")){
             TreeNode t=new TreeNode(Integer.parseInt(tmp[i]));
                queue.add(t);
                if(isLeft){
                    queue.get(index).left=t;
                }else queue.get(index).right=t;

        }
        if(!isLeft)index++;
                isLeft=isLeft?false:true;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
