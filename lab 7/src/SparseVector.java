public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;

		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode.getValue();
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 2
	public void addElement(int index, double value){
		Node out = new Node(index, value);
		Node currentnode = head;
		int currentindex = 0;

		if (index >= length){
			System.out.println("no such index in the linked list");
			return ;
		} else if (currentnode == null){
			head = out;
			return ;
		} else {
			while (currentnode != null) {
				if (currentnode.getNext() == null){
					currentnode.setNext(out);
					return ;
				} else {
					currentnode = currentnode.getNext();
				}

			}
		}
	}

	// TODO: Implement me for milestone 4

	public static double dot( SparseVector x, SparseVector y ){
		double result = 0.0;
		if (x.length != y.length) {
			return 0.0;
		} else {
			Node xNode = x.head;
			Node yNode = y.head;
			if (x.head == null || y.head == null) {
				return 0.0;
			}
			while (xNode != null && yNode != null) {
				int xIndex = xNode.getIndex();
				int yIndex = yNode.getIndex();
				if(xIndex == yIndex){
					result += xNode.getValue() * yNode.getValue();
					xNode = xNode.getNext();
					yNode = yNode.getNext();
				} else if (xIndex > yIndex) {
					yNode = yNode.getNext();
				} else{
					xNode = xNode.getNext();
				}

			}
		}
		return result;
	}

	// TODO: Test out your code here!
	public static void main(String[] args) {
//		SparseVector vec = new SparseVector(9);
//		vec.addElement(1, 25.0);
//		vec.addElement(7, -11.2);
//		vec.addElement(8, 32.0);
//		System.out.println(vec);

		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println(result);
	}
}


