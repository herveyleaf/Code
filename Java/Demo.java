package Java;

public class Demo{
    public static void main(String[] args) throws Exception{
        SqList L = new SqList(10);
		L.insert(0, 'a');
		L.insert(1, 'z');
		L.insert(2, 'd');
		L.insert(3, 'm');
		L.insert(4, 'z');
		int order = L.indexOf('z');
		if(order != -1)
			System.out.println("顺序表中第一次出现的值为'z'的数据元素的位置为："+ order);
		else
			System.out.println("此顺序表中不包含值为'z'的数据元素!");
    }
}