package 链表;
/**
 * 	需求 : 将链表翻转,之前的首节点变为尾结点,之前的尾结点变成首节点
 * @author one
 *
 */
public class _206_反转链表 {
	
	
	/**
	 * 第一种方法:用递归的方式实现 , 计算有n个节点的链表翻转 和 计算n-1个链表节点的翻转后的首节点相同
	 * 所谓的递归就是:
	 * 		已知  A(n) = f(A(n-1)) 和 A(1),然后求 A(n) 
	 * 			是只要递归表达式收敛且有初始化A(1)的值,它就一定能计算出A(n)
	 * 			递归运用到程序当中就是方法里面调用方法本身,从目标为出发点考虑,用未知调用未知,直到调用已知的数据为止
	 * 		
	 * @param head
	 * @return
	 */
	  public ListNode reverseList(ListNode head) { // 当首节点为空或者只有首节点时,直接返回head
//		  if(head == null || head.next==null) { //当节点数为1时 初始化值 return head; } ListNode
//			  return head;
//		  }
//		  ListNode newHead = reverseList(head.next); 
//		  head.next.next = head; 
//		  head.next = null;
//		  return newHead;
		  
		  //1,写递归调用的出口
		  if(head == null || head.next == null) {
			  return head;
		  } 
		  //2,调用方法本身得到想要的头结点
		  ListNode newHead = reverseList(head.next);   // 这一句是通过迭代方法方法需要返回的结果, 即新的头结点 newHead
		  //3,在获取新的头结点的过程中,还要将节点和节点之前的指向翻转过来
		  head.next.next = head;
		  head.next = null;  
		  return newHead;
	  }
	 

	/**
	 * 第二中方法用迭代的思想实现, 要计算 n各节点的链表翻转,先计算两个节点的翻转,再加入一个节点即三个节点的翻转,这样一直迭代到 n个节点的翻转
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		//1,这是一个节点都没有到情况
		if( head==null) {
			return head;
		}
		//2,这是只有一个节点的情况
		//定义一个新的头结点,最后将该头结点返回
		ListNode newHead = head;
		ListNode temp;           //对任何一个变量进行赋值操作时,都要考虑这个变量原本存储的值有没有用,有用就用一个临时变量先存储这个旧值,没有用就直接覆盖
	    //变量的声明不要放在循环里面,这样会重复创建变量
		head = head.next;        // 只能把对象的地址值赋值给变量,不能把对象变量赋值给对象,所用 = 的左边必须是对象变量,不可能是对象
		newHead.next = null;     // 用 =号进行引用或者赋值时, 我们在操作的都是在目标对象的地址值,是将对象的地址值进行拷贝传递,而不是操作对象本身
		//3,这是有多个节点的情况
		while(head != null) {
			temp = newHead;      //对任何一个变量进行赋值操作时,都要考虑这个变量原本存储的值有没有用,有用就用一个临时变量先存储这个旧值,没有用就直接覆盖
			newHead = head;      // head节点使用完毕了,这次循环不需要使用head了
			head = head.next;
			newHead.next = temp;
		}	
		//返回头结点
		return newHead;
    }

}
