
// TC - O(N^2)
// SC - O(N)

public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()){
			return;
		}

  // store the top element
		int top = stack.pop();
  // call the function again
		reverseStack(stack);
  // then jab stack empty ni hojata pop krenge then insertAtBottom Ko call krenge 
  // this will insert the element at bottom
		insertAtBottom(stack,top);
	}

	public static void insertAtBottom(Stack<Integer> stack, int ele){
    
		if(stack.isEmpty()){
			stack.push(ele);
			return;
		}

		int top = stack.pop();
		insertAtBottom(stack, ele);
		stack.push(top);
	}
