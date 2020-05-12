package oops.comparator;
import java.util.*;
/*
Sort the Developer list with name, if name is same then sort it with language , if language if same then
sort it with city and if city is same then sort it with score.
 */
class Developer{
    String name;
    String language;
    String city;
    int score;
    public Developer(String name,String language,String city, int score){
        this.name = name;
        this.language = language;
        this.city = city;
        this.score = score;
    }
}
public class SortObjects {

    public static void sort(List developerList){
        Collections.sort(developerList,new Comparator<Developer>(){
            public int compare(Developer d1, Developer d2){
                if(d1.name.compareTo(d2.name)==0){
                    if(d1.language.compareTo(d2.language)==0){
                        if(d1.city.compareTo(d2.city)==0){
                            if((d1.score-d2.score)==0){

                            }else{
                                return d1.score-d2.score;
                            }
                        }else{
                            return d1.city.compareTo(d2.city);
                        }
                    }else{
                        return d1.language.compareTo(d2.language);
                    }
                }else{
                    return d1.name.compareTo(d2.name);
                }
                return 0;
            }
        });
    }

    public static void main(String args[]){
        List<Developer> developerList = new ArrayList<>();
        developerList.add(new Developer("Naveen","machine learning","Hyderabad",5));
        developerList.add(new Developer("Shubham","React","Rajasthan",8));
        developerList.add(new Developer("Sandeep","Java","Uttar Pradesh",9));
        developerList.add(new Developer("Preet","Java","Punjab",9));
        developerList.add(new Developer("Naveen","Java","Hyderabad",9));
        developerList.add(new Developer("Naveen","Java","Hyderabad",10));
        developerList.add(new Developer("Preet","Java","Punjab",10));
        developerList.add(new Developer("Sandeep","Java","Punjab",10));
        sort(developerList);
        for(Developer d : developerList){
            System.out.println(d.name +" "+d.language+" "+d.city+ " "+d.score);
        }
    }
}
