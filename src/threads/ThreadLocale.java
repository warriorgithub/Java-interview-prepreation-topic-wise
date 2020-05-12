package threads;

/*
Suppose we have 1000 of threads which create same type of object so we will have 1000 objects,
to create if do so it will very expensive operations in terms of memory and processing.
So one thing we can do one thing is we can create that object as Eager Initilization  take example those 1000
thread are create of SimpleDateFormate and With ThreadPool of 10 thread we can handle the proble. But wait
SimpleDateFormate is not a thread safe class.
So to overcome these kind of situation we use ThreadLocale. In threadLoacl you will have your own copy so ideally
it will be already syncronized and now we can use thread pool also to create those 1000 objects

Case 2 : Suppose we have service1 -> service2-> service3. And every service has to know which user has sent
the request. To solve this we can create one map and insert the user as it passes from the service but the map
is not synronized to we have to use lock. or We can just use ThreadLocal which with the help of get method
can tell which user called it.

public class UserHolder{
    public static ThreadLocal holder = new ThreadLocal();
}
 class Service1{
    public void process(){
        User usr= getUser(id);
        UserHolder.holder.set(user)
    }
}

class Service2{
    public void process(){
        User us = UserHolder.holder.get()
    }
}
after everything is done we need to remove the object. ThreadLocale has method remove()

SPRING Framework uses lots of Context Holder
LocaleContextHolder
TransitionContextHolder
RequestContextHolder
SecurityContextHolder
DateTimeContextHolder
 */

import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatter{
    public static ThreadLocal<SimpleDateFormat> t = ThreadLocal.withInitial(
                                    ()->new SimpleDateFormat("yyyy-MM-dd"));
}
public class ThreadLocale {
    public static void main(String[] args) {
        getDateFormate();
    }

    public static void getDateFormate(){
        Date joingDate = new Date();
        SimpleDateFormat f = DateFormatter.t.get();
        System.out.println(f.format(joingDate));
    }

}
