package javaapplication8;
 
public class Test {
    private final int capacity;
    int queueArray[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;
 
    public Test(int queueSize){
        this.capacity = queueSize;
        queueArray = new int[this.capacity];
    }
 
   
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow state. Increase capacity.");
            increaseCapacity();
        } else {
            rear++;
            if(rear == capacity-1){
                rear = 0;
            }
            queueArray[rear] = item;
            currentSize++;
            System.out.println("Element " + item+ " is pushed to Queue.");
        }
    }
 
   
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow state.");
        } else {
            front++;
            if(front == capacity-1){
                System.out.println("Removed element: "+queueArray[front-1]);
                front = 0;
            } else {
                System.out.println("Removed element: "+queueArray[front-1]);
            }
            currentSize--;
        }
    }
 
    
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }
 
   
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
 
    private void increaseCapacity(){        
        
        int newCapacity = this.queueArray.length*2;
        int[] newArr = new int[newCapacity];
        int tmpFront = front;
        int index = -1;
        while(true){
            newArr[++index] = this.queueArray[tmpFront];
            tmpFront++;
            if(tmpFront == this.queueArray.length){
                tmpFront = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
       
        this.queueArray = newArr;
        System.out.println("New array capacity: "+this.queueArray.length);
       
        this.front = 0;
        this.rear = index;
    }
 
	public static void main(String args[]){
	  try {
		Test queue = new Test(4);
	        queue.enqueue(41);
	        queue.dequeue();
	        queue.enqueue(6);
	        queue.enqueue(24);
	        queue.enqueue(7);
	        queue.enqueue(4);
	        queue.enqueue(45);
	        queue.dequeue();
		} catch (Exception e) {
		}
	}
}
