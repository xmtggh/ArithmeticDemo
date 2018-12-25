public class main {
    //test
    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int result = lcs(str1, str2);
        System.out.println(result);
    }


    /**
     * 最长递增数列
     * @param arr
     * @return
     */
    public static int lis(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        return lis(arr, arr.length);
    }

    private static int lis(int[] arr, int length){
        int lis[] = new int[length];

        //init
        for(int i = 0; i < length; i++)
            lis[i] = 1;

        for(int i = 1; i < length; i++)
        {
            for(int j = 0; j < i; j++)
            {
//                lis[i]=Math.max(lis[i-1], lis[i-1]+1);
                if(arr[i] > arr[j] && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1;
            }
        }

        int max = lis[0];
        for(int i = 1; i < length; i++)
            if(max < lis[i])
                max = lis[i];
        return max;
    }

    //求解str1 和 str2 的最长公共子序列
    public static int lcs(String str1, String str2) {
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for (int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

        for (int i = 1; i <= str1.length(); i++)
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    c[i][j] = c[i - 1][j - 1] + 1;
//                else if (c[i][j - 1] > c[i - 1][j])
//                    c[i][j] = c[i][j - 1];
                else
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        return c[str1.length()][str2.length()];
    }

    public static int knapsackChoose(int[] value,int[] weight,int maxWeight){
        int[][] m = new int[value.length][weight.length];

        return 0;
    }

}
