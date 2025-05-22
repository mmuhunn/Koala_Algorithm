import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class luck_balance {
    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {

        int luck = 0;
        List<List<Integer>> important = new ArrayList<>();
        for(List<Integer> contest: contests){
            if(contest.get(1)==0){
                luck += contest.get(0);
            }else{
                important.add(contest);
            }
        }
        Collections.sort(important, (a, b) -> b.get(0) - a.get(0));

        for(List<Integer> ip: important){
            if(k >0){
                luck += ip.get(0);
                k--;
            }else{
                luck -= ip.get(0);
            }
        }
        return luck;

    }

}

