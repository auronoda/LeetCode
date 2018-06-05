/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    Iterator<Integer> i;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = flat(nestedList);
        i = list.iterator();
    }

    @Override
    public Integer next() {
        return i.next();
    }

    @Override
    public boolean hasNext() {
        return i.hasNext();
    }
    
    private List<Integer> flat(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        for (NestedInteger cur: nestedList) {
            if (cur.isInteger()) {
                res.add(cur.getInteger());
            }
            else {
                res.addAll(flat(cur.getList()));
            }
        }
        return res;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
