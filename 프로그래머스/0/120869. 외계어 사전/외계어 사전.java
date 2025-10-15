class Solution {
    public int solution(String[] spell, String[] dic) {        
        for(int i = 0; i < dic.length; i++) {
            int index = 0;
            for(int j = 0; j < spell.length; j++) {
                if(dic[i].contains(spell[j])) {
                    index++;
                }
                if(index == spell.length) {
                    return 1;
                }
            }
        }
        
        return 2;
    }
}