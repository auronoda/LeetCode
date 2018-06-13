/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee cur: employees) {
            map.put(cur.id, cur);
        }
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
        Employee cur = map.get(id);
        int res = cur.importance;
        for (int next: cur.subordinates) {
            res += dfs(map, next);
        }
        return res;
    }
}
