
    public class CountSingularSocks {
        public static void main(String[] args) {
            int[] arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20};
            int singularCount = countSingularSocks(arrNum);
            System.out.println("Count of singular socks = " + singularCount);
        }
    
        public static int countSingularSocks(int[] arr) {
            int maxSockId = 0;
    
            // Find the maximum sock ID to determine the array size
            for (int sock : arr) {
                if (sock > maxSockId) {
                    maxSockId = sock;
                }
            }
    
            int[] sockCounts = new int[maxSockId + 1];
    
            // Count the occurrences of each sock ID in the array
            for (int sock : arr) {
                sockCounts[sock]++;
            }
    
            int singularCount = 0;
            for (int count : sockCounts) {
                singularCount += count % 2;
            }
    
            return singularCount;
        }
    }
    
    

