class Solution {
    // helper class for union find algorithm
    public class UnionFind {
        private int[] parent;
        
        private UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // parent of someone is itself by default
            }
        }
        
        private int getAbsoluteParent(int i) {
            if (parent[i] == i) return i;
            parent[i] = getAbsoluteParent(parent[i]); // keep checking parent
            return parent[i];
        }
        
        private void unify(int i, int j) {
            int absoluteParentI = getAbsoluteParent(i);
            int absoluteParentJ = getAbsoluteParent(j);   
            
            if (absoluteParentI < absoluteParentJ) {
                parent[absoluteParentJ] = absoluteParentI;
            } else {
                parent[absoluteParentI] = absoluteParentJ;
            }
        }
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        UnionFind uf = new UnionFind(26);
        
        for (int i = 0; i < s1.length(); i++) {
            
            int ch1 = s1.charAt(i) - 'a';
            int ch2 = s2.charAt(i) - 'a';
            
            uf.unify(ch1, ch2);
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < baseStr.length(); i++) {
            char curr = baseStr.charAt(i);
            int parent = uf.getAbsoluteParent(curr - 'a');
            result.append((char) (parent+'a'));
        }
        
        return result.toString();
    }
}

/*
s1 = "parker", s2 = "morris"

p -> m
a -> o
r -> r
k -> r
e -> i
r -> s

[p,m], [a,o], [r, k, s], [e, i]
*/