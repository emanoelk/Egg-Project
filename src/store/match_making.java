package store;
 
import java.util.*;
 
public class match_making {
    public static ArrayList<String> tokenizer(String query) {
        String lw_query = query.toLowerCase();
        ArrayList<String> storage = new ArrayList<String>() ;
        StringTokenizer st = new StringTokenizer(lw_query);
         while (st.hasMoreTokens()) {
             storage.add(st.nextToken());
         }
        return storage;
    }
       
    public static boolean match_check(ArrayList<String> search_query, ArrayList<String> target_query){
        boolean result = false;
        for (int i = 0; i<target_query.size();i++)
        {
            if (target_query.get(i).equals(search_query.get(0)))
            {
                int k = i;
                for(int j = 0; j<search_query.size();j++, k++)
                {
                    if (!target_query.get(k).equals(search_query.get(j)))
                    {
                        result = false;
                        break;
                    }
                    else
                        result = true;
                }
                if (result)
                    return result;
            }
        }
        return result;
    }
}