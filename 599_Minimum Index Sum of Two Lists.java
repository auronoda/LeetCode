class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        
        List<String> list = new ArrayList<>();
        int index = Integer.MAX_VALUE;
        
        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int cur = i + map.get(list2[i]);
                if (cur < index) {
                    index = cur;
                    list = new ArrayList<>();
                }
                if (cur == index) {
                    list.add(list2[i]);
                }
            }
        }
        
        String[] res = new String[list.size()]; 
        return list.toArray(res);
    }
}
