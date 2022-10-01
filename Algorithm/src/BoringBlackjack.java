public class BoringBlackjack {
    public static void main(String[] args) {
        int output = boringBlackjack(new int[]{1, 2, 3, 4});
        System.out.println(output); // 1
    }
    public static int boringBlackjack(int[] cards) {
        // TODO:
        int count = 0;
        // for문(첫 번째 카드 뽑기)
        for(int i=0; i<cards.length; i++) {
            // for문(두 번째 카드 뽑기)
            for(int j=0; j<cards.length; j++) {
                // for문(세 번째 카드 뽑기)
                for(int k=0; k<cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    for(int l=2; l<sum; l++) {
                        if(sum%l == 0) return count++;
                    }
                }
            }
        }
        return count;
    }
}