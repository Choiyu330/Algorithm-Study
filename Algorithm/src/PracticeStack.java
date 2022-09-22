import java.util.*;

public class PracticeStack {
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // 시작
        current.add(start);

        // 이전 페이지 돌아가기
        // 조건 : actions 배열 중 "-1"이 있고 이전 페이지가 존재해야 한다
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == "-1" && !prevStack.empty()) {
                // 위 조건이 참일 때, 이전페이지를 꺼내 변수에 저장
                String prevPage = prevStack.pop();
                // 현재 페이지를 꺼내고 다음페이지에 저장
                nextStack.push(current.pop());
                // 변수(이전페이지 값)를 현재 페이지에 저장
                current.push(prevPage);
            }

            // 다음 페이지 넘어가기
            // 조건 : actions 배열중 "1"이 있고 다음 페이지가 존재해야 한다
            else if (actions[i] == "1" && !nextStack.empty()) {
                // 위 조건이 참일 때, 다음 페이지를 꺼내 변수에 저장
                String nextPage = nextStack.pop();
                // 현재 페이지를 꺼내고 이전페이지에 저장
                prevStack.push(current.pop());
                // 변수(다음페이지 값)를 현재 페이지에 저장
                current.push(nextPage);
            }
            // 비활성화 시
            else if (actions[i] == "1" || actions[i].equals("-1")) {
            }
            // 새로운페이지 접속하기
            else {
                // 현재 페이지를 꺼내 이전 페이지에 저장
                prevStack.push(current.pop());
                // 현재 페이지에 입력된 배열 저장
                current.push(actions[i]);
                // 다음 페이지 비우기
                nextStack.clear();
            }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
    }
}
