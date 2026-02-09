class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> orgStrs=new ArrayList<>();
        Collections.addAll(orgStrs,strs);
        List<List<String>> res=new ArrayList<>();
        
        while(orgStrs.size()!=0){
            List<String> anagrams=new ArrayList<>();
            String s1=orgStrs.get(0);
            anagrams.add(s1);
            for(int i=1;i<orgStrs.size();i++){
                String s2=orgStrs.get(i);
                if(isAnagrams(s1,s2)){
                    anagrams.add(s2);
                }
            }
            orgStrs.removeAll(anagrams);
            res.add(anagrams);
        }
        return res;
    }

    boolean isAnagrams(String s1,String s2){
        if(s1.length()==s2.length()){
            HashMap<Character,Integer> charCount=new HashMap<Character,Integer>();
            for(int i=0;i<s1.length();i++){
                char c1=s1.charAt(i);
                char c2=s2.charAt(i);
                if(charCount.containsKey(c1)){
                    charCount.put(c1,charCount.get(c1)+1);
                }
                else{
                    charCount.put(c1,1);
                }
                if(charCount.containsKey(c2)){
                    charCount.put(c2,charCount.get(c2)-1);
                }
                else{
                    charCount.put(c2,-1);
                }
            }
            for(Character ch:charCount.keySet()){
                if(charCount.get(ch)!=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}