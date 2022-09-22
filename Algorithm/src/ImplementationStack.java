import java.util.ArrayList;

public class ImplementationStack {
    // 스택 직접 구현해보기
    private ArrayList<Integer> listStack = new ArrayList<Integer>();

    public void push(Integer data) {
        listStack.add(data);
    }
    public Integer pop() {
        if(listStack.size() == 0) return null;

        return listStack.remove(listStack.size()-1);
    }
    public int size() {
        return listStack.size();
    }
    public Integer peek() {
        if(listStack.size() == 0) return null;

        return listStack.get(listStack.size()-1);
    }
    public String show() {
        return listStack.toString();
    }
    public void clear() {
        listStack.clear();
    }
}
