import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {
    public static void main(String[] args) {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output);
    }

    static public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // 1초 -> 첫 문서 추가 ->2초 다음 문서 들어올수있나 판단 후 첫 문서 이동, 다음문서 추가 -> ...
        // bufferSize 만큼 시간 추가, 큐에 입력, 다음 입력 받을때 poll안된 값들 + 입력이 cap보다 크면 +1초 - 다음사이클
        Queue<Integer> queprinter = new LinkedList<>(); //프린트목록 큐
        Queue<Integer> quewaiting = new LinkedList<>(); //대기목록 큐
        for (int i = 0; i < bufferSize; i++) queprinter.add(0); //버퍼 0으로 꽉
        for (int i = 0; i < documents.length; i++) quewaiting.add(documents[i]); // 문서 목록
        int time = 0; // 한 사이클당 time++
        int cap = 0;  // printer queue의 현재 용량 - quewating에서 queprinter로 데이터 넘길 때 용량 판단용
        while (!queprinter.isEmpty() || !quewaiting.isEmpty()) {
            time++; //사이클 시작하면서 time++
            cap = cap - queprinter.poll();
            // 대기목록이 비었으면 한 칸씩 이동하기(위 코드 반복)
            if (quewaiting.isEmpty())
                continue;
                // 전체용량 >= 현재 프린트목록 사이즈 + 프린트목록에 들어갈 사이즈일 때
            else if (capacities >= cap + quewaiting.peek()) {
                // 현재 용량에 추가
                cap += quewaiting.peek();
                // 대기 목록 하나 빼고 프린트목록에 추가
                queprinter.add(quewaiting.poll());
            } else { // 전체용량이 초과할 경우
                queprinter.add(0);
            }
        }
        return time;
    }
}