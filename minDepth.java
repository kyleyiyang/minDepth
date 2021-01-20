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
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        return (root.left!=null && root.right!=null) ? (Math.min(minDepth(root.left),minDepth(root.right))+1) :(Math.max(minDepth(root.left),minDepth(root.right))+1);
    }
}
// BFS
public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr != null){
                    if(curr.left == null && curr.right == null)
                        return depth;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            depth++;
         }
        return depth;
    }
