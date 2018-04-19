package com.yy.datastructure.Link;

/**
 * 单向链表
 *
 * @author yangy
 * @time 2018-04-19 11:08
 **/
public class LinkList {
    private Link first;

    public void insert(int id,String name){
        Link link=new Link(id,name);
        link.setNext(first);
        first=link;
    }
    public void remove() throws Exception {
        if(first==null){
            throw new Exception("is empty");
        }
        first= first.getNext();
    }
    public boolean removeById(int id){
        Link current =first;
        Link previous = first;
        while(current.getId()!=id&&current.getNext()!=null){
            previous=current;
            current=current.getNext();
        }
        if(current.getId()==id&&current.getNext()==null){
            previous.setNext(null);
            return true;
        }
        if(current.getNext()==null){
            return false;
        }
        return false;
    }
    public boolean isEmpty(){
        return first == null;
    }

}
