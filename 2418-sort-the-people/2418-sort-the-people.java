class Solution {
    
    class People {
        String name;
        int height;
        
        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        List<People> list = new ArrayList<>();
        
        // storing each name, height people in People object as single person detail
        for (int i = 0; i < names.length; i++) {
            list.add(new People(names[i], heights[i]));
        }
        
        // sorting by height in descending order
        Collections.sort(list, (p1, p2) -> p2.height - p1.height);
        
        // storing names of people with sorted height
        String[] result = new String[names.length];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).name;
        }
        
        return result;
    }
}