/*
We'll say that 2 strings "match" if they are non-empty and their first chars are the same. 
Loop over and then return the given array of non-empty strings as follows: if a string matches 
an earlier string in the array, swap the 2 strings in the array. When a position in the array has been swapped, 
it no longer matches anything. Using a map, this can be solved making just one pass over the array. 
More difficult than it looks.


allSwap(["ab", "ac"]) → ["ac", "ab"]
allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
*/

/*
Hint:
Make a Map<String, Integer> with the first char as the key and the index in the array as the value. 
After doing a swap, remove that key so it won't match anything in the future.
*/

public String[] allSwap(String[] strings) {
  Map<String, Integer> map = new HashMap();
  
  for(int i=0; i <strings.length;i++){
    String first=strings[i].substring(0,1);
    if(!map.containsKey(first))
      map.put(first,i);
    else{
    //swap
      String temp = strings[i];
      strings[i] = strings[map.get(first)];
      strings[map.get(first)] =temp;
      map.remove(first);
    }
  }
  return strings;
}
