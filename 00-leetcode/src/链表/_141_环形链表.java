package 链表;
/**
 * 	定义一个方法: 功能是判断的给定的链表是否末节点有环,有环返回true, 没有环返回false
 * @author one
 *
 */
public class _141_环形链表 {
	
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next ==null) {
			return false;
		}
		//定义快慢指针,如果有环,快慢指针肯定会相遇,如果没有环,快指针肯定最后会为null;
		//一定不要在循环中定义或者声明一个变量,这样每次循环都创建一个变量,注意变量的作用域
		ListNode slow = head;
		ListNode quick = head;
		while(true) {
			try {
				slow = slow.next;
				quick = quick.next.next;
			} catch(NullPointerException exception) {
				return false;
			}
			if(slow == quick) {
				return true;
			}
		}
		
    }
	
}
