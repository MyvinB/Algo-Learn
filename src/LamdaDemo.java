interface A{
	void show();
}

public class LamdaDemo {

	public static void main(String args[]){
		//Traditional method using a lot of 
		/*A obj=new A(){
			public void show(){
				System.out.println("Pn"); 
			}
		};*/
		
		A obj =()->System.out.println("Panda");
		obj.show();
	
	}
}
