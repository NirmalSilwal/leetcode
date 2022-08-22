public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
List<List<Integer>> levelOrder = new ArrayList<>();
if (root == null) return levelOrder;
dfs(root, 0, levelOrder);
return levelOrder;
}
private void dfs(TreeNode root, int currLevel, List<List<Integer>> levelOrder) {
if (root == null) return;
if (levelOrder.size() < level) {
levelOrder.add(new ArrayList<>());
}
}