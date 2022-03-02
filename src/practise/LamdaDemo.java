package practise;

interface A{
	void show();
}

public class LamdaDemo {

	public static void main(String args[]){
		//Traditional method using a lot of 
		/*practise.A obj=new practise.A(){
			public void show(){
				System.out.println("Pn"); 
			}
		};*/
		
		A obj =()->System.out.println("Panda");
		obj.show();
	
	}
}
