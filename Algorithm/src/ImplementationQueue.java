import java.util.*;

public class ImplementationQueue {
    public class Solution {
        private ArrayList<Integer> listQueue = new ArrayList<Integer>();

        public void add(Integer data) {
            listQueue.add(data);
        }

        public Integer poll() {
            if(listQueue.size() == 0) return null;

            return listQueue.remove(0);
            }

        public int size() {
            return listQueue.size();
        }

        public Integer peek() {
            if(listQueue.size() == 0) return null;

            return listQueue.get(0);
        }

        public String show() {
            return listQueue.toString();
        }

        public void clear() {
            listQueue.clear();
        }
    }
}
