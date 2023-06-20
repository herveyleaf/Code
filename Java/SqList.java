package Java;

public class SqList {
    private Object[] listElem;
    private int curLen;

    public SqList(int maxSize){
        curLen = 0;
        listElem = new Object[maxSize];
    }

    public void clear(){
        curLen = 0;
    }

    public boolean isEmpty(){
        return curLen == 0;
    }

    public int length(){
        return curLen;
    }

    public Object get(int i) throws Exception{
        if(i < 0 || i > curLen - 1)
            throw new Exception("第" + i + "个元素不存在");
        return listElem[i];
    }

    public void insert(int i, Object x) throws Exception{
        if(curLen == listElem.length)
            throw new Exception("顺序表已满");
        if(i < 0 || i > curLen)
            throw new Exception("插入位置不合法");
        for(int j = curLen; j > i; j--){
            listElem[j] = listElem[j - 1];
        }
        listElem[i] = x;
        curLen++;
    }

    public void remove(int i) throws Exception{
        if(i < 0 || i > curLen - 1)
            throw new Exception("第" + i + "个元素不存在");
        for(int j = i; j < curLen; j++){
            listElem[j] = listElem[j + 1];
        }
        curLen--;
    }

    public int indexOf(Object x){
        int j = 0;
        while(j < curLen && !listElem[j].equals(x))
            j++;
        if(j < curLen)
            return j;
        else
            return -1;
    }

    public void display(){
        for(int j = 0; j < curLen; j++){
            System.out.print(listElem[j] + " ");
        }
        System.out.println();
    }
}
