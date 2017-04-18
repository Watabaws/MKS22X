public class MyDeque{
    String[] Dequerray;
    int front, back;


    public boolean checkAdd(int index){
	if(index 

    public String getFirst(){
	return Dequerray[front];
    }

    public String getLast(){
	return Dequerray[end];
    }

    public void addFirst(String bleh){
	if(bleh == null){
	    throw new NullPointerException();
	}
	checkAdd(front+1);
	Dequerray[front+1] = bleh;
	front = front+1 % Dequerray.length;
    }


       
	    

