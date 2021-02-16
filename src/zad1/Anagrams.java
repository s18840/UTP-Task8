/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagrams {
    Map<String, List<Integer>> hashMap = new HashMap<>();
    List<List<String>> list = new LinkedList<>();
    List<String> notSortedList;
    List<String> sortedList = new LinkedList<>();
    public Anagrams(String allWords) throws FileNotFoundException {
        StringBuilder sb ;
        sb= new StringBuilder();


        Scanner scanner ;
        scanner= new Scanner(new File(allWords));


        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            //System.out.println("Wypisz");
        }

        this.notSortedList = Arrays.asList(sb.toString().split("\\s"));
        for (String word : this.notSortedList) {
            sortedList.add(sortString(word));
            //System.out.println("Posortowane");
        }
        int size =this.notSortedList.size();
        boolean[] visited = new boolean[size];
        boolean flaga = true;

        for (String word : this.sortedList) {
            int in = this.sortedList.indexOf(word);
            if (!visited[in]) {
                if (!hashMap.containsKey(this.notSortedList.get(in))) {
                    hashMap.put(this.notSortedList.get(in), new LinkedList<>());
                }
                for (int i = 1; i < this.notSortedList.size(); i++) {
                    if (word.equals(this.sortedList.get(i)) && !visited[i]) {
                        visited[i] = flaga;
                        hashMap.get(this.notSortedList.get(in)).add(i);
                    }
                }
            }
        }

        Set<Map.Entry<String, List<Integer>>> entrySet = hashMap.entrySet();

        for (Map.Entry<String, List<Integer>> entry : entrySet) {
            List<String> words = new LinkedList<>();
            for (Integer i : entry.getValue()) {
                words.add(this.notSortedList.get(i));
            }
            list.add(words);
        }

    }

    public Anagrams() {
    }

    public Anagrams(Map<String, List<Integer>> map, List<List<String>> list, List<String> notSortedList, List<String> sortedList) {
        this.hashMap = map;
        this.list = list;
        this.notSortedList = notSortedList;
        this.sortedList = sortedList;
    }

    public Map<String, List<Integer>> getMap() {
        return hashMap;
    }

    public void setMap(Map<String, List<Integer>> map) {
        this.hashMap = map;
    }

    public List<List<String>> getList() {
        return list;
    }

    public void setList(List<List<String>> list) {
        this.list = list;
    }

    public List<String> getNotSortedList() {
        return notSortedList;
    }

    public void setNotSortedList(List<String> notSortedList) {
        this.notSortedList = notSortedList;
    }

    public List<String> getSortedList() {
        return sortedList;
    }

    public void setSortedList(List<String> sortedList) {
        this.sortedList = sortedList;
    }

    public String getAnagramsFor(String w) {
        String st = w+ ": ";
        List<String> target = null;
        for(List<String> l : list){
            for(String s : l){
                if(s.equals(w)) {
                    target = l;
                    break;
                }
            }
            if(target != null) break;
        }

        target.remove(w);

        return st + target.toString();
    }
    public List<List<String>> getSortedByAnQty() {
        for (List<String> list : this.list) {
            list.sort(Comparator.comparing(String::toString));
        }

        return list;
    }
    static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String srt ;
        srt= String.valueOf(arr);
        return srt;
    }



}  
